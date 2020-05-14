package com.sboot.custom.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice extends ResponseEntityExceptionHandler {

	private String BAD_REQUEST = "EMPLOYEE NOT FOUND EXCEPTION";

	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ErrorResponse> employeeNotfoud(EmployeeNotFoundException empEx, WebRequest request) {
		List<String> errorList = new ArrayList<>();
		errorList.add(empEx.getLocalizedMessage());
		System.out.println("============>EmployeeNotFoundException=================");
		ErrorResponse eResponse = new ErrorResponse(BAD_REQUEST, errorList);
		return new ResponseEntity<ErrorResponse>(eResponse, HttpStatus.BAD_REQUEST);
	}

	/*
	 * @ExceptionHandler(ConstraintViolationException.class) public final
	 * ResponseEntity<ErrorResponse> constrantVialation(ConstraintViolationException
	 * consEx, WebRequest request) { List<String> errorList =
	 * consEx.getConstraintViolations().parallelStream().map(e -> e.getMessage())
	 * .collect(Collectors.toList());
	 * System.out.println(consEx.getConstraintViolations()+
	 * "========consEx.getConstraintViolations()"); ErrorResponse eResponse = new
	 * ErrorResponse("EMPLOYEE NOT FOUND EXCEPTION", errorList); return new
	 * ResponseEntity<ErrorResponse>(eResponse, HttpStatus.BAD_REQUEST); }
	 */
}
