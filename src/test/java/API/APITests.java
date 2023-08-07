package API;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Test;


public class APITests
{
	RegresAPIClass regresAPIClass=new RegresAPIClass();
	
	@Test
	public void createUserSuccess() throws FileNotFoundException, IOException, ParseException
	{
		String jsonFilePath="testdata//jsonbody//ValidCreateUser.json";
		int statusCode=regresAPIClass.createUser(jsonFilePath);
		Assert.assertEquals(statusCode, 201);
	}
	@Test
	public void getAllUsers()
	{
		int statusCode=regresAPIClass.getUsers();
		Assert.assertEquals(statusCode, 200);
	}

	
}