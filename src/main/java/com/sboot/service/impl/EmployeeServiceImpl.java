package com.sboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sboot.custom.exception.EmployeeNotFoundException;
import com.sboot.dto.EmployeeDto;
import com.sboot.entity.Employee;
import com.sboot.repository.EmployeeRepository;
import com.sboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public List<EmployeeDto> getAllEmployee() {
		
		return entityToDto(repository.findAll());
	}

	
	@Override
	public EmployeeDto saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		EmployeeDto dto=new EmployeeDto();
		repository.save(employee);
		 BeanUtils.copyProperties(employee,dto);
		 return dto;
	}
	

	@Override
	public EmployeeDto employeeById(int employeeId) {
		EmployeeDto dto=null;
		try {
		Optional<Employee> employee= repository.findById(employeeId);
		Employee emp=employee.get();		
		dto=new EmployeeDto();
		BeanUtils.copyProperties(emp,dto);
		}catch (Exception e) {
			 throw new EmployeeNotFoundException("Employee with id "+employeeId+" is not found");
		}
		 return dto;	
		
	}
	

	
	
	private List<EmployeeDto> entityToDto(List<Employee> entity){
		List<EmployeeDto> dtos=new ArrayList();
		for(Employee employee:entity) {
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(employee, dto);
			dtos.add(dto);
			
		}
		return dtos;
	}
}
