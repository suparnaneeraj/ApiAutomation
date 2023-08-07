package Utilities;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelperClass {
	int statusCode;
	JSONObject requestParams, responseParams;
	public APIHelperClass(String baseUrl)
	{
		RestAssured.baseURI = baseUrl;
	}

	public Response postRequest(String requestPath, JSONObject data) {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(data);
		Response response = request.post(requestPath);
		return response;
	}
	
	
	public Response getRequest(String requestPath, JSONObject data) {
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(data);
		Response response = request.get(requestPath);
		return response;
	}
	public Response getRequest(String requestPath) {
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		Response response = request.get(requestPath);
		return response;
	}

	public Response putRequest(String requestPath, JSONObject data) {
		Response response;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(data);
		response = request.put(requestPath);
		return response;
	}
	
}