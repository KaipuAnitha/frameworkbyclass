package apiParameters;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeaderValidation {
  @Test
  public void getAllHeaders() 
  {
	  given()
	  
	  .when()
	  .get("https://www.google.com")
	  
	  .then()
	  .log().headers();
	  
  }
  
  @Test 
  public void getHeader()
  {
	  System.out.println("This test is to validate a single header");
	  Response res = given()
	  
	  .when()
	  .get("https://www.google.com");
	  String header =  res .getHeader("Content-Type");
	  System.out.println(header);
	  
	  
	  //validation
	  Assert.assertEquals(header,"text/html; charset=ISO-8859-1");
	  
	  
	  
	  
  }
  
}
