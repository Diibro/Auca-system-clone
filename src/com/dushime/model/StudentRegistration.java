package com.dushime.model;

import java.util.*;

public class StudentRegistration {
	private UUID registrationId;
	private String registrationCode;
	private Date registrationDate;
	private UUID studentId;
	private UUID semesterId;
	private UUID departmentId;
	
	
	
	public StudentRegistration() {
		super();
	}
	public StudentRegistration(UUID registrationId, String registrationCode, Date registrationDate, UUID studentId,
			UUID semesterId, UUID departmentId) {
		super();
		this.registrationId = registrationId;
		this.registrationCode = registrationCode;
		this.registrationDate = registrationDate;
		this.studentId = studentId;
		this.semesterId = semesterId;
		this.departmentId = departmentId;
	}
	public UUID getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(UUID registrationId) {
		this.registrationId = registrationId;
	}
	public String getRegistrationCode() {
		return registrationCode;
	}
	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public UUID getStudentId() {
		return studentId;
	}
	public void setStudentId(UUID studentId) {
		this.studentId = studentId;
	}
	public UUID getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(UUID semesterId) {
		this.semesterId = semesterId;
	}
	public UUID getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(UUID departmentId) {
		this.departmentId = departmentId;
	}
	
	
}
