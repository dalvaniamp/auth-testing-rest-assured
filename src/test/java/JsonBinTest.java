import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.MethodSorters;
 
@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public final class JsonBinTest extends BaseTest{ 
	private static String _binId;
	
	@Parameter(value = 0)
	public static String _apiKey;
	
	@Parameter(value = 1)
	public static int _expectedStatusCode;
		
	@BeforeClass
	public static void setUp()
	{	
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("secret-key", Constants.VALID_API_KEY);				
		request.body( Constants.getCreateJson().toString());		
		Response response = request.post();
		_binId = response.path("id");
	}	
	
	@Parameters
	public static Collection<Object[]> apiKeys() {
	      return Arrays.asList(new Object[][] {	         
	         {Constants.VALID_API_KEY.toLowerCase(), 401 },
	         {Constants.VALID_API_KEY.toUpperCase(), 401 },
	         {"abc@123",401},
	         {"",401},
	         {Constants.VALID_API_KEY + "abc", 401 },
	         {Constants.VALID_API_KEY, 200 }
	      });
	   }
	
	/* Tests should have the "testn" prefix to execute in a specific order */
	/* Otherwise, the Delete test could execute before other tests */
	
	@Test
	public void test1GetBin()
	{		
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("secret-key", _apiKey);
		Response response = request.get(_binId);	
		Assert.assertEquals(_expectedStatusCode, response.statusCode());	
	}	
	
	@Test
	public void test2UpdateBin()
	{		
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("secret-key", _apiKey);
		request.header("Content-Type", "application/json");
		request.body( Constants.getUpdateJson().toString());
		Response response = request.put(_binId);	
		Assert.assertEquals(_expectedStatusCode, response.statusCode());	
	}
	
	@Test
	public void test3DeleteBin()
	{		
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("secret-key", _apiKey);
		Response response = request.delete(_binId);	
		Assert.assertEquals(_expectedStatusCode, response.statusCode());	
	}
	
}