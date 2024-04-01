package com.LMSAPI.PayLoad;


import com.LMSAPI.Pojo.UserLoginPojo;
import com.LMSAPI.Utilities.BaseUtils;

public class LoginPayload extends BaseUtils {
	
	public static UserLoginPojo userLogin() {
		
		
		loginPojo.setPassword(endpoints.getString("Password"));
		loginPojo.setUserEmail(endpoints.getString("Username"));
		System.out.println("ProgramPayload is :"+loginPojo);
		return loginPojo;
		
	}
	
	

}
