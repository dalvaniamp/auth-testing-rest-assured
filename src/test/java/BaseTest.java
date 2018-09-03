import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseTest {
	protected final static String BASE_URL = "https://api.jsonbin.io/b/";		
	
	protected static Response getRequestResponse (String request,Boolean validKey)
	{
		RestAssured.baseURI = BASE_URL;
		RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
		requestBuilder.addHeader("secret-key", Constants.VALID_API_KEY);		
		requestBuilder.setContentType("application/json; charset=UTF-8");
		RequestSpecification httpRequest = requestBuilder.build();		
		return httpRequest.post(request);
	}		
}
