import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseTest {
	private final static String BASE_URL = "https://api.jsonbin.io/b/";

	protected static RequestSpecification getRequest(String apiKey, JSONObject json) {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("secret-key", apiKey);
		request.header("Content-Type", "application/json");
		request.body(json.toString());
		return request;
	}	
	
	protected static RequestSpecification getRequest(String apiKey) {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("secret-key", apiKey);
		return request;
	}	
}
