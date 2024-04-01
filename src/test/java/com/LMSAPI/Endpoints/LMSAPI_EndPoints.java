package com.LMSAPI.Endpoints;

import io.restassured.specification.RequestSpecification;

public class LMSAPI_EndPoints {
	
	public static final String BASE_URL ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms";
	public static final String Invalid_BASE_URL = "https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com";
	
	//UserLogin
	public static final String User_Login ="https://lms-marchapi-hackathon-a258d2bbd43b.herokuapp.com/lms/login";
	
	//ProgramController EndPoints
	
	public static final String Create_New_Program = BASE_URL+"/saveprogram";			
	public static final String Get_All_Programs = BASE_URL+"/allPrograms";
	public static final String Get_All_ProgramsWithUsers = BASE_URL+"/allProgramsWithUsers";			
	public static final String Get_Program_By_ID =BASE_URL+ "/programs/{programId}";
	public static final String Update_Program_By_ProgramName = BASE_URL+"/program/{programName}";
	public static final String Update_Program_By_ProgramID =BASE_URL+ "/putprogram/{programId}";
	public static final String Delete_Program_By_ProgramID = BASE_URL+"/deletebyprogid/{programId}";
	public static final String Delete_Program_By_ProgramName =BASE_URL+ "/deletebyprogname/{programName}";
	
	//Invalid PromramController EndPoints
	
	public static final String Invalid_Create_New_Program = "/saveprograms";
	public static final String InvalidBaseURL_Create_Program = "/saveprogram";
	public static final String InvalidEndPoint_Get_All_Programs = BASE_URL+"/allProgram";
	public static final String InvalidBaseURL_Get_All_Programs = Invalid_BASE_URL+"/allProgram";
	public static final String Invalid_Get_All_ProgramsWithUsers = "/allProgramsWithUser";			
	public static final String Invalid_Get_Program_By_ID = " /program/{programId}";
	public static final String Invalid_Update_Program_By_ProgramName = "/programs/{programName}";
	public static final String Invalid_Update_Program_By_ProgramID = "/putprograms/{programId}";
	public static final String Invalid_Delete_Program_By_ProgramID = "/deletebyprogids/{programId}";
	public static final String Invalid_Delete_Program_By_ProgramName = "/deletebyprognames/{programName}";
	

	//ProgramBatchController EndPoints
	
	public static final String Create_New_Programbatch = "/batches";			
	public static final String Get_All_Programsbatches = "/batches";	
	public static final String Get_Programbatch_By_ID = "/batches/batchId/{batchId}";
	public static final String Get_Programbatch_By_BatchName ="/batches/batchName/{batchName}";
	public static final String Update_Programbatch_By_ProgramName = "/program/{programName}";
	public static final String Update_Programbatch_By_ProgramID = "/putprogram/{programId}";
	public static final String Delete_Programbatch_By_ProgramID = "/deletebyprogid/{programId}";
	public static final String Delete_Programbatch_By_ProgramName = "/deletebyprogname/{programName}";

	public static final String User_Sign_In ="/login";
	public static final String Get_All_Roles ="/roles";
	

}

