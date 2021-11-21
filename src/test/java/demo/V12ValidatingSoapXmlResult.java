package demo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class V12ValidatingSoapXmlResult {

	//@Test
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
	     then().statusCode(200).log().body().
	     		and().
	     		body("//*:MultiplyResult.text()",equalTo("35"));
		 
	}
	//@Test
	public void soapRequest2() throws IOException {
		/*creating xml file here and pass it's path to file then pass it to fileinputsctream
		 * then pass it to string */
		//we get the info in the xml file from api website (the specific function we need )
		 File file = new File("./SoapRequest/SoapReq2.xml");
			if(file.exists())
				System.out.println(">> FIle2  is exist");
		 FileInputStream file_input = new FileInputStream(file);
		String file_body = IOUtils.toString(file_input, "UTF-8");
		 //the base uri of the api website 
		baseURI = "https://www.dataaccess.com";
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(file_body).//the body that we got from the xml file that we created 
		when().
			post("/webservicesserver/NumberConversion.wso").
		then().statusCode(200).log().all()./*adding next body that includes fake xpath we made using this
		           website (https://www.freeformatter.com/xpath-tester.html#ad-output) 
		           we can generate it after getting the soap result and copy it to there to create test xpath
		           then we compare it's result using equal to below
		           */
				and().body("//*:NumberToDollarsResult.text()",equalTo("one dollar and fifty cents"));
		 
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
		  // baseURI = "http://webservices.oorsprong.org";
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(file_body).
		when().
			post("https://www.w3schools.com/xml/tempconvert.asmx").
		then().statusCode(200).log().body().
				and().body("//*:CelsiusToFahrenheitResult.text()",equalTo("68"));
		 
	}
}
