package com.thecollector.collections;

import com.thecollector.collections.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erick on 23/06/16.
 */
public class Favorites {
	private static List<Movie> favoritesMovies = new ArrayList<Movie>();

	public List<Movie> getFavoritesMovies() {
		return favoritesMovies;
	}
	public void setFavoritesMovies(List<Movie> favoritesMovies) {
		this.favoritesMovies = favoritesMovies;
	}
}