/**
 * Created by erick on 16/06/16.
 */
public class Movie
{
	private String Title;
	private int year;
	private float rate;

	public float getRate() { return rate; }

	public void setRate(float rate) { this.rate = rate; }

	public String getTitle()
	{
		return Title;
	}

	public void setTitle(String title)
	{
		this.Title = title;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}
}
