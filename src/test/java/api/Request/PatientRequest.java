package api.Request;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;

import api.Pojo.PatientPayload;
import api.Pojo.UserLoginPayload;
import api.Utilities.restUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatientRequest extends restUtils {
	
	
	// **********************----------------Dietician ROLE-------------------****************************
	// ***************-------------POST REQUEST-------------*********************
	// CreatePatient Post request

	public static Response patientPostRequest(PatientPayload payload) throws FileNotFoundException {

		request = given().accept(ContentType.MULTIPART)
				.queryParam("patientInValue", patientPayload.getPatientInfoValue())
				.multiPart("patientInfo", patientPayload.getPatientInfo())
				.multiPart("file", new File(path.getString("Patientfile1"))).log().all();

		//System.out.println(patientPayload.getPatientInfoValue());
		response = request.header("Authorization", "Bearer " + DieticianPritoken).accept(ContentType.ANY)
				.post(path.getString("Patient_Post"));

		return response;
	}

	// ***************-------------------GET REQUEST-------------------*********************
	// GetALLPatient Get request

	public static Response getALLPatientRequest() throws FileNotFoundException {

		request = given().spec(requestSpecification()).log().all();
		response = request.header("Authorization", "Bearer " + DieticianPritoken).get(path.getString("Patient_GetALL"));
		response.prettyPrint();
		return response;
	}

	// Get patient test reports by Patient id

	public static Response getPatient_ByPatientID_Request() throws FileNotFoundException {

		request = given().spec(requestSpecification()).log().all();
		response = request.header("Authorization", "Bearer " + DieticianPritoken)
				.get(path.getString("Patient_Get_ByID") + PriPatientId);
		response.prettyPrint();
		return response;
	}

	// Get Patient file by FileId

	public static Response getPatient_ByFileID_Request() throws FileNotFoundException {

		request = given().spec(requestSpecification());
		response = request.header("Authorization", "Bearer " + DieticianPritoken)
				.get(path.getString("Patient_Get_ByFileID") + PriPatientFileId);
		// response.prettyPrint();
		return response;

	}

	// ***************---------------------UPDATE REQUEST------------------------*********************

	public static Response patientPUTRequest(PatientPayload payload) throws FileNotFoundException {

		request = given().accept(ContentType.MULTIPART)
				.queryParam("patientInValue", patientPayload.getPatientInfoValue())
				.multiPart("patientInfo", patientPayload.getPatientInfo())
				.multiPart("file", new File(path.getString("Patientfile1")));

		// System.out.println(patientPayload.getPatientInfoValue());
		response = request.header("Authorization", "Bearer " + DieticianPritoken).accept(ContentType.ANY)
				.put(path.getString("Patient_Put") + PriPatientId);

		// response.prettyPrint();
		return response;
	}

	// ***************--------------------Delete REQUEST-------------------*********************

	// Delete patient by ID

	public static Response deletePatientRequest() throws FileNotFoundException {

		request = given().spec(requestSpecification()).log().all();
		response = request.header("Authorization", "Bearer " + DieticianPritoken)
				.delete(path.getString("Patient_Delete") + PriPatientId);
		// response.prettyPrint();

		return response;
	}

	// **********************----------------PATIENT ROLE-------------------****************************
	// Get patient test reports by Patient id

	public static Response getPatient_ByPatientID_AsPatientRole_Request() throws FileNotFoundException {

		request = given().spec(requestSpecification()).log().all();
		response = request.header("Authorization", "Bearer " + PatientPritoken)
				.get(path.getString("Patient_Get_ByID") + PriPatientId);
		response.prettyPrint();
		return response;
	}

	// Get Patient file by FileId

	public static Response getPatient_ByFileID_AsPatientRole_Request() throws FileNotFoundException {

		request = given().spec(requestSpecification());
		response = request.header("Authorization", "Bearer " + PatientPritoken)
				.get(path.getString("Patient_Get_ByFileID") + PriPatientFileId);
		// response.prettyPrint();
		return response;

	}

	// GetALLPatient Get request

	public static Response getALLPatient_AsPatientRole_Request() throws FileNotFoundException {

		request = given().spec(requestSpecification()).log().all();
		response = request.header("Authorization", "Bearer " + PatientPritoken).get(path.getString("Patient_GetALL"));
		response.prettyPrint();
		return response;
	}

}
