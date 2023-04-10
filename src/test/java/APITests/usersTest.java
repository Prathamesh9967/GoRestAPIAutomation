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
		
		userpayload.setId(1001);
		userpayload.setName("saksh n");
		userpayload.setEmail("an@gmail.com");
		userpayload.setGender("female");
		userpayload.setStatus("active");
	}
	
	@Test(priority=1)
	public void createUser() {
		Response response = Endpoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	@Test(priority=2)
	public void getTestUser() {
		Response response = Endpoints.getUser(userpayload.getId());
		response.then().log().all();
		
		// Deserialize the Response body
		ResponseBody body = response.getBody();
		UserData payload = body.as(UserData.class);
		
		System.out.println("user name is " + payload.getName());
		Assert.assertEquals(200, response.getStatusCode());
	}
}
