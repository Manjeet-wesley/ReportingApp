package com.sboot.service;

import java.util.List;

import com.sboot.dto.EmployeeDto;
import com.sboot.entity.Employee;

public interface EmployeeService {

	public List<EmployeeDto> getAllEmployee();
	public EmployeeDto saveEmployee(Employee employee);
	public EmployeeDto employeeById(int employeeId);
}
