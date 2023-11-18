package api.StepDefinitions;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import java.io.FileNotFoundException;
import java.io.IOException;
import api.Utilities.restUtils;


public class UserAsDietician extends restUtils{
	
	@Given("User creates Post Request for Dietician role with authorization set to bearer token for Dietician API endpoint")
	public void user_creates_Post_Request_for_Dietician_role_with_authorization_set_to_bearer_token_for_Dietician_API_endpoint() {
	    
		String baseUrl = path.getString("BaseUrl");// assigning baseurl value stored in string
		baseURI = baseUrl;
		//code for authorization
		log.info("***User sends request with BaseURL***");
	}

	@When("User sends HTTPS  Request and  request Body with valid credentials")
	public void user_sends_HTTPS_Request_and_request_Body_with_valid_credentials() {
	    
	}

	@Then("User receives  {int} success status with response body")
	public void user_receives_success_status_with_response_body(Integer int1) {
	   
	}

}
