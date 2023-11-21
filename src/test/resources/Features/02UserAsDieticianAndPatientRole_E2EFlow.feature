Feature: User as a Dietician and Patient End to End Flow Feature


 	 	@PostRequest_CreateTokenForValidDietician
  	Scenario: A token is generated for Dietician with valid credentials
  	
  	Given User create request for Dietician API endpoint
    When User sends HTTPS Post Request and  request Body to generate access token for valid Dietician 
    Then User receives  200 success status with response body and token is generated
    
    @PostRequest_CreateNewPatient
  	Scenario: User with Dietician role and valid credentials is able to create new patients
  
  	Given User create request for Dietician API endpoint
    When User sends HTTPS Post Request and  request Body to create a new Patient
    Then User receives  201 created status with response body and patient is created
    
   @GetRequest_GetAllPatient
  	Scenario: User with Dietician role and valid credentials is able to create new patients
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient
    Then User receives  200 success status with response body
    
    @GetRequest_GETAllMorbidity
  	Scenario: User with Dietician role and valid credentials is able to view all patient morbidity details
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient morbidity details
    Then User receives  200 success status with response body
    
    @GetRequest_GETMorbidity_ByTestName
  	Scenario: User with Dietician role and valid credentials is able to view all patient morbidity by testname
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient morbidity by testname
    Then User receives  200 success status with response body
    
    @GetRequest_GETPatient_MorbidityDetails_ByPatientID
  	Scenario: User with Dietician role and valid credentials is able to view all patient test reports by patientID
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view patient test reports by patientID
    Then User receives  200 success status with response body 	
    
    @GetRequest_GETPatient_Details_ByFileID
  	Scenario: User with Dietician role and valid credentials is able to view all patient test reports by patientID
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view patient test reports by FileID
    Then User receives  200 success status with response body 	
    
    @PutRequest_UpdatePatient
  	Scenario: User with Dietician role and valid credentials is able to create new patients
  
  	Given User create request for Dietician API endpoint
    When User sends HTTPS Put Request and  request Body to update patient details
    Then User receives  200 success status with response body 
   	
   	
    @DeleteRequest_DeletePatientBypatienID
  	Scenario: User with Dietician role and valid credentials is able to create new patients
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS delete Request to patient by Id
    Then User receives  200 success status with response body
    
  @PostRequest_CreateNewPatient2
  	Scenario: User with Dietician role and valid credentials is able to create new patients
  
  	Given User create request for Dietician API endpoint
    When User sends HTTPS Post Request and  request Body to create a new Patient
    Then User receives  201 created status with response body and patient is created
    
    @GetRequest_GETLogoutDietician
  	Scenario: User with Dietician role and valid credentials is able to Logout 
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to logout as Dietician
    Then User receives  200 success status with response body 	
    
     @GetRequest_GetAllPatient
  	Scenario: User with Dietician role and valid credentials after logout should not be able to view patients
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient
     Then User receives  401 Unauthorized status with response body   
    
     @PutRequest_UpdatePatient
  	Scenario: User with Dietician role and valid credentials after logout should not be able to update new patients
  
  	Given User create request for Dietician API endpoint
    When User sends HTTPS Put Request and  request Body to update patient details
    Then User receives  401 Unauthorized status with response body  
    
    @GetRequest_GETAllMorbidity
  	Scenario: User with Dietician role and valid credentials after logout should not be able to view all patient morbidity details
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient morbidity details
    Then User receives  401 Unauthorized status with response body 
    
    @GetRequest_GETMorbidity_ByTestName
  	Scenario: User with Dietician role and valid credentials after logout should not be able to view all patient morbidity by testname
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient morbidity by testname
     Then User receives  401 Unauthorized status with response body 
    
    @GetRequest_GETPatient_MorbidityDetails_ByPatientID
  	Scenario: User with Dietician role and valid credentials after logout should not be able to view all patient test reports by patientID
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view patient test reports by patientID
     Then User receives  401 Unauthorized status with response body 
    
    @GetRequest_GETPatient_Details_ByFileID
  	Scenario: User with Dietician role and valid credentials after logout should not be able to view all patient test reports by patientID
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view patient test reports by FileID
     Then User receives  401 Unauthorized status with response body  	
    
    @PostRequest_CreateTokenForValidPatient
  	Scenario: A token is generated for Dietician with valid credentials
  	
  	Given User create request for Dietician API endpoint
    When User sends HTTPS Post Request and  request Body to generate access token for valid Patient 
    Then User receives  200 success status with response body and token is generated
    
    @GetRequest_GETPatient_MorbidityDetails_ByPatientID_PatientRole
  	Scenario: User with Patient role and valid credentials is able to view all patient test reports by patientID
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view patient test reports by patientID as Patient role
    Then User receives  200 success status with response body 	
    
    @GetRequest_GETPatient_Details_ByFileID_PatientRole
  	Scenario: User with Patient role and valid credentials is able to view  patient test reports by patientID
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view patient test reports by FileID as Patient role
    Then User receives  200 success status with response body 
    
     @GetRequest_GetAllPatient_PatientRole
  	Scenario: User with Patient role and valid credentials should not be able to view all patients records
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient as Patient role
    Then User receives  403 Unauthorized status with response body 
    
    @GetRequest_GETAllMorbidity_PatientRole
  	Scenario: User with Dietician role and valid credentials after logout should not be able to view all patient morbidity details
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient morbidity details as a Patient role
    Then User receives  403 Unauthorized status with response body 
    
    @GetRequest_GETMorbidity_ByTestName_PatientRole
  	Scenario: User with Dietician role and valid credentials after logout should not be able to view all patient morbidity by testname
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to view all patient morbidity by testname as a Patient role
    Then User receives  403 Unauthorized status with response body	
    
    @GetRequest_GETLogoutPatient
  	Scenario: User with Dietician role and valid credentials is able to Logout 
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to logout as Patient
    Then User receives  200 success status with response body 	
    
    @PostRequest_CreateTokenForValidDietician
  	Scenario: A token is generated for Dietician with valid credentials
  	
  	Given User create request for Dietician API endpoint
    When User sends HTTPS Post Request and  request Body to generate access token for valid Dietician 
    Then User receives  200 success status with response body and token is generated
    
     @DeleteRequest_DeletePatientBypatienID
  	Scenario: User with Dietician role and valid credentials is able to create new patients
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS delete Request to patient by Id
    Then User receives  200 success status with response body
    
    @GetRequest_GETLogoutDietician
  	Scenario: User with Dietician role and valid credentials is able to Logout 
  	
    Given User create request for Dietician API endpoint
    When User sends HTTPS Get Request to logout as Dietician
    Then User receives  200 success status with response body 	
    
    
  	