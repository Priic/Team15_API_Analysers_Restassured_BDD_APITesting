@tag
Feature: Patient Module as Dietician
Background: User is logged in as dietician
Given User is logged in as dietician

   @createpatient
 Scenario: Check if user is able to Add a Patient with valid details
 When User sends HTTPS Request having request Body with mandatory fields patientInfo and file
 Then User receives successful Created Status with response body having matching details from the request body
 
       @createpatient
 Scenario: Check if user is able to Add a Patient with empty first name and last name
 When User sends HTTPS Request having request Body with empty first name and last name and mandatory fields patientInfo and file  
 Then Bad Request status code is displayed with the error message "User First Name is Mandatory!\n User Last Name is Mandatory!\n" 
 
 
  @createpatient
 Scenario: Check if user is able to Add a Patient with invalid food category
 When User sends HTTPS Request having request Body with invalid food category and mandatory fields patientInfo and file  
 Then Bad Request status code is displayed with food category error message "Invalid food catgory" 
 
  @createpatient
 Scenario: Check if user is able to add a Patient with invalid Email and Contact info 
 When User sends HTTPS Request and  request Body with Invalid Contact no and Email
 Then Bad Request status code is displayed with the Email error message  
 
   @createpatient
 Scenario: Check if user is able to add a Patient with invalid Email and DOB fields 
 When User sends HTTPS Request and  request Body with Invalid Email and DOB 
 Then Internal Server Error status code is displayed 
 
  
   @createpatient
 Scenario: Check if user is able to add a duplicate Patient record with same contact no and DOB fields 
 When User sends HTTPS Request and  request Body with duplicate contact and dateofbirth details 
 Then Bad Request status code is displayed with contact and dob error message
 
    @createpatient
 Scenario: Check if user is able to add a Patient with invalid File input 
 When User sends HTTPS Request and  request Body with invalid File upload
 Then New record is created with invalid file 
 
    @createpatient
 Scenario: Check if user is able to add a Patient without uploading file
 When User sends HTTPS Request and request Body without uploading file
 Then New record is created with empty file fields
 
     @getpatient
 Scenario: Check if user is able to retrieve all patient records with valid endpoint 
 When User sends get HTTPS Request with valid endpoint
 Then All the patient records should be displayed with Success Status code
 
 
@getpatient
 Scenario: Check if user is able to retrieve the Patients morbidity details
 When User sends get HTTPS Request with valid patientID 
 Then The patients morbid conditions should be displayed with Success Status code
 
 
 @getpatient
 Scenario: Check if user is able to view the Patients test report
 When User sends get HTTPS Request with valid fileid 
 Then The patients file should be displayed with Success Status code
 
 @updatepatient
  Scenario: Check if user able to update patient information with valid patientID 
 When User sends put HTTPS Request and updated request body
 Then The patient record should be updated with success status code 
 
  @updatepatient
  Scenario: Check if user able to update patient information with invalid patientID 
 When User sends put HTTPS Request with updated request body for invalid id
 Then User receives Bad Request for invalid patientid in put method
 
 @updatepatient
  Scenario: Check if user able to update patient information with empty Date of Birth  
 When User sends put HTTPS Request and updated request body having empty date of birth
 Then User receives 400 Bad Request for empty dob
 
  @updatepatient
  Scenario: Check if user able to update patient information with incorrect Date of Birth  
 When User sends put HTTPS Request and updated request body having incorrect date of birth
 Then User receives 500 internal server error for invalid dob
 
  @updatepatient
  Scenario: Check if user able to update patient information with empty email  
 When User sends put HTTPS Request and updated request body having email field empty
 Then User receives 400 Bad Request for empty email
 
   @updatepatient
  Scenario: Check if user able to update patient information with incorrect food category  
 When User sends put HTTPS Request and updated request body having incorrect food category
 Then User receives 400 Bad Request 
 
  @updatepatient
  Scenario: Check if user able to update patient information with incorrect food allergy  
 When User sends put HTTPS Request and updated request body having incorrect food allergy
 Then User receives 400 Bad Request for allergy
 
 
  @updatepatient
  Scenario: Check if user able to update patient information with contact number as empty field 
 When User sends put HTTPS Request and updated request body having contact number field empty
 Then User receives 400 Bad Request 
 
   @deletepatient
  Scenario: Check if user able to delete a patient with valid patientId
 When User sends delete HTTPS Request with valid patientid
 Then User receives 200 Ok status with message “ patient with ID deleted successfully”
 
    @deletepatient
  Scenario: Check if user able to delete a patient with invalid patientId
 Given User is logged in as dietician
 When User sends delete HTTPS Request with invalid patientid
 Then User receives 404 Not Found Status with response body {“errorCode”: “not found” , “errorMessage”: "Patient not found with patientId : id” }
 
 