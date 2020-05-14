package com.sboot.security;

import com.sboot.SpringApplicationContext;

public class ApplicationSecurityConstant {
	
	public static final String HEADER_PREFIX="Authentication";
	public static final String TOKEN_PREFIX="Bearer";
	
	
	public static String getApplicationSecurityToken() {
		AddApplication addApplication=(AddApplication) SpringApplicationContext.getApplicationContext().getBean("addApplication");
		return addApplication.getApplicationToken();
		
	}

}
