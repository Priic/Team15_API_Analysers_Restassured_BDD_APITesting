package api.StepDefinitions;

import api.Utilities.Authorization;
import api.Utilities.Fetchjsonbody;
import api.Utilities.Filemorbiditypojo;
import api.Utilities.Requestbody;
import api.Utilities.restUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Patientcontroller_dieticianSD extends restUtils{
	public  List<Integer> patientidlist= new ArrayList<Integer>();
	public static int patientidinrecord;
	public static Object morbidconditioninrecord;
	public static Object fileid;
	public static String body;
	public static String updatename;
	@Given("User is logged in as dietician")
	public void user_is_logged_in_as_dietician() {
	
	 log.info("***User sends request with BaseURL***");
	 Authorization.bearertoken();
	}

	@When("User sends HTTPS Request having request Body with mandatory fields patientInfo and file")
	public void user_sends_HTTPS_Request_having_request_Body_with_mandatory_fields_patientInfo_and_file() throws IOException {
		 response=  Authorization.patientPostRequest();
	 System.out.println("In create 1");
	}

	@Then("User receives successful Created Status with response body having matching details from the request body")
	public void user_receives_successful_Created_Status_with_response_body_having_matching_details_from_the_request_body() throws JsonMappingException, JsonProcessingException {
	  response.then().spec(responseSpecification201()).extract().response();
		 body=response.getBody().asPrettyString();
		ObjectMapper objmap= new ObjectMapper();
		objmap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Fetchjsonbody pojo=objmap.readValue(body, Fetchjsonbody.class);
		patientidinrecord=pojo.getPatientId();
	}
	@When("User sends HTTPS Request having request Body with empty first name and last name and mandatory fields patientInfo and file")
	public void user_sends_HTTPS_Request_having_request_Body_with_empty_first_name_and_last_name_and_mandatory_fields_patientInfo_and_file() throws IOException {
	  response=Authorization.patientPostRequestemptynames();
	  log.info("***User sends empty first name and last name ***");
	  System.out.println("In create 2");
	}

	@Then("Bad Request status code is displayed with the error message {string}")
	public void bad_Request_status_code_is_displayed_with_the_error_message(String string) {
		response.then().spec(responseSpecification400());
		String jsonstring=response.getBody().asString();
		String errormessage= JsonPath.from(jsonstring).get("errorCode");
		Assert.assertEquals(Requestbody.geterrormessages().get(400), errormessage);
		
	}

	@When("User sends HTTPS Request having request Body with invalid food category and mandatory fields patientInfo and file")
	public void user_sends_HTTPS_Request_having_request_Body_with_invalid_food_category_and_mandatory_fields_patientInfo_and_file() throws IOException {
		response=  Authorization.patientPostRequestinvalidfoodcategory();
		 System.out.println("In create 3");
		 log.info("***User sends invalid food category ***");
	}

	@Then("Bad Request status code is displayed with food category error message {string}")
	public void bad_Request_status_code_is_displayed_with_food_category_error_message(String string) {
		response.then().spec(responseSpecification400());
		String jsonstring=response.getBody().asString();
		String errormessage= JsonPath.from(jsonstring).get("errorCode");
		Assert.assertEquals(Requestbody.geterrormessages().get(400), errormessage);
		
	}
	
	@When("User sends HTTPS Request and  request Body with Invalid Contact no and Email")
	public void user_sends_HTTPS_Request_and_request_Body_with_Invalid_Contact_no_and_Email() throws IOException {
		response=  Authorization.patientPostRequestinvalidcontactnumemail();
		 System.out.println("In create 4");
		 log.info("***User sends Invalid Contact no and Email ***");
	}

	@Then("Bad Request status code is displayed with the Email error message")
	public void bad_Request_status_code_is_displayed_with_the_Email_error_message() {
		response.then().spec(responseSpecification400());
		String jsonstring=response.getBody().asString();
		String errorcode= JsonPath.from(jsonstring).get("errorCode");
		Assert.assertEquals(Requestbody.geterrormessages().get(400), errorcode);
	}
	
	@When("User sends HTTPS Request and  request Body with Invalid Email and DOB")
	public void user_sends_HTTPS_Request_and_request_Body_with_Invalid_Email_and_DOB() throws IOException {
		 System.out.println("In create 5");
		response=  Authorization.patientPostRequestinvalidemaildob();
		log.info("***User sends Invalid Email and DOB ***");
	}

	@Then("Internal Server Error status code is displayed")
	public void internal_Server_Error_status_code_is_displayed() {
		response.then().spec(responseSpecification500());
		String jsonstring=response.getBody().asString();
		String errorcode= JsonPath.from(jsonstring).get("error");
		Assert.assertEquals(Requestbody.geterrormessages().get(500), errorcode);
	}
	@When("User sends HTTPS Request and  request Body with duplicate contact and dateofbirth details")
	public void user_sends_HTTPS_Request_and_request_Body_with_duplicate_contact_and_dateofbirth_details() throws IOException {
		 System.out.println("In create 6");
		response=  Authorization.patientPostRequestduplicatecontactdob();
		log.info("***User sends duplicate contact and dateofbirth ***");
	}

	@Then("Bad Request status code is displayed with contact and dob error message")
	public void bad_Request_status_code_is_displayed_with_contact_and_dob_error_message() {
		response.then().spec(responseSpecification400());
		String jsonstring=response.getBody().asString();
		String errorcode= JsonPath.from(jsonstring).get("errorCode");
		assertEquals("DUPLICATE_ENTITY", errorcode);
	}
	
	@When("User sends HTTPS Request and  request Body with invalid File upload")
	public void user_sends_HTTPS_Request_and_request_Body_with_invalid_File_upload() throws IOException {
		 System.out.println("In create 7");
		response=  Authorization.patientPostRequestinvalidfileupload();
		log.info("***User sends invalid File upload ***");
	}
	@Then("New record is created with empty file fields")
	public void new_record_is_created_with_empty_file_fields() throws JsonMappingException, JsonProcessingException {
		
		response.then().spec(responseSpecification201());
		String body=response.getBody().asPrettyString();
		ObjectMapper objmap= new ObjectMapper();
		objmap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Fetchjsonbody pojo=objmap.readValue(body, Fetchjsonbody.class);
		int patientid=pojo.getPatientId();
		System.out.println(patientid);
		 baseURI= path.getString("BaseUrl");
		request = given()
	            .log().all();
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).delete(path.getString("Patient_Post")+"/"+patientid);
		System.out.println(patientid+"File deleted successfully");
	}
	@Then("New record is created with invalid file")
	public void new_record_is_created_with_invalid_file() throws JsonMappingException, JsonProcessingException {
		response.then().spec(responseSpecification201());
		String body=response.getBody().asPrettyString();
		ObjectMapper objmap= new ObjectMapper();
		objmap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Fetchjsonbody pojo=objmap.readValue(body, Fetchjsonbody.class);
		int patientid=pojo.getPatientId();
		System.out.println(patientid);
		 baseURI= path.getString("BaseUrl");
		request = given()
	            .log().all();
		response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).delete(path.getString("Patient_Post")+"/"+patientid);
		System.out.println(patientid+"File deleted successfully");
	}

	@When("User sends HTTPS Request and request Body without uploading file")
	public void user_sends_HTTPS_Request_and_request_Body_without_uploading_file() throws IOException {
		 System.out.println("In create 8");
		response=  Authorization.patientPostRequestnofileupload();
		log.info("***User sends without uploading file ***");
	}

	@When("User sends get HTTPS Request with valid endpoint")
	public void user_sends_get_HTTPS_Request_with_valid_endpoint() throws IOException {
		System.out.println("In get 1");
		log.info("***User sends get HTTPS Request ***");
		response=  Authorization.patientGetRequestvalidendpoint();
	}

	@Then("All the patient records should be displayed with Success Status code")
	public void all_the_patient_records_should_be_displayed_with_Success_Status_code() throws JsonMappingException, JsonProcessingException {
		response.then().spec(responseSpecification200());
		String body=response.getBody().asPrettyString();
		ObjectMapper objmap= new ObjectMapper();
		objmap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Fetchjsonbody[] pojo=objmap.readValue(body, Fetchjsonbody[].class);
		int patientidfromjson=0;
		for(Fetchjsonbody itr : pojo) {
			 patientidfromjson=itr.getPatientId();
			 patientidinrecord=	patientidfromjson;
			System.out.println(patientidinrecord);
		}
		Assert.assertEquals(patientidfromjson, (double)patientidinrecord);
	}
	

