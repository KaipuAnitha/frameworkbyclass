package httpBasicRequest;

import static io.restassured.RestAssured.given;
		
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PUT_DELETERequest {
  @Test
  public void fullUpdate() 
  {
	//payload
	  PojoData data = new PojoData();
	  data.setName("Indu");
	  data.setJob("Engg");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  
	  .when()
	  .put("https://reqres.in/api/users/2")
	  
	  
	  .then()
	  .statusCode(200)
	  .log().all();
	  
	  
  }
  
  @Test
  public void deleteUser()
  {
	  given()
	  
	  .when()
	  .delete("https://reqres.in/api/users/2")
	  
	  .then()
	  .statusCode(204)
	  .log().all();
	  
	  
  }


}
