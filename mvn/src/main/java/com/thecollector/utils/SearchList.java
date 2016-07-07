package com.thecollector.utils;

import com.google.gson.Gson;
import com.thecollector.collections.Favorites;
import com.thecollector.collections.Movie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by erick on 21/06/16.
 */
public class SearchList
{
	private List<Movie> Search = new ArrayList<Movie>();

	public List<Movie> getSearch()
	{
		return Search;
	}

	public void setSearch(List<Movie> search)
	{
		Search = search;
	}

	public void searchMovie(String name){
		Gson gson = new Gson();
		String json = new String();
		MediaRequest request = new MediaRequest();
		request.setTitle(name);
		try {
			json = request.sendGET();
		} catch (IOException e) {
			System.out.println("Erro na busca");
		}
		if (json.contains("Error")) System.out.println("Couldn't find any movie");
		else {
			SearchList searchList = gson.fromJson(json, SearchList.class);
			int index = 0;
			for (Movie movie : searchList.getSearch()) {
				System.out.println(++index + " " + movie.getTitle());
			}
			System.out.println("Chose your favorite movie from the list:");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			Favorites favorites = new Favorites();
			favorites.getFavoritesMovies().add(searchList.getSearch().get(choice-1));
		}
	}
}
