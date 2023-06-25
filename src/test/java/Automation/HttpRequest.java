package Automation;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.*;

public class HttpRequest
{
	int id;
	
	@Test(enabled=false)
	public void getUser()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();
		
		
	}
	@Ignore
	@Test 
	public void createUser()
	{
		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name", "Ram");
		data.put("job", "Doctor");
		given()
			.contentType("application/json")
			.body(data)
			
		
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201);
	}
	
	@Test(priority=1)
	public void getId()
	{
		
		HashMap<String,String> data=new HashMap<String,String>();
		data.put("name", "Dev");
		data.put("job", "Teacher");
		id=given()
			.contentType("application/json")
			.body(data)
			
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
			
		System.out.println(id);
		
	}
	@Ignore
	@Test(priority=2,dependsOnMethods= {"getId"})
	public void updateUser()
	{

		
		when()
			.put("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(dependsOnMethods= {"getId"})
	public void deleteUser()
	{
		when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(204);
		
	}
	
}