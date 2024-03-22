package com.dushime.model;

import java.util.*;

public class Teacher {
	private UUID teacherId;
	private String firstName;
	private String lastName;
	private String qualitfication;
	private UUID courseId;
	
	public Teacher() {
		super();
	}
	public Teacher(UUID teacherId, String firstName, String lastName, String qualitfication, UUID courseId) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.qualitfication = qualitfication;
		this.courseId = courseId;
	}
	public UUID getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(UUID teacherId) {
		this.teacherId = teacherId;
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
	public String getQualitfication() {
		return qualitfication;
	}
	public void setQualitfication(String qualitfication) {
		this.qualitfication = qualitfication;
	}
	public UUID getCourseId() {
		return courseId;
	}
	public void setCourseId(UUID courseId) {
		this.courseId = courseId;
	}
	
}
