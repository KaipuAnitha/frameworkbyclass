package httpBasicRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Create_Update_DeleteSameUser
{
	
	int id;
  @Test(priority=1)
  public void createUser() 
  {
	  //Payload
	  PojoData pojo = new PojoData();
	  pojo.setName("Nithya");
	  pojo.setJob("Tester");
	  
	  id = given()
	  .contentType("application/json")
	  .body(pojo)
	  
	  
	  .when()
	  .post("https://reqres.in/api/users")
	  .jsonPath().getInt("id");
	  
	  System.out.println("Generated Id is: "+id);
	  
	  
	  
	  
  }
  
  
  @Test(priority=2)
  public void updateSameUser()
  {
	  //payload
	  PojoData data = new PojoData();
	  data.setName("Triveni");
	  data.setJob("QA");
	  
	  given()
	  .contentType("application/json")
	  .body(data)
	  
	  .when()
	  .put("https://reqres.in/api/users/"+id)
	  
	  
	  .then()
	  .log().body();
	  
	  System.out.println("User updated with id:"+id);
	  
  }
  
  @Test(priority=3)
  public void deleteSameUser()
  {
	 given()
	 
	 .when()
	 .delete("https://reqres.in/api/users/"+id)
	 
	 .then()
	 .statusCode(204)
	 .log().all();
	 
	 System.out.println("User deleted with id:"+id);
	  
	  
  }
  
}
