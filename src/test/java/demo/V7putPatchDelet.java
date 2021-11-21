package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class V7putPatchDelet {

	@Test
	public void put_test() {
		JSONObject o = new JSONObject();
		o.put("name", "Hassan");
		o.put("job","Web Admin");
		o.toJSONString();
		baseURI = "https://reqres.in";
		given().
		header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		when().
		put("/api/users/2").
		then().statusCode(200).log().all();
	
}


	@Test
	public void post_test() {
		JSONObject o = new JSONObject();
		o.put("name", "Hassan");
		o.put("job","Web Admin");
		o.toJSONString();
		baseURI = "https://reqres.in";
		given().
		header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		when().
		post("/api/users").
		then().statusCode(201).log().all();
	}
	
	@Test
	public void patch_test() {
		JSONObject o = new JSONObject();
		o.put("name", "Mahmoud");
		o.put("job","App support");
		o.toJSONString();
		baseURI = "https://reqres.in";
		given().
		header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).
		when().
		patch("/api/users/2").
		then().statusCode(200).log().all();
	}
	@Test
	public void Delete_test() {
		baseURI = "https://reqres.in";
		when().
		delete("/api/users/2").
		then().statusCode(204).log().all();
	}
	}
