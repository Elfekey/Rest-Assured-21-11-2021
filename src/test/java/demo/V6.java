package demo;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class V6 {
    //@Test
	public void Get_test() {
		baseURI = "https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[1].id", equalTo(8)).body("data.first_name", hasItems("Lindsay","Byron","George"));
	}
    
    @Test
    public void post_test() {
    	
    	JSONObject map = new JSONObject();
    	map.put("Name", "Likoo");
    	map.put("Number", "1");
    	map.toJSONString();
    	System.out.println(map.toJSONString());
    	
    	baseURI = "https://reqres.in/api";
    	
    	given().
    	header("Content-Type","application/json").
    	contentType(ContentType.JSON).
    	accept(ContentType.JSON).
    	body(map.toJSONString()).
    	when().
     	post("/users").
     	then().statusCode(201).log().all();
    	
    
    }
}
