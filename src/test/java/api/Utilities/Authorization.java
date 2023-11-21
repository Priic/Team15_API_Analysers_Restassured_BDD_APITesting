package api.Utilities;


import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.StepDefinitions.Patientcontroller_dieticianSD;
public class Authorization extends restUtils{

	

	
	public static String bearertoken() {
		 baseURI= path.getString("BaseUrl");
		String payload="{\r\n"
				+ "  \"password\": \"Lead65\",\r\n"
				+ "  \"userLoginEmail\": \"maria.steffina@gmail.com\"\r\n"
				+ "}";
		System.out.println("header step");
		request=given();
		request.header("Content-Type", "application/json");
		response=request.body(payload).post("/login");
	System.out.println(response.prettyPrint());	
		String jsonstring=response.getBody().asString();
	String tokengenerated= JsonPath.from(jsonstring).get("token");
	return tokengenerated;

	}
	
	public static Response patientPostRequest() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 System.out.println("base");
		
				request = given()
						.queryParam("patientInfo", "Thyroid")
						.contentType("multipart/form-data")
			            .multiPart("patientInfo", Requestbody.getvalidreqbody())
			            .multiPart("file", THY_FILE)
			            .log().all();
				System.out.println("passing given");
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).post(path.getString("Patient_Post"));
	System.out.println(response.prettyPrint());	
		return response;
	}

	public static Response patientPostRequestemptynames() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 System.out.println("base");
		
				request = given()
						.queryParam("patientInfo", "Thyroid")
						.contentType("multipart/form-data")
			            .multiPart("patientInfo", Requestbody.getreqbodyemptynames())
			            .multiPart("file", THY_FILE)
			            .log().all();
				System.out.println("passing given");
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).post(path.getString("Patient_Post"));
	System.out.println(response.prettyPrint());	
		return response;
	}
	
	public static Response patientPostRequestinvalidfoodcategory() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 System.out.println("base");
		
				request = given()
						.queryParam("patientInfo", "Thyroid")
						.contentType("multipart/form-data")
			            .multiPart("patientInfo", Requestbody.getreqbodyinvalidfoodcategories())
			            .multiPart("file", THY_FILE)
			            .log().all();
				System.out.println("passing given");
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).post(path.getString("Patient_Post"));
	System.out.println(response.prettyPrint());	
		return response;
	}
	public static Response patientPostRequestinvalidcontactnumemail() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 System.out.println("base");
		
				request = given()
						.queryParam("patientInfo", "Thyroid")
						.contentType("multipart/form-data")
			            .multiPart("patientInfo", Requestbody.getreqbodyinvalidcontactnameemail())
			            .multiPart("file", THY_FILE)
			            .log().all();
				System.out.println("passing given");
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).post(path.getString("Patient_Post"));
	System.out.println(response.prettyPrint());	
		return response;
	}
	
	public static Response patientPostRequestinvalidemaildob() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 System.out.println("base");
		
				request = given()
						.queryParam("patientInfo", "Thyroid")
						.contentType("multipart/form-data")
			            .multiPart("patientInfo", Requestbody.getreqbodyinvalidemaildob())
			            .multiPart("file", THY_FILE)
			            .log().all();
				System.out.println("passing given");
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).post(path.getString("Patient_Post"));
	System.out.println(response.prettyPrint());	
		return response;
	}

	public static Response patientPostRequestduplicatecontactdob() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 System.out.println("base");
		
				request = given()
						.queryParam("patientInfo", "Thyroid")
						.contentType("multipart/form-data")
			            .multiPart("patientInfo", Requestbody.duplicatecontactdob())
			            .multiPart("file", THY_FILE)
			            .log().all();
				System.out.println("passing given");
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).post(path.getString("Patient_Post"));
	System.out.println(response.prettyPrint());	
		return response;
	}
	
	public static Response patientPostRequestinvalidfileupload() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File invalidfile = new File(".\\src\\test\\resources\\Testdata\\Testdata_steffi.xlsx");
		 System.out.println("base");
		
				request = given()
						.queryParam("patientInfo", "Thyroid")
						.contentType("multipart/form-data")
			            .multiPart("patientInfo", Requestbody.getduplicate())
			            .multiPart("file", invalidfile)
			            .log().all();
				System.out.println("passing given");
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).post(path.getString("Patient_Post"));
	System.out.println(response.prettyPrint());	
		return response;
	}
	
	public static Response patientPostRequestnofileupload() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 System.out.println("base");
		
				request = given()
						.queryParam("patientInfo", "Thyroid")
						.contentType("multipart/form-data")
			            .multiPart("patientInfo", Requestbody.getduplicate())
			            .log().all();
				System.out.println("passing given");
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).post(path.getString("Patient_Post"));
	System.out.println(response.prettyPrint());	
		return response;
	}
	
	public static Response patientGetRequestvalidendpoint() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 System.out.println("base");
		
				request = given()
			            .log().all();
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).get(path.getString("Patient_GetALL"));
	System.out.println(response.prettyPrint());	
		return response;
	}
	public static Response patientGetRequestvalidpatientid() throws IOException  {
		 baseURI= path.getString("BaseUrl");
				request = given()
			            .log().all();
				System.out.println(Patientcontroller_dieticianSD.patientidinrecord);
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).get(path.getString("Patient_morbid")+"/"+Patientcontroller_dieticianSD.patientidinrecord);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	public static Response patientGetRequestviewfile() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 System.out.println("base");
				request = given()
			            .log().all();
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).get(path.getString("Patient_viewfile")+"/"+Patientcontroller_dieticianSD.fileid);
		return response;
	}
	
	public static Response patientputrequestvalidpatientid() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 request = given()
					.queryParam("patientInfo", "Thyroid")
					.contentType("multipart/form-data")
		            .multiPart("patientInfo", Requestbody.updatebody())
		            .multiPart("file", THY_FILE)
		            .log().all();
				System.out.println(Patientcontroller_dieticianSD.patientidinrecord);
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).put(path.getString("Patient_Post")+"/"+Patientcontroller_dieticianSD.patientidinrecord);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	
	public static Response patientputrequestinvalidpatientid() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 request = given()
					.queryParam("patientInfo", "Thyroid")
					.contentType("multipart/form-data")
		            .multiPart("patientInfo", Requestbody.updatebody())
		            .multiPart("file", THY_FILE)
		            .log().all();
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).put(path.getString("Patient_Post")+"/"+231);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	
	public static Response patientputrequestnodob() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 request = given()
					.queryParam("patientInfo", "Thyroid")
					.contentType("multipart/form-data")
		            .multiPart("patientInfo", Requestbody.updatebodynodob())
		            .multiPart("file", THY_FILE)
		            .log().all();
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).put(path.getString("Patient_Post")+"/"+Patientcontroller_dieticianSD.patientidinrecord);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	public static Response patientputrequestincorrectdob() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 request = given()
					.queryParam("patientInfo", "Thyroid")
					.contentType("multipart/form-data")
		            .multiPart("patientInfo", Requestbody.incorrectdobupdate())
		            .multiPart("file", THY_FILE)
		            .log().all();
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).put(path.getString("Patient_Post")+"/"+Patientcontroller_dieticianSD.patientidinrecord);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	public static Response patientputrequestemptyemail() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 request = given()
					.queryParam("patientInfo", "Thyroid")
					.contentType("multipart/form-data")
		            .multiPart("patientInfo", Requestbody.emptyemail())
		            .multiPart("file", THY_FILE)
		            .log().all();
		 System.out.println(Patientcontroller_dieticianSD.patientidinrecord);
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).put(path.getString("Patient_Post")+"/"+Patientcontroller_dieticianSD.patientidinrecord);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	public static Response patientputrequestincorrectfoodcatefoy() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 request = given()
					.queryParam("patientInfo", "Thyroid")
					.contentType("multipart/form-data")
		            .multiPart("patientInfo", Requestbody.incorrectfoodcategoryput())
		            .multiPart("file", THY_FILE)
		            .log().all();
		 System.out.println(Patientcontroller_dieticianSD.patientidinrecord);
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).put(path.getString("Patient_Post")+"/"+Patientcontroller_dieticianSD.patientidinrecord);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	public static Response patientputrequestincorrectfoodallergy() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 request = given()
					.queryParam("patientInfo", "Thyroid")
					.contentType("multipart/form-data")
		            .multiPart("patientInfo", Requestbody.incorrectfoodallergyput())
		            .multiPart("file", THY_FILE)
		            .log().all();
		 System.out.println(Patientcontroller_dieticianSD.patientidinrecord);
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).put(path.getString("Patient_Post")+"/"+Patientcontroller_dieticianSD.patientidinrecord);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	public static Response patientputrequestemptycontactno() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 File THY_FILE = new File(".\\src\\test\\resources\\HyperThyroid_Report_final.pdf");
		 request = given()
					.queryParam("patientInfo", "Thyroid")
					.contentType("multipart/form-data")
		            .multiPart("patientInfo", Requestbody.emptycontactnoput())
		            .multiPart("file", THY_FILE)
		            .log().all();
		 System.out.println(Patientcontroller_dieticianSD.patientidinrecord);
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).put(path.getString("Patient_Post")+"/"+Patientcontroller_dieticianSD.patientidinrecord);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	public static Response getallpatients() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 request = given()
		            .log().all();
		 System.out.println(Patientcontroller_dieticianSD.patientidinrecord);
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).put(path.getString("Patient_GetALL"));
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	public static Response deletevalidpatientid() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 request = given()
		            .log().all();
		 System.out.println(Patientcontroller_dieticianSD.patientidinrecord);
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).delete(path.getString("Patient_Post")+"/"+Patientcontroller_dieticianSD.patientidinrecord);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	public static Response deleteinvalidpatientid() throws IOException  {
		 baseURI= path.getString("BaseUrl");
		 request = given()
		            .log().all();
				response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).delete(path.getString("Patient_Post")+"/"+112);
	System.out.println(response.prettyPrint());
	return response;	
	
	}
	
}
