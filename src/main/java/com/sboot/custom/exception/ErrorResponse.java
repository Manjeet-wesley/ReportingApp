package com.sboot.custom.exception;

import java.util.List;

public class ErrorResponse {

	String msg;
	List<String> errors;
	
	public ErrorResponse(String msg,List<String> errors) {
		this.msg=msg;
		this.errors=errors;
	}

	public String getMsg() {
		return msg;
	} 

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ErrorResponse [msg=" + msg + ", errors=" + errors + "]";
	}
	
	
}
