package student;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJson 
{
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		/*parse the Json file*/
		JSONParser p=new JSONParser();
		Object obj=p.parse(new FileReader("C:\\Users\\USER\\Desktop\\Google Drive\\Test1.json"));
		
		/*downcast the obj in to JsonObject, automatically all will be stored in the form*/
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
	}

}
