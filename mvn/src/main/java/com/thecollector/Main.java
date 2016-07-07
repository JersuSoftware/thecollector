package com.thecollector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thecollector.collections.Favorites;
import com.thecollector.collections.Movie;
import com.thecollector.utils.FileManager;
import com.thecollector.utils.MediaRequest;
import com.thecollector.utils.SearchList;

import java.util.List;
import java.util.Scanner;

/**
 * Created by erick on 16/06/16.
 */

public class Main
{
	public static void main(String[] args){
		Gson gson = new Gson();
		String json = new String();
		MediaRequest request = new MediaRequest();
		Scanner scan = new Scanner(System.in);
		SearchList search = new SearchList();
		System.out.println("Welcome");
		FileManager fileManager = new FileManager();
		fileManager.setFileName("favoritesList.txt");
		Favorites favorites = new Favorites();
		String fileList = fileManager.readFile();
		if(!fileList.equals("empty")) {
			TypeToken<List<Movie>> type = new TypeToken<List<Movie>>() {};
			List<Movie> favList = gson.fromJson(fileList, type.getType());
			favorites.setFavoritesMovies(favList);
		}
		while(true) {
			System.out.println("Chose one option of the menu:");
			System.out.println("1 - Search Movie");
			System.out.println("2 - Show Favorites Movies");
			System.out.println("3 - Exit");
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
				case 1:
					System.out.println("Type the movie's name");
					String title = scan.nextLine();
					search.searchMovie(title);
					break;
				case 2:
					System.out.println("Favorites movies list");
					for (Movie movie : favorites.getFavoritesMovies()){
						System.out.println(movie.getTitle());
					}
					break;
				case 3:
					String list = gson.toJson(favorites.getFavoritesMovies());
					fileManager.writeToFile(list);
					System.out.println("Good Bye");
					return;
				default:
					System.out.println("Option not found");
					break;
			}
		}
	}
}
