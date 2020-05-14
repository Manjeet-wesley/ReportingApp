package com.sboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.dto.EmployeeDto;
import com.sboot.entity.Employee;
import com.sboot.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping(value="/all-employees",produces=MediaType.APPLICATION_XML_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDto>> getEmployees(){
		System.out.println("Methos executing");
				return new ResponseEntity<>(service.getAllEmployee(), HttpStatus.OK);
	}
	
	
	@GetMapping("/employee-by-id/{empId}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable int empId){
		  EmployeeDto dto=service.employeeById(empId);
		return new ResponseEntity<EmployeeDto>(dto, HttpStatus.OK);
	}
	
	
	  @PostMapping("/save-employee")
	  public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody  Employee employee) {
	  return new ResponseEntity<>( service.saveEmployee(employee),HttpStatus.CREATED); 
	  }
	 

}
