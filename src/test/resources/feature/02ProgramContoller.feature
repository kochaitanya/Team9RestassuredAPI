@ProgramController 
Feature: Program Controller
#Background: Admin sets authorization to bearertoken
#	Given Admin creates request with valid credentials
    #When Admin calls Post Https method  with valid endpoint
    #Then Admin receives 200 created with auto generated token
    
 @01PostRequest_Program
  Scenario: Check if Admin able to create a program with valid endpoint and request body with Authorization
    Given Admin creates POST program Request for the LMS with request body
    When Admin sends HTTPS post program Request and  request Body with endpoint
    Then Admin receives 201 Created program Status with response body.
    
  #@01PostRequest_Program_InvalidEndpoint
  #Scenario: Check if Admin able to create a program with invalid endpoint
    #Given Admin creates POST program Request for the LMS with request body
    #When Admin sends HTTPS post program Request and  request Body with invalid endpoint
    #Then Admin receives 404 not found  program Status with message and boolean success details
    
    #@01PostRequest_Program_2_InvalidBaseURI
  #Scenario: Check if Admin able to create a program with invalid BaseURI and valid endpoint
    #Given Admin creates POST program Request for the LMS with request body and invalid BaseURI
    #When Admin sends HTTPS post program Request and  request Body with invalid BaseURI and valid endpoint
    #Then Admin receives 404 not found program Status for invalid BaseURI with message and boolean success details
    #
    #@01PostRequest_Program_InvalidMethod
  #Scenario: Check if Admin able to create a program with invalid method
    #Given Admin creates POST program Request for the LMS with request body
    #When Admin sends HTTPS post program Request and request Body with endpoint along with invalid method
    #Then Admin receives 405 Method Not Allowed for program controller
        
  #@02GetRequest_AllPrograms
  #Scenario: Check if Admin able to retrieve all programs with valid Endpoint
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS get program Request with endpoint
    #Then Admin receives 200 OK get program Status with response body.   
    
  #@02GetRequest_AllPrograms_InvalidEndpoint
  #Scenario: Check if Admin able to retrieve all programs with invalid Endpoint
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request with invalid endpoint
    #Then Admin receives 404 not found program Status with error message   
    
#	@02GetRequest_AllPrograms_InvalidBaseURI
  #Scenario: Check if Admin able to retrieve all programs with invalid BaseURI and valid Endpoint
    #Given Admin creates GET program Request for the LMS API with invalid BaseURI
    #When Admin sends HTTPS program get Request with invalid BaseURI and valid endpoint
    #Then Admin receives 404 Not Found program get Status with message and boolean success details 
    #
    #@02GetRequest_AllPrograms_InvalidMethod
  #Scenario: Check if Admin able to retrieve all programs with invalid Method
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request and request Body with endpoint along with invalidmethod
    #Then Admin receives 405 Method Not Allowed 
    
   #@03GetRequest_ValidProgramID
  #Scenario Outline: Check if Admin able to retrieve a program with valid program ID
    #Given Admin creates GET program by ID Request for the LMS API with valid "<programID>"
    #When Admin sends HTTPS get by program ID Request with endpoint
    #Then Admin receives "<status>" program Status with response body. 
    #
    #Examples: 
      #| programID|status|
      #| 16430		|200	|
      #|17036		 |200		|
      #|143			 |404		|
    
   #@03GetRequest_ProgramID_InvalidBaseURI
  #Scenario: Check if Admin able to retrieve a program with invalid baseURI and valid Endpoint
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request with invalid baseURI and valid endpoint
    #Then Admin receives 404 Not Found program Status with message and boolean success details
    #
     #@03GetRequest_ProgramID_InvalidEndPoint
  #Scenario: Check if Admin able to retrieve a program with valid BaseURL and invalid Endpoint
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request with valid BaseURI and invalid endpoint
    #Then Admin receives 404 Not Found program Status with message and boolean success details 
    #
    #@03GetRequest_ValidProgramID_InvalidMethod
  #Scenario: Check if Admin able to retrieve all programs with valid programID along with invalid Method
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request and request Body with endpoint along with invalidmethod and valid ProgramID
    #Then Admin receives 405 Method Not Allowed. 
    #
    #@04GetAllPrograms_WithAdmins
  #Scenario: Check if Admin able to retrieve all programs with admin details along with valid Endpoint
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request with endpoint
    #Then Admin receives 200 OK program Status with response body. 
    #
    #@04GetAllPrograms_WithAdmins_InvalidBaseURI
  #Scenario: Check if Admin able to retrieve all programs with admins along with invalid baseURI and valid Endpoint
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request with invalid baseURI and valid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details
    #
     #@04GetAllPrograms_WithAdmins_InvalidEndPoint
  #Scenario: Check if Admin able to retrieve all programs with admins along with valid BaseURL and invalid Endpoint
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request with valid BaseURI and invalid endpoint
    #Then Admin receives 404 not found  Status with error messages
    #
    #
    #@04GetAllPrograms_WithAdmins_InvalidMethod
  #Scenario: Check if Admin able to retrieve all programs with admin along with invalid Method
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request and request Body with endpoint along with invalidmethod 
    #Then Admin receives 405 Method Not Allowed.                                                          
#
  #@05PutRequest_updateProgrambyID_ValidID
  #Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid endpoint
    #Then Admin receives 200 OK Status with updated value in response body.                                           
