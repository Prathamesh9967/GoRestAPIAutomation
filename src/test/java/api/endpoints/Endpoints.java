package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Endpoints {
	public static Response getUser(int id) {
		Response response = 
				given()
					.pathParam("id", id)
				.when()
					.get(Routes.get_url);
		
		return response;
	}
}
