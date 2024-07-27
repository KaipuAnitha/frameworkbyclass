package httpBasicRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GETWithoutBDD {
  @Test
  public void singleUser()
  {
	  // Restassured is a class & get() method return type is Response & Response is a interface in restAssured
	 Response res = RestAssured.get("https://reqres.in/api/users/2");
	 
	 System.out.println("Satus code is:"+res.getStatusCode());
	 System.out.println("Staus line is:"+res.getStatusLine());
	 System.out.println("Get the Time:"+res.getTime());
	 System.out.println("Header is:"+res.getContentType());
	 System.out.println(res.asString());
	 
	 /*
	  *  to get the exact json response we have a method
	  *  that method is asPrettyString()
	  */
	 
	 System.out.println(res.asPrettyString());
	 
	 // we can even  validate with the help of assertion
	 Assert.assertEquals(res.getStatusCode(),200,"Test fail: Status code not matched");
	 System.out.println("Test pass: Staus code matched");
	 
	
  }
  
  @Test
  public void listOfUsers()
  {
	 Response res =  RestAssured.get("https://reqres.in/api/users?page=2");
	int pagenumber =  res.jsonPath().getInt("page");
	System.out.println("Page number is:"+pagenumber);
  }
}
