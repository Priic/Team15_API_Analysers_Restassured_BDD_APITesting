package api.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import api.Pojo.PatientPayload;
import api.Pojo.UserLoginPayload;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class restUtils {

	// base class for all global declarations
	public static ResourceBundle path = ResourceBundle.getBundle("paths"); // creating object and accessing the path
																			// properties file
	public static Logger log = LogManager.getLogger();
	public static xlUtils xlUtils = new xlUtils(path.getString("Xlpath"));
	public static UserLoginPayload userLoginPayload = new UserLoginPayload();
	public static PatientPayload patientPayload = new PatientPayload();

	public static RequestSpecification reqSpecBuilder;
	public static ResponseSpecification resSpecBuilder;
	public static RequestSpecification request;
	public static Response response;
	public static String DieticianPritoken;
	public static String PriPatientId;

	public static RequestSpecification requestSpecification() throws FileNotFoundException {

		if (reqSpecBuilder == null) {
			PrintStream log = new PrintStream(
					new FileOutputStream(".\\src\\test\\resources\\logFilter\\UserDieticianAllLog.txt"));

			reqSpecBuilder = new RequestSpecBuilder().setContentType(ContentType.JSON)
					// .addHeader("Authorization","Bearer "+DieticianPritoken)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

			return reqSpecBuilder;
		}
		return reqSpecBuilder;

	}

//	public static RequestSpecification requestSpecificationMultiContent() throws FileNotFoundException {
//
//		if (reqSpecBuilder == null) {
//			PrintStream log = new PrintStream(
//					new FileOutputStream(".\\src\\test\\resources\\logFilter\\UserDieticianCreatePatientLog.txt"));
//
//			reqSpecBuilder = new RequestSpecBuilder().setContentType(ContentType.MULTIPART)
//					// .addHeader("Authorization","Bearer "+DieticianPritoken)
//					.addFilter(RequestLoggingFilter.logRequestTo(log))
//					.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
//
//			return reqSpecBuilder;
//		}
//		return reqSpecBuilder;
//
//	}

	public static ResponseSpecification responseSpecification201() {

		resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
		return resSpecBuilder;
	}

	public static ResponseSpecification responseSpecification200() {

		resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).build();
		return resSpecBuilder;
	}

	public static ResponseSpecification responseSpecification400() {

		resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(400).build();
		return resSpecBuilder;
	}

	public static ResponseSpecification responseSpecification500() {

		resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(500).build();
		return resSpecBuilder;
	}

	public static ResponseSpecification responseSpecification404() {

		resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(404).build();
		return resSpecBuilder;
	}

}
