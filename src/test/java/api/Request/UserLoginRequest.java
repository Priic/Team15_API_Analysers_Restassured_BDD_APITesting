package api.Request;

import api.Pojo.UserLoginPayload;
import api.Utilities.restUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import java.io.FileNotFoundException;

public class UserLoginRequest extends restUtils{
	
	//Userlogin Post request
	
	public static Response userLoginPostRequest(UserLoginPayload payload) throws FileNotFoundException {
		
		request=given().spec(requestSpecification()).body(payload);
		response=request.body(payload).post(path.getString("User_Post"));
		response.prettyPrint();
		return response;
	}
	




}
