package httpBasicRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Post_Request {
  @Test
  public void createResource() 
  
  {
	  //Request payload
	  HashMap<String,Object>map = new HashMap<String,Object>();
	  map.put("Name","Anitha");
	  map.put("job","QA");
	  
	  given()
	  .contentType("application/json")
	  .body(map)
	  
	  
	  .when()
	  .post("https://reqres.in/api/users")
	  
	  .then()
	  .statusCode(201)
	  .body("Name",equalTo("Anitha"))
	  .body("job",equalTo("QA"))
	  .log().all();
	  
	  
  }
}
