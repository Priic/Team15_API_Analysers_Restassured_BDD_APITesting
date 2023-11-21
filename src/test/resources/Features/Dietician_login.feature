@tag
Feature: Patient Module as Dietician
Background: Authorization is set to bearer token
Given User sets Authorization to Bearer token 

  #@login
  #Scenario: Check if user able to Login as a Dietician with valid credentials
    #When User sends HTTPS Request having request Body with mandatory Loginemail and password fields
    #Then User receives success status code with the token displayed in the response body
 

  @login
  Scenario: Check if user is able to login with empty fields
    When User sends HTTPS Request having request Body with empty Loginemail and password fields
    Then Unauthorized status code is displayed

    #
  #@login
 #Scenario: Check if user is able to login with invalid password 
 #When User sends HTTPS Request having request Body with valid Loginemail and invalid password
 #Then Unauthorized status code is displayed
    #
     #@login
 #Scenario: Check if user is able to login with invalid email 
 #When User sends HTTPS Request having request Body with invalid Loginemail and valid password
 #Then Unauthorized status code is displayed
 #
      #@login
 #Scenario: Check if user is able to login with invalid email 
 #When User sends HTTPS Request having request Body with invalid Loginemail and valid password
 #Then Unauthorized status code is displayed
