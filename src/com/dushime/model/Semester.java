package com.dushime.model;

import java.util.*;

public class Semester {
	private UUID semesterId;
	private String semesterName;
	private Date startingDate;
	private Date endDate;
	
	
	public Semester() {
		super();
	}
	public Semester(UUID semesterId, String semesterName, Date startingDate, Date endDate) {
		super();
		this.semesterId = semesterId;
		this.semesterName = semesterName;
		this.startingDate = startingDate;
		this.endDate = endDate;
	}
	public UUID getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(UUID semesterId) {
		this.semesterId = semesterId;
	}
	public String getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	public Date getStartingDate() {
		return startingDate;
	}
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