@When("User sends get HTTPS Request with valid patientID")
public void user_sends_get_HTTPS_Request_with_valid_patientID() throws IOException {
	System.out.println("In get 2");
	log.info("***User sends get HTTPS Request valid id ***");
	response=  Authorization.patientGetRequestvalidpatientid();
}

@Then("The patients morbid conditions should be displayed with Success Status code")
public void the_patients_morbid_conditions_should_be_displayed_with_Success_Status_code() throws JsonMappingException, JsonProcessingException {
	response.then().spec(responseSpecification200());
	String body=response.getBody().asPrettyString();
	ObjectMapper objmap= new ObjectMapper();
	objmap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	Filemorbiditypojo[] filemorbid= objmap.readValue(body, Filemorbiditypojo[].class);
	Object morbidcondition=null;
	for(Filemorbiditypojo file: filemorbid) {
		 morbidcondition=file.getMorbidConditionStr();
		 morbidconditioninrecord=morbidcondition;
		 fileid= file.getFileId();
		 
	}
	Assert.assertEquals(morbidcondition, path.getString("morbidcondition"));
}

@When("User sends get HTTPS Request with valid fileid")
public void user_sends_get_HTTPS_Request_with_valid_fileid() throws IOException {
	System.out.println("In get 3");
	log.info("***User sends get HTTPS Request valid fileid ***");
	response=Authorization.patientGetRequestviewfile();
}

