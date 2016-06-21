import com.google.gson.Gson;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by erick on 16/06/16.
 */
public class Main
{
	public static void main(String[] args){
		Gson gson = new Gson();

		Serie serie = new Serie();
		serie.setTitle("teste");
		serie.setYear(2009);
		serie.setRate(10);
		serie.setTeste(10);
		String json = gson.toJson(serie);
		Movie movie = gson.fromJson(json, Movie.class);

		System.out.println("Digite o nome do filme/serie");
		Scanner scan = new Scanner(System.in);
		String title = scan.nextLine();
		title = title.replace(" ", "+");
		MediaRequest request = new MediaRequest();
		request.setTitle(title);
		try
		{
			json = request.sendGET();
		}catch (IOException e){
			System.out.println(e);
		}
		Movie movie2 = gson.fromJson(json, Movie.class);
		System.out.println(movie2.getTitle());
	}
}
