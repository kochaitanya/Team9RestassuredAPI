@ProgramBatchController
 Feature: ProgramBatchController Module

@01PostRequest_ProgramBatchController
 Scenario: Check if admin able to create a Batch with valid endpoint and request body (non existing values)
   Given Admin creates POST Request  with valid data in request body 
   When Admin sends HTTPS Request with endpoint 
   Then Admin receives 201 Created Status with response body
    
#@01PostRequest_ProgramBatchController_InvalidEndpoint   
  #Scenario: Check if admin able to create a batch with invalid endpoint
    #Given Admin creates POST Request
    #When Admin sends HTTPS Request with invalid endpoint 
    #Then Admin receives 404 not found  Status  
#
#@02GetRequest(All_Batches)_ProgramBatchController
 #Scenario: Check if admin able to retrieve all batches with valid Endpoint
   #Given Admin creates GET Request
   #When Admin sends HTTPS GET Request with endpoint 
   #Then Admin receives 200 OK Status with response body
   #
#@02GetRequest(All_Batches)_ProgramBatchController_InvalidEndpoint
 #Scenario: Check if admin able to retrieve all batches with invalid Endpoint
   #Given Admin creates GET Request
   #When Admin sends HTTPS GET Request with invalid endpoint 
   #Then Admin receives 404 status with error message Not Found
   #
#@02GetRequest(All_Batches)_ProgramBatchController_with_search_string
#	Scenario: Check if admin able to retrieve all batches with search string
#		Given Admin creates GET Request with search string
#		When Admin sends HTTPS GET Request with endpoint
#		Then Admin receives 200 Ok status with response body	for allbatches
#	
#@3GETREQUEST{byBatchID}
#	Scenario: Check if admin able to retrieve a batch with valid BATCH ID
#		Given Admin creates GET Request with valid Batch ID
#		When  Admin sends HTTPS GET Request by batch id with endpoint
#		Then  Admin receives 200 OK Status with response body for batchid
#
#@3GETREQUEST{byBatchID}
#	Scenario: Check if admin able to retrieve a batch with invalid endpoint
#		Given Admin creates GET Request with valid Batch ID
#		When  Admin sends HTTPS GET Request by batch id with invalid endpoint 
#		Then  Admin receives 404 not found  Status by batch id
#
#@4GETREQUEST{byBatchName}
#	Scenario: Check if admin able to retrieve a batch with valid BATCH NAME
#		Given Admin creates GET Request with valid Batch Name
#		When Admin sends HTTPS Request with endpoint
#		Then Admin receives 200 OK Status with response body for batchname
#
#@4GETREQUEST{byinvalidBatchName}
#	Scenario: Check if admin able to retrieve a batch with invalid endpoint
#		Given Admin creates GET Request with valid Batch Name
#		When Admin sends HTTPS Request with invalid endpoint
#		Then Admin receives 404 Not found
#
#@5GETREQUEST{byprogramid}
#	Scenario: Check if admin able to retrieve a batch with valid Program ID
#		Given Admin creates GET Request with valid Program Id
#		When Admin sends HTTPS GET Request by program id with endpoint
#		Then Admin receives 200 OK Status with response body by programid
#
#
#@5GETREQUEST{byprogramid}
#	Scenario: Check if admin able to retrieve a batch with invalid Program Id
#		Given Admin creates GET Request with invalid endpoint
#		When Admin sends HTTPS GET Request  by program id with  invalid endpoint 
#		Then Admin receives 404  Status with  error message Not Found.
#		
#@PUTREQUEST{UpdateBatch_bybatchID}
#	Scenario: Check if admin able to update a Batch with valid batchID and mandatory fields in request body
#		Given Admin creates PUT Request with valid BatchId and Data
#		When Admin sends HTTPS put Request  with endpoint
#		Then Admin receives 200 OK Status with updated value in response body.
#
#@PUTREQUEST{UpdateBatch_bybatchID}
#	Scenario: Check if admin able to update a Batch with invalid enpoint
#		Given Admin creates PUT Request with Valid batch Id
#		When Admin sends HTTPS put Request  with invalid endpoint
#		Then Admin receives 404 not found
#		
#@DELETEREQUEST(by_BatchID)
#	Scenario: Check if admin able to delete a Batch with valid Batch ID
#		Given Admin creates DELETE Request with valid BatchId
#		When Admin sends HTTPS delete Request  with endpoint
#		Then Admin receives "<status>" status with message
#
#@DELETEREQUEST(by_BatchID)
#	Scenario: Check if admin able to delete a Batch with invalid Batch ID
#		Given Admin creates DELETE Request with valid BatchId
#		When Admin sends HTTPS delete Request  with invalid endpoint
#		Then Admin receives 404 not found
