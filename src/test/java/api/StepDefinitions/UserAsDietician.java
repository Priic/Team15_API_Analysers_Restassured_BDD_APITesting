package api.StepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.FileNotFoundException;
import java.io.IOException;

import api.Pojo.PatientPayload;
import api.Pojo.UserLoginPayload;
import api.Request.PatientRequest;
import api.Request.UserLoginRequest;
import api.RequestBody.PatientRequestBody;
import api.RequestBody.UserLoginRequestBody;
import api.Utilities.restUtils;

public class UserAsDietician extends restUtils {

	@Given("User create request for Dietician API endpoint")
	public void user_create_request_for_Dietician_API_endpoint() {

		String baseUrl = path.getString("BaseUrl");// assigning baseurl value stored in string
		baseURI = baseUrl;
		log.info("***User sends request with BaseURL***");
		System.out.println("Token generate:" + DieticianPritoken);

	}

	@When("User sends HTTPS Post Request and  request Body to generate access token for valid Dietician")
	public void user_sends_HTTPS_Post_Request_and_request_Body_to_generate_access_token_for_valid_Dietician()
			throws IOException {

		userLoginPayload = UserLoginRequestBody.UserLoginPostBody();
		response = UserLoginRequest.userLoginPostRequest(userLoginPayload);
		DieticianPritoken = response.path("token");
		System.out.println("Token generate:" + DieticianPritoken);
	}

	@Then("User receives  {int} success status with response body and token is generated")
	public void user_receives_success_status_with_response_body_and_token_is_generated(Integer int1) {

		response.then().spec(responseSpecification200());

	}

	@When("User sends HTTPS Get Request to view all patient")
	public void user_sends_HTTPS_Get_Request_to_view_all_patient() throws FileNotFoundException {

		response = PatientRequest.getALLPatientRequest();
		response.prettyPrint();

	}

	@Then("User receives  {int} success status with response body")
	public void user_receives_success_status_with_response_body(Integer int1) {

		response.then().spec(responseSpecification200());
	}

	@When("User sends HTTPS Post Request and  request Body to create a new Patient")
	public void user_sends_HTTPS_Post_Request_and_request_Body_to_create_a_new_Patient() throws IOException {

		// patientPayload=PatientRequestBody.CreatePatientPostBody();
		response = PatientRequest.patientPostRequest();
//		
//		String res=response.getBody().asString();
//		System.out.println(res); 
//		JsonPath js=new JsonPath(res);
//		PriPatientId=js.getString("patientId");
//		
		
		//	ResponseBody 
	//	Parser.JSON.
	//	PriPatientId=response.path("patientId").toString();
//		System.out.println("new patient id:"+PriPatientId);
		
		//programPayload.setProgramId(response.path("programId"));
		response.prettyPrint();
	}


	@When("User sends HTTPS delete Request to patient by Id")
	public void user_sends_HTTPS_delete_Request_to_patient_by_Id() throws FileNotFoundException {
		
		response=PatientRequest.deletePatientRequest();
		response.prettyPrint();
	}

	@Then("User receives  {int} created status with response body and patient is created")
	public void user_receives_created_status_with_response_body_and_patient_is_created(Integer int1) {

		response.then().spec(responseSpecification201());
	}
	

}
