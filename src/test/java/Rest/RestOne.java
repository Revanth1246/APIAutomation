package Rest;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

import org.json.*;
import org.json.simple.JSONObject;

import com.google.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class RestOne {
	public static String token="0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS";
	RequestSpecification res;
	public static  ExtentReports extent;
	public static  ExtentTest test;
	public static Response response;
	@Test
	public void SME_Tests()
	{
		Signup();
		System.out.println("Finished Signup Execution");
		Logout_ExtentReports();
		System.out.println("Finished Logout Execution");
	}
  
  public static void Signup() {
	  System.out.println("Revanth");
	  
	  JSONObject loginCredentials = new JSONObject();
		loginCredentials.put("accountPrefixCode", "501");		
	RequestSpecification request = RestAssured.given();
	  
    request.header("Authorization", "Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS");
    request.header("Content-Type","application/json");
    request.body(loginCredentials.toString());
	
	response = request.post("api/1/validate/ocbc/isocbccustomer");

	int statusCode = response.getStatusCode();
	if(statusCode==200)
	{
		test.log(LogStatus.PASS,"Signup Response code validated successfully with code 200");
	}
	else
	{
		test.log(LogStatus.FAIL,"Signup Response code Failed with Expected 200 and Actual:"+statusCode);
	}
	System.out.println("The status code recieved: " + statusCode);
	System.out.println("Response body: " + response.body().asString());
	System.out.println("Response body: " + response.getHeader("Authorization"));
	//Assert.assertEquals("200", "200");
      
	  
	  
  }
//  @Test(dataProvider="Testdata")
//  public void Data_Driven(String Accountname,String value)
//  {
//	  System.out.println("Accountname: " + Accountname);
//	  System.out.println("value: " + value);
//	  JSONObject loginCredentials = new JSONObject();
//		loginCredentials.put(Accountname, value);		
//	RequestSpecification request = RestAssured.given();
//	  
//  request.header("Authorization", "Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS");
//  request.header("Content-Type","application/json");
//  request.body(loginCredentials.toString());
//	
//	response = request.post("api/1/validate/ocbc/isocbccustomer");
//
//	int statusCode = response.getStatusCode();
//	System.out.println("The status code recieved: " + statusCode);
//	System.out.println("Response body: " + response.body().asString());
//	System.out.println("Response body: " + response.getHeader("Authorization"));
//	  
//  }
//  @DataProvider(name="Testdata")
//  public String[][] CreateTestdata()
//  {
//	  return new String[][] {
//		  {"accountPrefixCode", "501"},
//          {"accountPrefixCode", "502"},
//          {"accountPrefixCode", "830"}
//		  
//	  };
//  }
  @BeforeTest
  public static void beforeTest() {
	  System.out.println("Befoire Revanth");
	  RestAssured.baseURI ="https://test.cxadirect.com/";
	  extent = new ExtentReports("./report/result.html",true);

	//For creating each test
	test = extent.startTest("CXADirect API Testing","Testing CXADirect REST APIs");

	test.assignCategory("API Testing");//For example Smoke or sanity or regression

	test.assignAuthor("Revanth");//Author name who created the testcase
	  
  }
  
  public void BDD()
  {
	  
//	  when().
//      get("http://yourWebsiteAddress.com/someAPIcall").
//      then().
//      statusCode(200).
//      body(containsString("Your Website Title"));
	  
  }
  
  public void Logout()
  {
	  RequestSpecification request = RestAssured.given();
	  
	  request.header("Authorization", "Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS");
	  //request.header("Content-Type","application/json");
	  
		
		response = request.get("https://test.cxadirect.com/clearcookies");

		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
		System.out.println("Response body: " + response.getHeader("Authorization"));   
		Assert.assertEquals("200", "200");
  }
  
  public void Logout_ExtentReports()
  {
	  RequestSpecification request = RestAssured.given();
	  
	  request.header("Authorization", "Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS");
	  //request.header("Content-Type","application/json");
	  
		
		response = request.get("https://test.cxadirect.com/clearcookies");

		int statusCode = response.getStatusCode();
		System.out.println("Logout_ExtentReports The status code recieved: " + statusCode);
		if(statusCode==200)
		{
			test.log(LogStatus.PASS,"Response code validated successfully with code 200");
		}
		else
		{
			test.log(LogStatus.FAIL,"Response code Failed with Expected 200 and Actual:"+statusCode);
		}
		
		System.out.println("Response body: " + response.body().asString());
		System.out.println("Response body: " + response.getHeader("Authorization"));   
		Assert.assertEquals("200", "200");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Revanth");
	  //System.out.println("Response is "+res.toString());
	  extent.endTest(test);
	  extent.flush();
  }

}
