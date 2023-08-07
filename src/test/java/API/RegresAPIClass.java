package API;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import Utilities.APIHelperClass;
import Utilities.TestConfig;
import io.restassured.response.Response;

public class RegresAPIClass extends APIHelperClass
{
	TestConfig testConfig=new TestConfig();
	protected static String baseUrl = "https://reqres.in/";
	public RegresAPIClass() {
		super(baseUrl);
	}

	public int createUser(String jsonFilePath) throws FileNotFoundException, IOException, ParseException
	{
		Response response;
		//Read the json body from json file
		JSONObject jsonBody=testConfig.readFromJsonFile(jsonFilePath);		
		String requestPath = "/api/users";
		response = postRequest(requestPath,jsonBody);
		System.out.println(response.getBody().asString());
		return response.statusCode();
	
	}
	public int getUsers()
	{
		Response response;
		String requestPath = "/api/users";
		response=getRequest(requestPath);
		System.out.println(response.getBody().asString());
		return response.statusCode();
	}
}