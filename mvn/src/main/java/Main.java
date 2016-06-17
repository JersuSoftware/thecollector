import com.google.gson.Gson;

import java.io.IOException;

/**
 * Created by erick on 16/06/16.
 */
public class Main
{
	public static void main(String[] args){
		System.out.println("Oi");
		HttpURLConnectionExample http = new HttpURLConnectionExample();
		try
		{
			http.sendGET();
		}catch (IOException e){}
	}
}
