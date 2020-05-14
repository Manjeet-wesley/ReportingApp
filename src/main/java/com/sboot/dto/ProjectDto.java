package com.sboot.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sboot.entity.Employee;


public class ProjectDto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Integer projectId;
	private String projectName;
	private List<EmployeeDto> employee;
	
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<EmployeeDto> getEmployees() {
		return employee;
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", employees=" + employee + "]";
	}
	
	

}
