package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import api.payload.UserData;

public class Endpoints {
	public static String authToken = "f6972e1a66528af51be599ec27a9314ab68e70dd786de1a447247aa19a8a3dfb";
	public static Response createUser(UserData payload) {
		Response response = 
				given()
					.headers("Authorization", "Bearer " + authToken, "Content-Type",
			                ContentType.JSON, "Accept", ContentType.JSON)
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(payload)
				.when()
					.post(Routes.post_url);
		
		return response;
	}
	
	public static Response getUser(int id) {
		Response response = 
				given()
					.pathParam("id", id)
				.when()
					.get(Routes.get_url);
		
		return response;
	}
}
