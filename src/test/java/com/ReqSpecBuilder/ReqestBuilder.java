package com.ReqSpecBuilder;

import com.LMSAPI.Endpoints.LMSAPI_EndPoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ReqestBuilder {


	private static RequestSpecBuilder requestSpec = new RequestSpecBuilder()
			.setBaseUri(LMSAPI_EndPoints.BASE_URL)
			.setContentType(ContentType.JSON);
	private static RequestSpecBuilder requestSpec_invalid = new RequestSpecBuilder()
			.setBaseUri(LMSAPI_EndPoints.Invalid_BASE_URL)
			.setContentType(ContentType.JSON);
	//ProgramController-Post
	public static RequestSpecification PostCreateProgram() {

		return requestSpec.setBasePath(LMSAPI_EndPoints.Create_New_Program).build();

	}
	public static RequestSpecification PostCreateProgram_InvalidEndpoint() {

		return requestSpec.setBasePath(LMSAPI_EndPoints.Invalid_Create_New_Program).build();

	}
	public static RequestSpecification PostCreateProgram_InvalidBaseUrl() {

		return requestSpec_invalid.setBasePath(LMSAPI_EndPoints.Create_New_Program).build();

	}
	
	//ProgramBatchController-Post
	public static RequestSpecification PostCreateProgramBatch() {

		return requestSpec.setBasePath(LMSAPI_EndPoints.Create_New_Programbatch).build();

	}
	
	
	//GetAllRoles
	public static RequestSpecification GetAllRoles() {
		return requestSpec.setBasePath(LMSAPI_EndPoints.Get_All_Roles).build();
	}

public static RequestSpecification PostUserSignIn() {
	 return requestSpec.setBasePath(LMSAPI_EndPoints.User_Sign_In).build();
   
}
}