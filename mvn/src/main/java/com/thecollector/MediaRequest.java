package com.thecollector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by erick on 21/06/16.
 */
public class MediaRequest
{

	private static final String USER_AGENT = "Mozilla/5.0";

	//private static final String GET_URL = "http://www.omdbapi.com/?t=game+&y=&plot=full&r=json";
	private static final String GET_URL = "http://www.omdbapi.com/?s=";

	private static final String POST_URL = "http://localhost:9090/SpringMVCExample/home";

	private static final String POST_PARAMS = "userName=Pankaj";

	private String title;

	public String sendGET() throws IOException
	{
		URL obj = new URL(GET_URL + title + "&y=&plot=full&r=json");
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK)
		{ // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null)
			{
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		}
		else
		{
			System.out.println("GET request din't work");
		}
		return "Error";
	}

	public void sendPOST() throws IOException
	{
		URL obj = new URL(POST_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);

		// For POST only - START
		con.setDoOutput(true);
		OutputStream os = con.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();
		// For POST only - END

		int responseCode = con.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK)
		{ //success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null)
			{
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		}
		else
		{
			System.out.println("POST request not worked");
		}
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title.replace(" ", "+");
	}
}