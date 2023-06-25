package Automation;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.*;
import org.testng.annotations.*;

public class DiffWaysToCreatePostRequestBody
{
	@Test
	public void createBodyUsingHashMap()
	{
		HashMap<String, String> data=new HashMap<String, String>();
		data.put("name", "John");
		data.put("job", "singer");
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.body("name",equalTo("John"))
			.body("job",equalTo("singer"))
			.body("createdAt",containsString(LocalDateTime.now().toString()));
			
	}
	
}