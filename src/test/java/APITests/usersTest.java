package APITests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.Endpoints;
import api.payload.UserData;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class usersTest {
	UserData userpayload;
	
	@BeforeClass
	public void setupData() {
		userpayload = new UserData();
		
		userpayload.setId(3263);
	}
	
	@Test
	public void getTestUser() {
		Response response = Endpoints.getUser(userpayload.getId());
		response.then().log().all();
		
		// Deserialize the Response body
		ResponseBody body = response.getBody();
		UserData payload = body.as(UserData.class);
		
		System.out.println("user name is " + payload.getName());
	}
}
