Feature: User as a Dietician End to End Flow Feature


 	 	@PostRequest_CreateTokenForValidDietician
  	Scenario: A token is generated for Dietician with valid credentials
  	
  	Given User create request for Dietician API endpoint
    When User sends HTTPS Post Request and  request Body to generate access token for valid Dietician 
    Then User receives  200 success status with response body and token is generated
    
    
   @GetRequest_ViewAllPatient
  	Scenario: User with Dietician role and valid credentials is able to create new patients
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient
    Then User receives  200 success status with response body
    
    	   
   @PostRequest_CreateNewPatient
  Scenario: User with Dietician role and valid credentials is able to create new patients
  
  	Given User create request for Dietician API endpoint
    When User sends HTTPS Post Request and  request Body to create a new Patient
    Then User receives  201 created status with response body and patient is created
    
     @DeleteRequest_DeletePatientBypatienID
  	Scenario: User with Dietician role and valid credentials is able to create new patients
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS delete Request to patient by Id
    Then User receives  200 success status with response body
    
    
  	