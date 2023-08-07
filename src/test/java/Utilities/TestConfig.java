package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestConfig
{
	public JSONObject readFromJsonFile(String jsonFilePath) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		Object obj=parser.parse(new FileReader(jsonFilePath));
		JSONObject jsonObject=(JSONObject)obj;
		return jsonObject;
	}
}