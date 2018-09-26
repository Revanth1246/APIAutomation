package Rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeTest;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;

public class Logout {
	Response response;
  @Test
  public void SME_Logout() {
	
	RequestSpecification request = RestAssured.given();
	  
  request.header("Authorization", "Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS");
  //request.header("Content-Type","application/json");
  
	
	response = request.get("https://test.cxadirect.com/clearcookies");

	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
	System.out.println("Response body: " + response.body().asString());
	System.out.println("Response body: " + response.getHeader("Authorization"));    
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("Befoire Revanth");
	  RestAssured.baseURI ="https://test.cxadirect.com/";
  }

  @AfterTest
  public void afterTest() {
  }

}
