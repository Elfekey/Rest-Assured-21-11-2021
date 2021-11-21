package demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class V11SoapRequest {
	@Test
	public void SoapReq_try() throws IOException
	{
		File f = new File("./SoapRequest/Multi.xml");
		if(f.exists())
			System.out.println(">>the FIle is exist");
		FileInputStream fInput = new FileInputStream(f);
		
		String reqBody = IOUtils.toString(fInput,"UTF-8");
		
		 baseURI = "http://www.dneonline.com";
		 given().
		 	contentType("text/xml").
		 	accept(ContentType.XML).
	        body(reqBody).
	     when().
	     	post("/calculator.asmx?op=Multiply").
	     then().statusCode(200).log().body();
	}
	
	@Test
	public void soapRequest2() throws IOException {
		 File file = new File("./SoapRequest/SoapReq2.xml");
			if(file.exists())
				System.out.println(">> FIle2  is exist");
		 FileInputStream file_input = new FileInputStream(file);
		String file_body = IOUtils.toString(file_input, "UTF-8");
		 
		baseURI = "https://www.dataaccess.com";
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(file_body).
		when().
			post("/webservicesserver/NumberConversion.wso").
		then().statusCode(200).log().all();
		 
	}
	@Test
	public void soapRequest3() throws IOException {
		 File file = new File("./SoapRequest/SoapReq3.xml");
			if(file.exists())
				System.out.println(">> FIle3  is exist");
		 FileInputStream file_input = new FileInputStream(file);
		String file_body = IOUtils.toString(file_input, "UTF-8");
		 //we also can not use the baseURI and use directly the post("with all the address")
		//baseURI = "https://www.crcind.com:443";
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(file_body).
		when().
			post("https://www.crcind.com:443/csp/samples/SOAP.Demo.cls").
		then().statusCode(200).log().all();
		 
	}

}
