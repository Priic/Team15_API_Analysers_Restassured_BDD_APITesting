package api.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class restUtils {
	
	//base class for all global declarations
		public static ResourceBundle path=ResourceBundle.getBundle("paths"); //creating object and accessing the path properties file
		public static Logger log = LogManager.getLogger();
		//public static String url= path.getString("BaseUrl");
		
		
		public static RequestSpecification requestSpecification() throws FileNotFoundException {
			
			if (reqSpecBuilder==null) {
			PrintStream log=new PrintStream(new FileOutputStream (".\\src\\test\\resources\\logFilter\\UserDieticianAllLog.txt"));
			
			reqSpecBuilder=new RequestSpecBuilder().setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.build();
			return reqSpecBuilder;
			}
			return reqSpecBuilder;
			
		}
		
		public static  ResponseSpecification responseSpecification201() {
			
			resSpecBuilder=new ResponseSpecBuilder()					
					.expectStatusCode(201).expectContentType(ContentType.JSON).build();
			return resSpecBuilder;
			}
		
		public static ResponseSpecification responseSpecification200() {
			
			resSpecBuilder=new ResponseSpecBuilder().expectStatusCode(200).build();
			return resSpecBuilder;
		}
		public static ResponseSpecification responseSpecification400() {
			
			resSpecBuilder=new ResponseSpecBuilder().expectStatusCode(400).build();
			return resSpecBuilder;
		}
		
		public static ResponseSpecification responseSpecification500() {
			
			resSpecBuilder=new ResponseSpecBuilder().expectStatusCode(500).build();
			return resSpecBuilder;
		}
		
public static ResponseSpecification responseSpecification404() {
			
			resSpecBuilder=new ResponseSpecBuilder().expectStatusCode(404).build();
			return resSpecBuilder;
		}
		
		

}
