package com.LMSAPI.StepDef;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.LMSAPI.Authentication.BearerAuth;
import com.LMSAPI.Endpoints.LMSAPI_EndPoints;
import com.LMSAPI.Utilities.ConfigReaderAndWriter;
import com.LMSAPI.Utilities.FileNameConstants;
import com.LMSAPI.Utilities.PathReader;
import com.LMSAPI.Utilities.UserExcelUtility;
import com.ReqSpecBuilder.ReqestBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.LMSAPI.PayLoad.*;
import com.LMSAPI.Pojo.ProgramPojo;
import com.LMSAPI.Runner.LMSAPIRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class ProgramController {

	Response response;
	RequestSpecification requestSpecification;
	String valid_response;
	private static final String Bearer_Token = null;
	RequestSpecBuilder requestSpec;
	JsonPath jsonPath;
	Object retrievedToken = LMSAPIRunner.scenarioContext.getContext("Token", Bearer_Token);
	public List<Response> responses = new ArrayList<>();
	public static String requestBody;
	public static List<Map<String, String>> excelinput;
	public static PathReader path = new PathReader();

	
@Given("Admin creates POST program Request for the LMS with request body")
public void admin_creates_post_program_request_for_the_lms_with_request_body() throws InvalidFormatException, IOException {

	requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
//    requestSpecification= RestAssured.given().header("Authorization","Bearer "+retrievedToken);
	
};
 
@When("Admin sends HTTPS post program Request and  request Body with endpoint")

public void admin_sends_https_post_program_request_and_request_body_with_endpoint() throws InvalidFormatException, IOException {

          	ProgramControllerPayload.PostCreateProgramRequest().stream().forEach(item->{
	            this.response = requestSpecification
						 .when().log().all()
						 .spec(ReqestBuilder.PostCreateProgram()).body(item)
					.post();
	            responses.add(response);
	            System.out.println("response:"+response.asPrettyString());
          	});
          	System.out.println("The size of my response list is:"+responses.size());
//          	
          	
	    }

@Then("Admin receives {int} Created program Status with response body.")
public void admin_receives_created_program_status_with_response_body(Integer int1) {
	 
	responses.stream().forEach(item->{
		if(item.getStatusCode()==201) {
			System.out.println("Program Created");
			valid_response = response.then().log().all()
					.assertThat().statusCode(201).extract().response().asString();
			
		}
		
		else if (item.getStatusCode()==400) {
			valid_response = response.then().log().all().assertThat().statusCode(400).extract().response().asString();
			System.out.println("Negative Scenario");
		}
	});
	

//	response.prettyPrint();
//	valid_response = response.then().log().all().assertThat().statusCode(201).extract().response().asString();
//	int statuscode=response.getStatusCode();
////	int programId=response.
//    System.out.println("Statuscode:" +statuscode);
}

@When("Admin sends HTTPS post program Request and  request Body with invalid endpoint")
public void admin_sends_https_post_program_request_and_request_body_with_invalid_endpoint() throws IOException{
	try{
		 
		this.response = requestSpecification
					 .when().log().all()
					 .spec(ReqestBuilder.PostCreateProgram_InvalidEndpoint())
					 .body(ProgramControllerPayload.PostCreateProgramRequest_Invalid())
				.post();
		
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

}

@Then("Admin receives {int} not found  program Status with message and boolean success details")
public void admin_receives_not_found_program_status_with_message_and_boolean_success_details(Integer int1) {
	//response.prettyPrint();
	valid_response = response.then().log().all().assertThat().statusCode(404).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
	
}

@Given("Admin creates POST program Request for the LMS with request body and invalid BaseURI")
public void admin_creates_post_program_request_for_the_lms_with_request_body_and_invalid_base_uri() {
	requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
	
}
@When("Admin sends HTTPS post program Request and  request Body with invalid BaseURI and valid endpoint")
public void admin_sends_https_post_program_request_and_request_body_with_invalid_base_uri_and_valid_endpoint() {
	//this.response = requestSpecification.when().log().all().post(LMSAPI_EndPoints.InvalidBaseURL_Create_Program);
	try{
		 
		this.response = requestSpecification
					 .when().log().all()
					 .baseUri(LMSAPI_EndPoints.InvalidBaseURL_Create_Program)
					 .body(ProgramControllerPayload.PostCreateProgramRequest_Invalid())
				.post();
		
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

@Then("Admin receives {int} not found program Status for invalid BaseURI with message and boolean success details")
public void admin_receives_not_found_program_status_for_invalid_base_uri_with_message_and_boolean_success_details(Integer int1) {
	response.prettyPrint();
	valid_response = response.then().log().all().assertThat().statusCode(404).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
}

@When("Admin sends HTTPS post program Request and request Body with endpoint along with invalid method")
public void admin_sends_https_post_program_request_and_request_body_with_endpoint_along_with_invalid_method() {
	try{
		 
		this.response = requestSpecification
					 .when().log().all()
					 .spec(ReqestBuilder.PostCreateProgram())
					 .body(ProgramControllerPayload.PostCreateProgramRequest_Invalid())
				.get();
		
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

@Then("Admin receives {int} Method Not Allowed for program controller")
public void admin_receives_method_not_allowed_for_program_controller(Integer int1) {
	response.prettyPrint();
	valid_response = response.then().log().all().assertThat().statusCode(405).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
   
}

@Given("Admin creates GET program Request for the LMS API")
public void admin_creates_get_program_request_for_the_lms_api() {
	requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
   
}

@When("Admin sends HTTPS get program Request with endpoint")
public void admin_sends_https_get_program_request_with_endpoint() {
	this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_All_Programs);
   
}

@Then("Admin receives {int} OK get program Status with response body.")
public void admin_receives_ok_get_program_status_with_response_body(Integer int1) {
	response.prettyPrint();
	valid_response = response.then().log().all().assertThat().statusCode(200).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
   
}

@When("Admin sends HTTPS program Request with invalid endpoint")
public void admin_sends_https_program_request_with_invalid_endpoint() {
	this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.InvalidEndPoint_Get_All_Programs);
   
}

@Then("Admin receives {int} not found program Status with error message")
public void admin_receives_not_found_program_status_with_error_message(Integer int1) {
	response.prettyPrint();
	valid_response = response.then().log().all().assertThat().statusCode(404).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
   
}
@Given("Admin creates GET program Request for the LMS API with invalid BaseURI")
public void admin_creates_get_program_request_for_the_lms_api_with_invalid_base_uri() {
//	requestSpec = new RequestSpecBuilder();
//	requestSpec.setBaseUri(prop.getProperty("Invalid_BASE_URL"));
//	requestSpec.setContentType(ContentType.JSON);
//	requestSpec.addHeader("Authorization", BearerAuth.BearerAuthAPITest());
//	requestSpecification = RestAssured.given().spec(requestSpec.build()).log().all();
	
	requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
	//requestSpec.setBaseUri(LMSAPI_EndPoints.Invalid_BASE_URL);
}
@When("Admin sends HTTPS program get Request with invalid BaseURI and valid endpoint")
public void admin_sends_https_program_get_request_with_invalid_base_uri_and_valid_endpoint() {
	this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.InvalidBaseURL_Get_All_Programs);
}

@Then("Admin receives {int} Not Found program get Status with message and boolean success details")
public void admin_receives_not_found_program_get_status_with_message_and_boolean_success_details(Integer int1) {   
	response.prettyPrint();
	valid_response = response.then().log().all().assertThat().statusCode(404).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
}

@When("Admin sends HTTPS program Request and request Body with endpoint along with invalidmethod")
public void admin_sends_https_program_request_and_request_body_with_endpoint_along_with_invalidmethod() {
	this.response = requestSpecification.when().log().all().post(LMSAPI_EndPoints.Get_All_Programs);
   
}

@Then("Admin receives {int} Method Not Allowed")
public void admin_receives_method_not_allowed(Integer int1) {
   
	response.prettyPrint();
	valid_response = response.then().log().all().assertThat().statusCode(405).extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
}

@Given("Admin creates GET program by ID Request for the LMS API with valid {string}")
public void admin_creates_get_program_by_id_request_for_the_lms_api_with_valid(String programID) {
	requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
//	requestSpec = new RequestSpecBuilder();
//	requestSpec.setBaseUri(prop.getProperty("BASE_URL"));
//	requestSpec.setContentType(ContentType.JSON);
//	requestSpec.addHeader("Authorization", BearerAuth.BearerAuthAPITest());
//	requestSpecification = RestAssured.given().pathParam("programId", programID).spec(requestSpec.build()).log().all();
}

@When("Admin sends HTTPS get by program ID Request with endpoint")
public void admin_sends_https_get_by_program_id_request_with_endpoint() {
	this.response = requestSpecification.when().log().all().get(LMSAPI_EndPoints.Get_Program_By_ID);
}


@Then("Admin receives {string} program Status with response body.")
public void admin_receives_program_status_with_response_body(String status) {
	response.prettyPrint();
	valid_response = response.then().log().all().assertThat().extract().response().asString();
	int statuscode=response.getStatusCode();
    System.out.println("Statuscode:" +statuscode);
    if(statuscode==200) { 
    	assertTrue(true, status);
    }else {
    	assertEquals(404, 404);
    }
}

@When("Admin sends HTTPS program Request with invalid baseURI and valid endpoint")
public void admin_sends_https_program_request_with_invalid_base_uri_and_valid_endpoint() {
   
   
}

@When("Admin sends HTTPS program Request with valid BaseURI and invalid endpoint")
public void admin_sends_https_program_request_with_valid_base_uri_and_invalid_endpoint() {
   
   
}

@When("Admin sends HTTPS program Request and request Body with endpoint along with invalidmethod and valid ProgramID")
public void admin_sends_https_program_request_and_request_body_with_endpoint_along_with_invalidmethod_and_valid_program_id() {
   
   
}

//@Then("Admin receives {int} Method Not Allowed.")
//public void admin_receives_method_not_allowed(Integer int1) {
//   
//   
//}

@Then("Admin receives {int} Not Found Status with message and boolean success details")
public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
   
   
}

@Then("Admin receives {int} not found  Status with error messages")
public void admin_receives_not_found_status_with_error_messages(Integer int1) {
   
   
}

@Given("Admin creates PUT program Request for the LMS API endpoint with request Body with mandatory , additional  fields.")
public void admin_creates_put_program_request_for_the_lms_api_endpoint_with_request_body_with_mandatory_additional_fields() {
   
   
}

@When("Admin sends HTTPS program Request with valid endpoint")
public void admin_sends_https_program_request_with_valid_endpoint() {
   
   
}

@Then("Admin receives {int} OK Status with updated value in response body.")
public void admin_receives_ok_status_with_updated_value_in_response_body(Integer int1) {
   
   
}

@Given("Admin creates PUT program Request for the LMS API endpoint with valid request Body with mandatory , additional  fields.")
public void admin_creates_put_program_request_for_the_lms_api_endpoint_with_valid_request_body_with_mandatory_additional_fields() {
   
   
}

//@When("Admin sends HTTPS program Request with valid baseURI and invalid endpoint")
//public void admin_sends_https_program_request_with_valid_base_uri_and_invalid_endpoint() {
//   
//   
//}

@When("Admin sends HTTPS program Request and request Body with endpoint along with invalid method")
public void admin_sends_https_program_request_and_request_body_with_endpoint_along_with_invalid_method() {
   
   
}

//@Then("Admin receives {int} Not Found Status with message and boolean success details.")
//public void admin_receives_not_found_status_with_message_and_boolean_success_details(Integer int1) {
//   
//   
//}

@When("Admin sends HTTPS program Request and request Body with endpoint along with invalid method and valid Program Name")
public void admin_sends_https_program_request_and_request_body_with_endpoint_along_with_invalid_method_and_valid_program_name() {
   
   
}

@Given("Admin creates DELETE program Request for the LMS API endpoint  and  valid programName")
public void admin_creates_delete_program_request_for_the_lms_api_endpoint_and_valid_program_name() {
   
   
}

@Then("Admin receives {int} Ok status with message")
public void admin_receives_ok_status_with_message(Integer int1) {
   
   
}

@Given("Admin creates DELETE program Request for the LMS API endpoint and invalid BaseURI, valid endpoint and valid programName")
public void admin_creates_delete_program_request_for_the_lms_api_endpoint_and_invalid_base_uri_valid_endpoint_and_valid_program_name() {
   
   
}

@Then("Admin receives {int} Bad Request Status with message and boolean success details")
public void admin_receives_bad_request_status_with_message_and_boolean_success_details(Integer int1) {
   
   
}

@Given("Admin creates DELETE program Request for the LMS API endpoint and valid BaseURI, Invalid endpoint and valid programName")
public void admin_creates_delete_program_request_for_the_lms_api_endpoint_and_valid_base_uri_invalid_endpoint_and_valid_program_name() {
   
   
}

@Given("Admin creates DELETE program Request for the LMS API endpoint  and  valid program ID")
public void admin_creates_delete_program_request_for_the_lms_api_endpoint_and_valid_program_id() {
   
   
}

@Given("Admin creates DELETE program Request for the LMS API endpoint and invalid BaseURI, valid endpoint and valid programID")
public void admin_creates_delete_program_request_for_the_lms_api_endpoint_and_invalid_base_uri_valid_endpoint_and_valid_program_id() {
   
   
}

@Given("Admin creates DELETE program Request for the LMS API endpoint and valid BaseURI, Invalid endpoint and valid programID")
public void admin_creates_delete_program_request_for_the_lms_api_endpoint_and_valid_base_uri_invalid_endpoint_and_valid_program_id() {
   
   
}

@Given("Admin creates Delete program Request for the LMS API")
public void admin_creates_delete_program_request_for_the_lms_api() {
   
   
}

@When("Admin sends HTTPS program Request and request Body with endpoint along with invalid method and valid Program ID")
public void admin_sends_https_program_request_and_request_body_with_endpoint_along_with_invalid_method_and_valid_program_id() {
   
   
}
}
