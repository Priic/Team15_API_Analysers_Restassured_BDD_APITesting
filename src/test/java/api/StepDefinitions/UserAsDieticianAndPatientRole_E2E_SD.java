package api.StepDefinitions;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import api.Request.MorbidityRequest;
import api.Request.PatientRequest;
import api.Request.UserLoginRequest;
import api.RequestBody.MorbiditityRequestBody;
import api.RequestBody.PatientRequestBody;
import api.RequestBody.UserLoginRequestBody;
import api.Utilities.restUtils;

public class UserAsDieticianAndPatientRole_E2E_SD extends restUtils {

	@Given("User create request for Dietician API endpoint")
	public void user_create_request_for_Dietician_API_endpoint() {

		String baseUrl = path.getString("BaseUrl");// assigning baseurl value stored in string
		baseURI = baseUrl;
		log.info("***User sends request with BaseURL***");
		// System.out.println("Token generate:" + DieticianPritoken);

	}

	@When("User sends HTTPS Post Request and  request Body to generate access token for valid Dietician")
	public void user_sends_HTTPS_Post_Request_and_request_Body_to_generate_access_token_for_valid_Dietician()
			throws IOException {

		userLoginPayload = UserLoginRequestBody.UserLoginPostBody();
		response = UserLoginRequest.userLoginPostRequest(userLoginPayload);
		DieticianPritoken = response.path("token");
		System.out.println("Token generate:" + DieticianPritoken);
		log.info("***Dietician Token generated***");
	}

	@Then("User receives  {int} success status with response body and token is generated")
	public void user_receives_success_status_with_response_body_and_token_is_generated(Integer int1) {

		response.then().spec(responseSpecification200()).body(matchesJsonSchema(UserPostJson)).log().all();

		assertEquals(userLoginPayload.getUserLoginEmail(), response.jsonPath().getString("loginUserEmail"));
		assertEquals(DieticianPritoken, response.jsonPath().getString("token"));

	}

	@When("User sends HTTPS Get Request to view all patient")
	public void user_sends_HTTPS_Get_Request_to_view_all_patient() throws FileNotFoundException {

		response = PatientRequest.getALLPatientRequest();
		log.info("***to view all patient***");
	}

	@Then("User receives  {int} success status with response body")
	public void user_receives_success_status_with_response_body(Integer int1) {

		response.then().spec(responseSpecification200());
	}

	@When("User sends HTTPS Post Request and  request Body to create a new Patient")
	public void user_sends_HTTPS_Post_Request_and_request_Body_to_create_a_new_Patient() throws IOException {

		log.info("***to Create new patient***");
		patientPayload = PatientRequestBody.CreatePatientPostBody();
		response = PatientRequest.patientPostRequest(patientPayload);
		String responsebody = response.body().asString();

		PriPatientId = response.path("patientId").toString();
		patientPayload.setEmail(response.path("Email").toString());
		patientPayload.setPatientId(response.path("patientId").toString());
		System.out.println("patient id:" + PriPatientId);
		response.prettyPrint();

	}

	@When("User sends HTTPS delete Request to patient by Id")
	public void user_sends_HTTPS_delete_Request_to_patient_by_Id() throws FileNotFoundException {

		log.info("***to delete patient***");
		response = PatientRequest.deletePatientRequest();
		response.prettyPrint();
	}

	@Then("User receives  {int} created status with response body and patient is created")
	public void user_receives_created_status_with_response_body_and_patient_is_created(Integer int1) {

		response.then().spec(responseSpecification201()).body(matchesJsonSchema(PatientPostJson)).log().all();

		assertEquals(patientPayload.getFirstName(), response.jsonPath().getString("FirstName"));
		assertEquals(patientPayload.getLastName(), response.jsonPath().getString("LastName"));
		assertEquals(patientPayload.getEmail(), response.jsonPath().getString("Email"));
		assertEquals(patientPayload.getContactNumber(), response.jsonPath().getString("ContactNumber"));
		assertEquals(patientPayload.getDateOfBirth(), response.jsonPath().getString("DateOfBirth"));
		assertEquals(PriPatientId, response.jsonPath().getString("patientId"));

	}

	@When("User sends HTTPS Get Request to view all patient morbidity details")
	public void user_sends_HTTPS_Get_Request_to_view_all_patient_morbidity_details() throws FileNotFoundException {

		log.info("***view all patient morbidity details***");
		response = MorbidityRequest.getAllMorbidityRequest();

	}

