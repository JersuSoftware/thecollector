import com.google.gson.Gson;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by erick on 16/06/16.
 */
public class Main
{
	public static void main(String[] args){
		Gson gson = new Gson();
		String json = new String();
		System.out.println("Digite o nome do filme/serie");
		Scanner scan = new Scanner(System.in);
		String title = scan.nextLine();
		MediaRequest request = new MediaRequest();
		request.setTitle(title);
		try
		{
			json = request.sendGET();
		}catch (IOException e){
			System.out.println(e);
		}
		if (json.contains("False")) System.out.println("Erro");
		else
		{
			System.out.println(json);
			SearchList searchList = gson.fromJson(json, SearchList.class);
			System.out.println(searchList.Search.get(0).getTitle());
		}
	}
}