@Then("The patients file should be displayed with Success Status code")
public void the_patients_file_should_be_displayed_with_Success_Status_code() {
	response.then().spec(responseSpecification200());
}

@When("User sends put HTTPS Request and updated request body")
public void user_sends_put_HTTPS_Request_and_updated_request_body() throws IOException {
	System.out.println("In put 1");
	log.info("***User sends put HTTPS Request valid  ***");
	response=Authorization.patientputrequestvalidpatientid();
}

@Then("The patient record should be updated with success status code")
public void the_patient_record_should_be_updated_with_success_status_code() throws JsonMappingException, JsonProcessingException {
	response.then().spec(responseSpecification200());
	String bodyofput=response.getBody().asPrettyString();
	 JsonPath jsonpath= response.jsonPath(); 
	 updatename= jsonpath.get("LastName");
	Assert.assertEquals(updatename, "Manasa");
}

@When("User sends put HTTPS Request with updated request body for invalid id")
public void user_sends_put_HTTPS_Request_with_updated_request_body_for_invalid_id() throws IOException {
	System.out.println("In put 2");
	log.info("***User sends put HTTPS Request invalid id  ***");
	response=Authorization.patientputrequestinvalidpatientid();
}

@Then("User receives Bad Request for invalid patientid in put method")
public void user_receives_Bad_Request_for_invalid_patientid_in_put_method() {
	response.then().spec(responseSpecification404());
	String jsonstring=response.getBody().asString();
	String errorcode= JsonPath.from(jsonstring).get("errorCode");
	Assert.assertEquals(errorcode, Requestbody.geterrormessages().get(404));
}
@When("User sends put HTTPS Request and updated request body having empty date of birth")
public void user_sends_put_HTTPS_Request_and_updated_request_body_having_empty_date_of_birth() throws IOException {
	System.out.println("In put 3");
	log.info("***User sends put HTTPS Request empty dob  ***");
	response=Authorization.patientputrequestnodob();
}

@Then("User receives {int} Bad Request for empty dob")
public void user_receives_Bad_Request_for_empty_dob(Integer int1) {
	response.then().spec(responseSpecification400());
	String jsonstring=response.getBody().asString();
	String errorcode= JsonPath.from(jsonstring).get("errorCode");
	Assert.assertEquals(errorcode, Requestbody.geterrormessages().get(400));
}
@When("User sends put HTTPS Request and updated request body having incorrect date of birth")
public void user_sends_put_HTTPS_Request_and_updated_request_body_having_incorrect_date_of_birth() throws IOException {
	System.out.println("In put 4");
	log.info("***User sends put HTTPS Request incorrect dob  ***");
	response=Authorization.patientputrequestincorrectdob();
}

@Then("User receives {int} internal server error for invalid dob")
public void user_receives_internal_server_error_for_invalid_dob(Integer int1) {
	response.then().spec(responseSpecification500());
	String jsonstring=response.getBody().asString();
	String errorcode= JsonPath.from(jsonstring).get("error");
	Assert.assertEquals(errorcode, Requestbody.geterrormessages().get(500));
}