#
  #@05PutRequest_updateProgrambyID_InValidID
  #Scenario: Check if Admin able to update a program with valid programID endpoint  and valid request body
    #Given Admin creates PUT program Request for the LMS API endpoint with valid request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with invalid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details     
    #
 #@05PutRequest_updateProgrambyID_InvalidBaseURI
  #Scenario: Check if Admin able to update a program with invalid baseURI
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details   
   #
   #@05PutRequest_updateProgrambyID_InvalidEndPoint
  #Scenario: Check if Admin able to update a program with valid baseURI and invalid endpoint
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid baseURI and invalid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details   
                                            #
  #@05PutRequest_updateProgrambyID_InvalidMethod
  #Scenario: Check if Admin able to update programs with invalid Method and valid programID
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request and request Body with endpoint along with invalid method 
    #Then Admin receives 405 Method Not Allowed.    
    #
  #@06PutRequest_updateProgramby_ProgramName
  #Scenario: Check if Admin able to update a program with  Valid program Name and request body
    #Given Admin creates PUT program Request for the LMS API endpoint with valid request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid endpoint
    #Then Admin receives 200 OK Status with updated value in response body. 
                                                                                         #
#@06PutRequest_updateProgramby_InvalidProgramName
  #Scenario: Check if Admin able to update a program with  invalid program Name and request body
    #Given Admin creates PUT program Request for the LMS API endpoint with valid request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with invalid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details.  
    #
 #@06PutRequest_updateProgrambyProgramName_InvalidBaseURI
  #Scenario: Check if Admin able to update a program with invalid baseURI
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details   
   #
   #@06PutRequest_updateProgrambyProgramName_InvalidEndPoint
  #Scenario: Check if Admin able to update a program with valid baseURI and invalid endpoint
    #Given Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields. 
    #When Admin sends HTTPS program Request with valid baseURI and invalid endpoint
    #Then Admin receives 404 Not Found Status with message and boolean success details  
    #
    #@05PutRequest_updateProgrambyProgramName_InvalidMethod
  #Scenario: Check if Admin able to update programs with invalid Method and valid programName
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request and request Body with endpoint along with invalid method and valid Program Name
    #Then Admin receives 405 Method Not Allowed.  
   #
  #@07DeleteRequest_ProgramName
  #Scenario: Check if Admin able to delete a program with valid programName
    #Given Admin creates DELETE program Request for the LMS API endpoint  and  valid programName
    #When Admin sends HTTPS program Request with endpoint
    #Then Admin receives 200 Ok status with message
    #
    #@07DeleteRequest_ProgramName_InvalidBaseURI
  #Scenario: Check if Admin able to delete a program with invalid BaseURI and valid endpoint and valid programName
    #Given Admin creates DELETE program Request for the LMS API endpoint and invalid BaseURI, valid endpoint and valid programName
    #When Admin sends HTTPS program Request with endpoint
    #Then Admin receives 400 Bad Request Status with message and boolean success details
    #
     #@07DeleteRequest_ProgramName_InvalidEndpoint
  #Scenario: Check if Admin able to delete a program with valid BaseURI, Invalid endpoint and valid programName
    #Given Admin creates DELETE program Request for the LMS API endpoint and valid BaseURI, Invalid endpoint and valid programName
    #When Admin sends HTTPS program Request with endpoint
    #Then Admin receives 400 Bad Request Status with message and boolean success details
    #
    #@07DeleteRequest_ProgramName_InvalidMethod
  #Scenario: Check if Admin able to delete programs with invalid Method and valid programName
    #Given Admin creates GET program Request for the LMS API
    #When Admin sends HTTPS program Request and request Body with endpoint along with invalid method and valid Program Name
    #Then Admin receives 405 Method Not Allowed.  
    #
  #@08DeleteRequest_ProgramID
  #Scenario: Check if Admin able to delete a program with valid program ID
    #Given Admin creates DELETE program Request for the LMS API endpoint  and  valid program ID
    #When Admin sends HTTPS program Request with endpoint
    #Then Admin receives 200 Ok status with message
#
 #@08DeleteRequest_ProgramID_InvalidBaseURI
  #Scenario: Check if Admin able to delete a program with invalid BaseURI and valid endpoint and valid programID
    #Given Admin creates DELETE program Request for the LMS API endpoint and invalid BaseURI, valid endpoint and valid programID
    #When Admin sends HTTPS program Request with endpoint
    #Then Admin receives 400 Bad Request Status with message and boolean success details
    #
     #@08DeleteRequest_ProgramID_InvalidEndpoint
  #Scenario: Check if Admin able to delete a program with valid BaseURI, Invalid endpoint and valid programID
    #Given Admin creates DELETE program Request for the LMS API endpoint and valid BaseURI, Invalid endpoint and valid programID
    #When Admin sends HTTPS program Request with endpoint
    #Then Admin receives 400 Bad Request Status with message and boolean success details
    #
     #@07DeleteRequest_ProgramID_InvalidMethod
  #Scenario: Check if Admin able to delete programs with invalid Method and valid programID
    #Given Admin creates Delete program Request for the LMS API
    #When Admin sends HTTPS program Request and request Body with endpoint along with invalid method and valid Program ID
    #Then Admin receives 405 Method Not Allowed. 
  
    
    

  