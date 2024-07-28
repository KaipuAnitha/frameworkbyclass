package httpBasicRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Post_Request {
  @Test(priority=1)
  public void createResource() 
  
  {
	  
	  System.out.println("creating data using HashMap class");
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
  
  @Test(priority=2)
  public void postUsingPojaClass()
  {
	  /*
	   * To read the data from other class we can create a object of that class
	   * so here we have created the data in one class 
	   * if we want to read that data from pojoData class we can create object of that pojaData class
	   */
	  
	  System.out.println("creating data using pojo class");
	  
	  // creating the request payload
	  PojoData data = new PojoData();
	  data.setName("Jeeva");
	  data.setJob("QA");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  
	  .when()
	  .post("https://reqres.in/api/users")
	  
	  .then()
	  .statusCode(201)
	  .log().all();
	  
	  
  }
  
  @Test(priority=3)
  public void validateSingleEntry()
  {
	  //payload 
	  
	  PojoData data = new PojoData();
	  data.setName("Vishnu");
	  data.setJob("Dev");
	  
	 int id= given()
	  .contentType("application/json")
	  .body(data)
	  
	  .when()
	  .post("https://reqres.in/api/users")
	  .jsonPath().getInt("id");
	 
	 System.out.println("Generated id is:"+id);
	  
  }
}
