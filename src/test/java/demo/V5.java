package demo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class V5 {

	@Test
	public void TestExample() {
		baseURI = "https://reqres.in/api";
		given().
		 get("/unknown").
		 then().
		 statusCode(200).
		 body("data[2].year",equalTo(2002)).
		 body("data[0].color", equalTo("#98B2D1")).
		  log().all() ;
		
	}
}
