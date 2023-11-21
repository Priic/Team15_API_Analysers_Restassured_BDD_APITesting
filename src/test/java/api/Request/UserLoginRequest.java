package api.Request;

import api.Pojo.UserLoginPayload;
import api.Utilities.restUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import java.io.FileNotFoundException;

public class UserLoginRequest extends restUtils{
	
	//Userlogin as Dietician Post request
	
	public static Response userLoginPostRequest(UserLoginPayload payload) throws FileNotFoundException {
		
		request=given().spec(requestSpecification()).body(payload);
		response=request.body(payload).post(path.getString("User_Post"));
		response.prettyPrint();
		return response;
	}
	
	//Userlogot as Dietician Get request
	public static Response LogOutDietician_GetRequest() throws FileNotFoundException {

		request = given().spec(requestSpecification());
		response = request.header("Authorization", "Bearer " + DieticianPritoken).get(path.getString("User_Get"));
		response.prettyPrint();
		return response;
	}
//**********************************PATIENTROLE**********************************************
	//Userlogin as Patient Post request
	
		public static Response userLoginPatientPostRequest(UserLoginPayload payload) throws FileNotFoundException {
			
			request=given().spec(requestSpecification()).body(payload);
			response=request.body(payload).post(path.getString("User_Post"));
			response.prettyPrint();
			return response;
		}
		
		//Userlogout as Patient Get request
		public static Response LogOutPatient_GetRequest() throws FileNotFoundException {

			request = given().spec(requestSpecification());
			response = request.header("Authorization", "Bearer " + PatientPritoken).get(path.getString("User_Get"));
			response.prettyPrint();
			return response;
		}


}
