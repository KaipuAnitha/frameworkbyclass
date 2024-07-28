package apiParameters;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookiesValidation {
  @Test
  public void gatAllCookies()
  {
	  
	  given()
	  
	  .when()
	  .get("https://www.google.com")
	 
	  .then()
	  .log().cookies();
  }
  
  @Test
  public void getSingleCookie()
  {
	  //This test case is for to get a single cookie out of all the cookies generated by server
	  //here returntype of get is Response so here i am Response to the given() method
	Response res=  given()
	  
	  .when()
	  .get("https://www.google.com");
	String actcookie =  res.getCookie("AEC");//here getCookie returntype is String so i am writing string 
	System.out.println(actcookie);
	
	
	String exp = "AVYB7cprJcF76cti6gxE-YlkS4qBDW7s9XGHIe0Yj9P9BTdsIzlEDt94sSQ";
	
	//validate a cookie 
	
	Assert.assertFalse(actcookie.equals(exp),"Test fail: cookies are matching");
	System.out.println("Test pass: cookies are not matched");
	
  }
  
  
}
