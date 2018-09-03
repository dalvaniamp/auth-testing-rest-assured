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
	public static String apiKey;
	
	@Parameter(value = 1)
	public static int expectedStatusCode;
		
	@BeforeClass
	public static void createBin()
	{	
		RequestSpecification request = getRequest(Constants.VALID_API_KEY,Constants.getCreateJson());
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
	
	/* Tests should have the 'testn' prefix to execute in a specific order */
	/* Otherwise, the Delete test could execute before other tests, and status 404 would be returned */
	
	@Test
	public void test1GetBin()
	{		
		RequestSpecification request = getRequest(apiKey);
		Response response = request.get(_binId);	
		Assert.assertEquals(expectedStatusCode, response.statusCode());	
	}	
	
	@Test
	public void test2UpdateBin()
	{		
		RequestSpecification request = getRequest(apiKey,Constants.getUpdateJson());
		Response response = request.put(_binId);	
		Assert.assertEquals(expectedStatusCode, response.statusCode());	
	}	
	
	@Test
	public void test3DeleteBin()
	{		
		RequestSpecification request = getRequest(apiKey);
		Response response = request.delete(_binId);	
		Assert.assertEquals(expectedStatusCode, response.statusCode());	
	}	
}