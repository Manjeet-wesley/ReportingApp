package com.sboot.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "emp_id")
	private Integer employeeId;

	@NotEmpty(message="First name should not be empty")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty(message="Last name should not be empty")
	@Column(name = "last_name")
	private String lastName;

	@Email(message="not valid email address")
	@Column(name = "email")
	private String email;

    @NotBlank(message="Contact number should not be empty")
    @Size(min=10,max=12)
	@Column(name = "contact_no")
	private String contantNo;

     @NotNull(message="Please provide your address")
	@Column(name = "address")
	private String Address;

	
	

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

	
	  @Override public String toString() { return "Employee [employeeId=" +
	  employeeId + ", firstName=" + firstName + ", lastName=" + lastName +
	  ", email=" + email + ", contantNo=" + contantNo + ", Address=" + Address +
	  "]"; }
	 


}
