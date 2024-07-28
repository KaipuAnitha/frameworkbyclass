package apiParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Path_QueryParameters {
  @Test
  public void Path_QueryParam() 
  {
	 // https://reqres.in/api/users?page=2
	  
	  given()
	  .pathParam("mypath","users")
	  .queryParam("page", 2)
	  
	  
	  .when()
	  .get("https://reqres.in/api/{mypath}")
	  
	  .then()
	  .statusCode(200)
	  .log().body();
  }
}
