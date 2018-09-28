//package Rest;
//
//import org.testng.annotations.Test;
////import com.jayway.restassured.builder.ResponseSpecBuilder;
////import com.jayway.restassured.specification.ResponseSpecification;
//
//import io.restassured.RestAssured;
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.http.ContentType;
//import io.restassured.specification.RequestSpecification;
//
//import org.junit.BeforeClass;
//import static org.hamcrest.Matchers.containsString;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.AfterClass;
//
//public class NewTest {
//	  public static RequestSpecBuilder builder;
//	    public static RequestSpecification responseSpec;
//  @Test
//  public void f() {
//	  
//	  RestAssured.given().//Given the functions for the values
//	    when().
//	        get("http://ergast.com/api/f1/2017/circuits.json"). // getting hte values
//	    then().
//	        assertThat().
//	        statusCode(200).
//	    and().
//	        contentType(ContentType.JSON).
//	    and().
//	        body("Content-Length",equals("4567"));
//  }
//  @BeforeClass
//  public void beforeClass() {
//	
//      
//	  
//  }
//
//  @AfterClass
//  public void afterClass() {
//  }
//
//}
