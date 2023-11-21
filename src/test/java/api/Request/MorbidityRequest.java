package api.Request;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import api.Utilities.restUtils;
import io.restassured.response.Response;

public class MorbidityRequest extends restUtils {
	
	//***********************GET REQUEST****************************************
	public static Response getAllMorbidityRequest() throws FileNotFoundException {

		request = given().spec(requestSpecification()).log().all();
		response = request.header("Authorization", "Bearer " + DieticianPritoken).get(path.getString("Morbidity_Get"));
		response.prettyPrint();
		return response;
	}

	public static Response getAllMorbidity_BytestNameRequest() throws FileNotFoundException {

		request = given().spec(requestSpecification()).log().all();
		response = request.header("Authorization", "Bearer " + DieticianPritoken).get(path.getString("Morbidity_GetByTestname")+morbidityPayload.getMorbidityName());
		response.prettyPrint();
		return response;
	}

	//***********************GET REQUEST AS PATIENT ROLE ****************************************
		public static Response getAllMorbidity_AsPatientRole_Request() throws FileNotFoundException {

			request = given().spec(requestSpecification()).log().all();
			response = request.header("Authorization", "Bearer " + PatientPritoken).get(path.getString("Morbidity_Get"));
			response.prettyPrint();
			return response;
		}

		public static Response getAllMorbidity_BytestName_AsPatientRoleRequest() throws FileNotFoundException {

			request = given().spec(requestSpecification()).log().all();
			response = request.header("Authorization", "Bearer " + PatientPritoken).get(path.getString("Morbidity_GetByTestname")+morbidityPayload.getMorbidityName());
			response.prettyPrint();
			return response;
		}


}