	@When("User sends HTTPS Get Request to view all patient morbidity by testname")
	public void user_sends_HTTPS_Get_Request_to_view_all_patient_morbidity_by_testname() throws IOException {

		log.info("***to view all patient morbidity by testname***");
		MorbiditityRequestBody.getMorbidityDetails();
		response = MorbidityRequest.getAllMorbidity_BytestNameRequest();

	}

	@When("User sends HTTPS Get Request to view patient test reports by patientID")
	public void user_sends_HTTPS_Get_Request_to_view_all_patient_test_reports_by_patientID()
			throws FileNotFoundException {

		response = PatientRequest.getPatient_ByPatientID_Request();
		PriPatientFileId = response.path("fileId[0]").toString();
		System.out.println("FileId" + PriPatientFileId);

	}

	@When("User sends HTTPS Get Request to view patient test reports by FileID")
	public void user_sends_HTTPS_Get_Request_to_view_patient_test_reports_by_FileID() throws FileNotFoundException {

		response = PatientRequest.getPatient_ByFileID_Request();

	}

	@When("User sends HTTPS Put Request and  request Body to update patient details")
	public void user_sends_HTTPS_Put_Request_and_request_Body_to_update_patient_details() throws IOException {

		patientPayload = PatientRequestBody.UpdatePatientPutBody();
		response = PatientRequest.patientPUTRequest(patientPayload);

		String responsebody = response.body().asString();
		System.out.println("patienID: " + PriPatientId);
		System.out.println("EmailPatient: " + patientPayload.getEmail());

	}

	@When("User sends HTTPS Get Request to logout as Dietician")
	public void user_sends_HTTPS_Get_Request_to_logout_as_Dietician() throws FileNotFoundException {

		response = UserLoginRequest.LogOutDietician_GetRequest();

	}

	@Then("User receives  {int} Unauthorized status with response body")
	public void user_receives_Unauthorized_status_with_response_body(Integer int1) {

		response.then().spec(responseSpecification403());
	}

	@When("User sends HTTPS Post Request and  request Body to generate access token for valid Patient")
	public void user_sends_HTTPS_Post_Request_and_request_Body_to_generate_access_token_for_valid_Patient()
			throws IOException {

		userLoginPayload = UserLoginRequestBody.UserLoginPatientPostBody();
		response = UserLoginRequest.userLoginPatientPostRequest(userLoginPayload);
		PatientPritoken = response.path("token");
		System.out.println("Token generate:" + PatientPritoken);

	}

	@When("User sends HTTPS Get Request to view patient test reports by patientID as Patient role")
	public void user_sends_HTTPS_Get_Request_to_view_patient_test_reports_by_patientID_as_Patient_role()
			throws FileNotFoundException {

		response = PatientRequest.getPatient_ByPatientID_AsPatientRole_Request();
		System.out.println("FileId" + PriPatientFileId);

	}

	@When("User sends HTTPS Get Request to view patient test reports by FileID as Patient role")
	public void user_sends_HTTPS_Get_Request_to_view_patient_test_reports_by_FileID_as_Patient_role()
			throws FileNotFoundException {

		response = PatientRequest.getPatient_ByFileID_AsPatientRole_Request();

	}

	@When("User sends HTTPS Get Request to view all patient as Patient role")
	public void user_sends_HTTPS_Get_Request_to_view_all_patient_as_Patient_role() throws FileNotFoundException {

		response = PatientRequest.getALLPatient_AsPatientRole_Request();
	}

	@When("User sends HTTPS Get Request to view all patient morbidity details as a Patient role")
	public void user_sends_HTTPS_Get_Request_to_view_all_patient_morbidity_details_as_a_Patient_role()
			throws FileNotFoundException {

		response = MorbidityRequest.getAllMorbidity_AsPatientRole_Request();
	}

	@When("User sends HTTPS Get Request to view all patient morbidity by testname as a Patient role")
	public void user_sends_HTTPS_Get_Request_to_view_all_patient_morbidity_by_testname_as_a_Patient_role()
			throws IOException {

		MorbiditityRequestBody.getMorbidityDetails();
		response = MorbidityRequest.getAllMorbidity_BytestName_AsPatientRoleRequest();

	}

	@When("User sends HTTPS Get Request to logout as Patient")
	public void user_sends_HTTPS_Get_Request_to_logout_as_Patient() throws FileNotFoundException {
		response = UserLoginRequest.LogOutPatient_GetRequest();
	}

}
