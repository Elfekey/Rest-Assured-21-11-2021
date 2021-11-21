package tests;

import static io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base32;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Trying_revision {
//	@Test
	public void restTry() {
	Response res = 	RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println(res.getBody());//the same next line
	System.out.println(res.toString());
	System.out.println(res.getBody().asString());//the same log().all();

	System.out.println(res.getTime());
	System.out.println(res.getHeader("content-type"));//is the same next line
	System.out.println(res.getContentType());

	System.out.println(res.getStatusCode());
	System.out.println(res.getStatusLine());

System.out.println("------------------------");
	
	Assert.assertEquals(res.getStatusCode(), 200);
	System.out.println("------------------------");

	}
	//@Test
	public void restTry2() {
		
		
		given().
			get("https://reqres.in/api/users?page=2").
		then().
		statusCode(200).body("data[4].id", equalTo(11)).log().all();
		
	}
	//get
	//@Test
	public void gettest() {
		
		baseURI="https://reqres.in/api";
		given().get("/users?delay=3").then().statusCode(200).body("data.id[2]",equalTo(3)).body("data.first_name[3]", equalTo("Eve"));
	}
	//Post
	//@Test
	public void posttest() {
		baseURI="https://reqres.in/api";
		JSONObject js = new JSONObject();
		js.put("Username", "Abdul");
		js.put("Fname", "Elfekey");
		js.put("Id", 500);
		
    
		
	given().
	  accept(ContentType.JSON).
	   body(js.toJSONString()).
	  
    when()
       .post("/users").
    then()
       .statusCode(201)
       .log().all();
	}
//put
	@Test
	public void putTry() {
		
		JSONObject js = new JSONObject();
		js.put("Name","Sambo");
		js.put("id",5);
		js.put("Location","Cairo");
		
		
		
		baseURI ="https://reqres.in/api";
		given().
		  accept(ContentType.JSON).
		  body(js.toJSONString()).
		when().
		  put("/users/2").
		then().statusCode(200).log().all();
		
	}
	//patch
	@Test
	public void patchTry() {
		
		JSONObject js = new JSONObject();
		js.put("Name","Sambo");
		js.put("id",5);
		js.put("Location","Cairo");
		
		
		
		baseURI ="https://reqres.in/api";
		given().
		  accept(ContentType.JSON).
		  body(js.toJSONString()).
		when().
		  patch("/users/2").
		then().statusCode(200).log().all();
		
	}
	//Delete
	@Test
	public void deleteTry() {
		
		baseURI="https://reqres.in/api";
		when().delete("/users/2").then().statusCode(204).log().all();
		
		
	}
	
}














