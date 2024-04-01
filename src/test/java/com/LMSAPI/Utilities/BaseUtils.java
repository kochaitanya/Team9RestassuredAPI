package com.LMSAPI.Utilities;

import java.util.ResourceBundle;
import com.LMSAPI.Pojo.UserLoginPojo;

import com.LMSAPI.Pojo.ProgramPojo;
import io.restassured.response.Response;

public class BaseUtils {
	
	public static ResourceBundle endpoints = ResourceBundle.getBundle("UserAPICofig");
	
	public static UserLoginPojo loginPojo = new UserLoginPojo();
	public static ProgramPojo ProgramPojo = new ProgramPojo();
	
	public static Response response;


}
