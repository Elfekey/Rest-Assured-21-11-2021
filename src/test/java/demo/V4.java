package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class V4 {
	
    @Test
    public void TestExample(){

        Response response = RestAssured.get("");
       System.out.println(response.getStatusCode());
       System.out.println(response.getTime());
        System.out.println( response.getBody().asString());
        System.out.println(response.statusLine());
        Assert.assertEquals(response.getStatusCode(),200);

     }

}
