package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class V9ExamplesOnLocalNodeJS {

	
	//@Test
	public void Post_try() {
		JSONObject o = new JSONObject();
		o.put("S_Name", "Working");
		o.put("S_Price", "500$");
		
		baseURI ="http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(o.toJSONString()).
		when().post("/Subjects").
		then().statusCode(201);
		
	}
	@Test
	public void Put_try() {
		JSONObject o = new JSONObject();
		o.put("F_Name", "Sohaib");
		o.put("L_Name", "Elfiky2");
		o.put("Job", "Writer_Artist");
		baseURI ="http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(o.toJSONString()).
		when().put("/Users/4").
		then().statusCode(200);
	}
	@Test
	public void Patch_try() {
		JSONObject o = new JSONObject();
		o.put("F_Name", "Toto");
		o.put("L_Name", "Farouk");
		
		baseURI ="http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(o.toJSONString()).
		when().patch("/Users/5").
		then().statusCode(200);
	}
	@Test
	public void Get_try() {
		String endPoint = "/Users";
		baseURI = "http://localhost:3000";
		//to loop and read all the titles Users and Subjects in only one method !!
for (int i = 0;i<2;i++) {
			
 if (i==1) {
	  endPoint = "/Subjects"; 
	       }
		given().
		get(endPoint).
		then()
		.statusCode(200).log().all();

      }

	}
	@Test
	public void Delete_try() {
		
		baseURI ="http://localhost:3000";
		when().delete("/Subjects/20").then().statusCode(200);
	}
}
