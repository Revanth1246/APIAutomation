package Rest;
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
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

import org.json.*;
import org.json.simple.JSONObject;

import com.google.*;

public class SME_Signup {
	
	public static void main(String args[])
	{
		 System.out.println("Revanth");
		  


		 RestAssured.baseURI ="http://restapi.demoqa.com/customer";
			RequestSpecification request = RestAssured.given();
			
			JSONObject requestParams = new JSONObject();
			requestParams.put("FirstName", "tetre"); // Cast
			requestParams.put("LastName", "test");
			requestParams.put("UserName", "teste");
			requestParams.put("Password", "passeword1");	
			requestParams.put("Email",  "tester1@gmail.com");
		 
			request.body(requestParams.toJSONString());
			Response response = request.post("/register");
		 
			int statusCode = response.getStatusCode();
			System.out.println("The status code recieved: " + statusCode);
		 
			System.out.println("Response body: " + response.body().asString());
			GetSME();

	}
	
	@SuppressWarnings("deprecation")
	public static void GetSME()
	{
//		RequestSpecBuilder builder;
		RestAssured.baseURI ="https://test.cxadirect.com/";
		JSONObject loginCredentials = new JSONObject();
		loginCredentials.put("accountPrefixCode", "501");
		
	RequestSpecification request = RestAssured.given();
	  
      request.header("Authorization", "Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS");
      request.header("Content-Type","application/json");
      request.body(loginCredentials.toString());
      
 
//	JSONObject requestParams = new JSONObject();
//	requestParams.put("accountPrefixCode", "501"); // Cast
//	
////	requestParams.put("LastName", "Singh");
////	requestParams.put("UserName", "sdimpleuser2dd2011");
////	requestParams.put("Password", "password1");	
////	requestParams.put("Email",  "sample2ee26d9@gmail.com");
//	//requestParams.put("Authorization", "Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS");
//	request.accept(ContentType.JSON);
//	request.cookie("Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS");
//	request.body(requestParams.toJSONString());	
      
	
	Response response = request.post("api/1/validate/ocbc/isocbccustomer");
 
	int statusCode = response.getStatusCode();
	System.out.println("The status code recieved: " + statusCode);
 
	System.out.println("Response body: " + response.body().asString());
	System.out.println("Response body: " + response.getHeader("Authorization"));
	}

}
