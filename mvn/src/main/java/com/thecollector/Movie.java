package com.thecollector;

/**
 * Created by erick on 16/06/16.
 */
public class Movie
{

	private String Title;
	private String Year;
	private String Released;
	private String Runtime;
	private String Director;
	private float  imdbRating;

	public String getYear(){
		return this.Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getReleased() {
		return Released;
	}

	public void setReleased(String released) {
		Released = released;
	}

	public String getRuntime() {
		return Runtime;
	}

	public void setRuntime(String runtime) {
		Runtime = runtime;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public float getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(float imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getTitle()
	{
		return Title;
	}

	public void setTitle(String title)
	{
		this.Title = title;
	}
}
