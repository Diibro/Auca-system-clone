package com.dushime.model;

import java.util.*;

public class Course {
	private UUID courseId;
	private String courseCode;
	private String courseName;
	private UUID semesterId;
	private UUID departmentId;
	public Course() {
		super();
	}
	public Course(UUID courseId, String courseCode, String courseName, UUID semesterId, UUID departmentId) {
		super();
		this.courseId = courseId;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.semesterId = semesterId;
		this.departmentId = departmentId;
	}
	public UUID getCourseId() {
		return courseId;
	}
	public void setCourseId(UUID courseId) {
		this.courseId = courseId;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
