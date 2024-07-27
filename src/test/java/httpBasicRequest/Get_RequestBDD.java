package httpBasicRequest;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Get_RequestBDD {
  @Test
  public void getSingleUser() 
  {
	  
	  given()
	  
	  
	  .when()
	  .get("https://reqres.in/api/users/2")
	  
	  .then()
	  .statusCode(200)
	  .body("data.id",equalTo(2))
	  .log().all();
}
  
  @Test
  public void getListOfUsers()
  {
	  given()
	  
	  .when()
	  .get("https://reqres.in/api/users?page=2")
	  
	  .then()
	  .statusCode(200)
	  .body("data[2].id", equalTo(9))
	  /*
	   * hasItems()-checks all elements are in collection or not
	   * it allows partial
	   * and it doesn't require the collection should be in order
	   */
	  .body("data.id",hasItems(7,8,9,10,11,12))
	  .body("data.id",hasItems(8,9,10))
	  .body("data.id",hasItems(10,11,12,7,8,9))
	  /*
	   * contains()- this method will not allow partial values 
	   * it looks for exact matching
	   * it looks for all elements are in a collection 
	   * the collection should be in a order
	   */
	  .body("data.id",contains(7,8,9,10,11,12))
	  .log().body();
  
  
  }
  
  
}
