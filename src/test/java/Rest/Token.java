package Rest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import java.util.HashMap;
import java.util.Map;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Token {
  @Test
  public void f() {
	  
	   Map<String,String> car = new HashMap<>();
       car.put("accountPrefixCode", "501");
//       car.put("brand", "audi");
//       car.put("colour", "red");

       given()
       .contentType("application/json").
       cookie("Bearer 0zvGbacIED68HrauO-Or9y2u8F54tAaAaUHqrIOsTVsPRgPXM7nvRjAZQEKjHA4jFnsZwrNuiYxHB1NlqcgZIqpX9AIQOCb17FxxDD2oXSvBQkrXX3do9aRFgIhTSelrZ0hzJzTiLwOp7A9PC_LyBrCD7YEH3hXai6m1nLd0I6BArM0qPc3HohS0stJkcVdKyaxwA8r-EtUgYuqbKZif-eKFrmMbHSwOPsZTemAskJlOVmUME7rgCnRlrzm4I9Xr6QZ1D-XJiUwLuQNEvQeQvkMAXDT5jp982ilu7SM5CE3LnzB3tRC14eqaNGzWCIQVzhpETmhJF2Kp-ConMZlpJndIEJ0cThMKl5sdA1VcVJyGnf95adccV9Zc1zQ4dVURLNBICUU5K5VWRuqbcney-JttOZvFTusC3nOVTwB4Y00-C1qjCnNxTs3TObJbHsjTOJFbHq7dDRYATO4zsTMJuAvGKt0B8I3mUGv_Hqsz8z1qys6J3oj52HSZhHqjZKJS").
       
       body(car)
       .when().post("api/1/validate/ocbc/isocbccustomer").then()
       .statusCode(200);
  }
  @BeforeTest
  public void beforeTest() {
	  String port = System.getProperty("server.port");
      if (port == null) {
          RestAssured.port = Integer.valueOf(8080);
      }
      else{
          RestAssured.port = Integer.valueOf(port);
      }


      String basePath = System.getProperty("server.base");
      if(basePath==null){
          basePath = "https://test.cxadirect.com/";
      }
      RestAssured.basePath = basePath;

      String baseHost = System.getProperty("server.host");
      if(baseHost==null){
          baseHost = "https://test.cxadirect.com/";
      }
      RestAssured.baseURI = baseHost;
  }

  @AfterTest
  public void afterTest() {
  }

}
