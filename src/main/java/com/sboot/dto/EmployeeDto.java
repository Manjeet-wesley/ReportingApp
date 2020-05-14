package com.sboot.dto;

import java.io.Serializable;
import java.util.List;

public class EmployeeDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String contantNo;
	private String Address;
	List<ProjectDto> project;

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContantNo() {
		return contantNo;
	}

	public void setContantNo(String contantNo) {
		this.contantNo = contantNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public List<ProjectDto> getProject() {
		return project;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", contantNo=" + contantNo + ", Address=" + Address + ", project=" + project + "]";
	}

}
