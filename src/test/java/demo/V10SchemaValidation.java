
package demo;
import static  io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import org.testng.annotations.Test;

public class V10SchemaValidation {
	
	@Test
	public void SchemaValidation_try() {
		
		baseURI = "https://reqres.in";
		given()
			.get("/api/users?page=2")
			.then().assertThat()
			.body(matchesJsonSchemaInClasspath("schema.json")).
				statusCode(200).statusLine("HTTP/1.1 200 OK").log().status();
	}

}
