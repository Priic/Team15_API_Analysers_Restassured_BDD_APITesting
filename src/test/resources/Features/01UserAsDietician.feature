Feature: User as a Dietician Feature


 	 	@PostRequest_UserLoggedInAsValidDietician
  	Scenario: User is able to logged in as Dietician with valid Credentials in Dietician application
  	
    Given User creates Post Request for Dietician role with authorization set to bearer token for Dietician API endpoint
    When User sends HTTPS  Request and  request Body with valid credentials
    Then User receives  200 success status with response body
    
    
  	