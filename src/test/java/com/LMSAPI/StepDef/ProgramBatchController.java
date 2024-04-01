package com.LMSAPI.StepDef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.LMSAPI.Authentication.BearerAuth;
import com.LMSAPI.PayLoad.ProgramBatchPayload;
import com.LMSAPI.PayLoad.ProgramControllerPayload;
import com.LMSAPI.Runner.LMSAPIRunner;
import com.LMSAPI.Utilities.PathReader;
import com.ReqSpecBuilder.ReqestBuilder;
import com.jayway.jsonpath.JsonPath;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProgramBatchController {


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
	
	@Given("Admin creates POST Request  with valid data in request body")
	public void admin_creates_post_request_with_valid_data_in_request_body() {
		
		requestSpecification= RestAssured.given().header("Authorization",BearerAuth.BearerAuthAPITest());
	}

	@When("Admin sends HTTPS Request with endpoint")
	public void admin_sends_https_request_with_endpoint() throws InvalidFormatException, IOException{
		ProgramBatchPayload.PostCreateProgramBatchRequest().stream().forEach(item->{
            this.response = requestSpecification
					 .when().log().all()
					 .spec(ReqestBuilder.PostCreateProgramBatch()).body(item)
				.post();
            responses.add(response);
            System.out.println("response:"+response.asPrettyString());
      	});
      	System.out.println("The size of my response list is:"+responses.size());
//      	
	}

	@Then("Admin receives {int} Created Status with response body")
	public void admin_receives_created_status_with_response_body(Integer int1) {
		
		responses.stream().forEach(item->{
			if(item.getStatusCode()==201) {
				System.out.println("Program Batch Created");
				valid_response = response.then().log().all()
						.assertThat().statusCode(201).extract().response().asString();
				
			}
			
			else if (item.getStatusCode()==400) {
				valid_response = response.then().log().all().assertThat().statusCode(400).extract().response().asString();
				System.out.println("Negative Scenario");
			}
		});
	}
}