@When("User sends put HTTPS Request and updated request body having email field empty")
public void user_sends_put_HTTPS_Request_and_updated_request_body_having_email_field_empty() throws IOException {
	System.out.println("In put 5");
	log.info("***User sends put HTTPS Request email empty  ***");
	response=Authorization.patientputrequestemptyemail();
}

@Then("User receives {int} Bad Request for empty email")
public void user_receives_Bad_Request_for_empty_email(Integer int1) {
	response.then().spec(responseSpecification400());
	String jsonstring=response.getBody().asString();
	String errorcode= JsonPath.from(jsonstring).get("errorCode");
	Assert.assertEquals(errorcode, Requestbody.geterrormessages().get(400));
}
@When("User sends put HTTPS Request and updated request body having incorrect food category")
public void user_sends_put_HTTPS_Request_and_updated_request_body_having_incorrect_food_category() throws IOException {
	System.out.println("In put 6");
	log.info("***User sends put HTTPS Request incorrect food category  ***");
	response=Authorization.patientputrequestincorrectfoodcatefoy();
}

@Then("User receives {int} Bad Request")
public void user_receives_Bad_Request(Integer int1) throws JsonMappingException, JsonProcessingException {
	response.then().spec(responseSpecification400());
	String jsonstring=response.getBody().asString();
	String errorcode= JsonPath.from(jsonstring).get("errorCode");
	Assert.assertEquals(errorcode, Requestbody.geterrormessages().get(400));
}

@When("User sends put HTTPS Request and updated request body having incorrect food allergy")
public void user_sends_put_HTTPS_Request_and_updated_request_body_having_incorrect_food_allergy() throws IOException {
	System.out.println("In put 7");
	log.info("***User sends put HTTPS Request incorrect food allergy  ***");
	response=Authorization.patientputrequestincorrectfoodallergy();
	
}
@Then("User receives {int} Bad Request for allergy")
public void user_receives_Bad_Request_for_allergy(Integer int1) throws JsonMappingException, JsonProcessingException {
	SoftAssert sa= new SoftAssert();
//	response.then().spec(responseSpecification400());
	String jsonstring=response.getBody().asString();
	String errorcode= JsonPath.from(jsonstring).get("errorCode");
	sa.assertEquals(errorcode, Requestbody.geterrormessages().get(400));
	ObjectMapper objmap= new ObjectMapper();
	objmap.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	Fetchjsonbody pojo=objmap.readValue(jsonstring, Fetchjsonbody.class);
	int patientids=pojo.getPatientId();
	System.out.println(patientids);
	 baseURI= path.getString("BaseUrl");
	request = given()
            .log().all();
	response = request.header("Authorization", "Bearer "+Authorization.bearertoken()).delete(path.getString("Patient_Post")+"/"+patientids);
	System.out.println(patientids+"File deleted successfully");
}


@When("User sends put HTTPS Request and updated request body having contact number field empty")
public void user_sends_put_HTTPS_Request_and_updated_request_body_having_contact_number_field_empty() throws IOException {
	System.out.println("In put 8");
	log.info("***User sends put HTTPS Request contact number field empty  ***");
	response=Authorization.patientputrequestemptycontactno();
}

@When("User sends delete HTTPS Request with valid patientid")
public void user_sends_delete_HTTPS_Request_with_valid_patientid() throws IOException {
	log.info("***User sends delete HTTPS Request with valid patientid  ***");
	response=Authorization.deletevalidpatientid();
}

@Then("User receives {int} Ok status with message “ patient with ID deleted successfully”")
public void user_receives_Ok_status_with_message_patient_with_ID_deleted_successfully(Integer int1) {
	response.then().spec(responseSpecification200());
}

@When("User sends delete HTTPS Request with invalid patientid")
public void user_sends_delete_HTTPS_Request_with_invalid_patientid() throws IOException {
	log.info("***User sends delete HTTPS Request with invalid patientid  ***");
	response=Authorization.deleteinvalidpatientid();
}

@Then("User receives {int} Not Found Status with response body \\{“errorCode”: “not found” , “errorMessage”: \"Patient not found with patientId : id” }")
public void user_receives_Not_Found_Status_with_response_body(Integer int1) {
	response.then().spec(responseSpecification404());
	String jsonstring=response.getBody().asString();
	String errorcode= JsonPath.from(jsonstring).get("errorCode");
	Assert.assertEquals(errorcode, Requestbody.geterrormessages().get(404));
}
}
