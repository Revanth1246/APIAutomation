package Rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;

public class DataDriven {
	Response response;

  @Test(dataProvider="SME_data")
  public void SME_Test(String Accountname,String value)   
	  
	  {
		  System.out.println("Accountname: " + Accountname);
		  System.out.println("value: " + value);
		  JSONObject loginCredentials = new JSONObject();
			loginCredentials.put(Accountname, value);		
		RequestSpecification request = RestAssured.given();
		  
	  request.header("Authorization", "Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS");
	  request.header("Content-Type","application/json");
	  request.body(loginCredentials.toString());
		
		response = request.post("api/1/validate/ocbc/isocbccustomer");
	
		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);
		System.out.println("Response body: " + response.body().asString());
		System.out.println("Response body: " + response.getHeader("Authorization"));	  
  }
  @DataProvider(name="SME_data")
  public  String[][] SME_Testdata()
  {
	  return  new String[][] {
		  {"accountPrefixCode", "501"},
        {"accountPrefixCode", "502"},
        {"accountPrefixCode", "830"}};
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("Befoire Revanth");
	  RestAssured.baseURI ="https://test.cxadirect.com/";
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test Finished Revanth");
  }

}
