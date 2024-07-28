package apiParameters;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import httpBasicRequest.PojoData;

public class DataConversion {
  @Test
  public void testSerialization() throws JsonProcessingException 
  {
	  //This data in the form of java object i.e.,pojo
	  PojoData data = new PojoData();
	  data.setName("Anitha");
	  data.setJob("QA");
	  
	  //create a object for OBjectMapper class
	  ObjectMapper obj = new ObjectMapper();
	 String json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	 System.out.println(json);
	  
	  
  }
  
  
  @Test 
  public void testDeserialization() throws JsonMappingException, JsonProcessingException
  {
	  String json ="{\n"
	  		+ "  \"name\" : \"Anitha\",\n"
	  		+ "  \"job\" : \"QA\"\n"
	  		+ "}";
	  
	  //create a ObjectMapper class object
	  ObjectMapper obj = new ObjectMapper();
	  
	     PojoData data = obj.readValue(json,PojoData.class );
	     
	     System.out.println(data.getName());
	     System.out.println(data.getJob());
	  
  }
}
