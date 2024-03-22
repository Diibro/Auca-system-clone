package com.dushime.model;

import java.util.*;

public class AcademicUnit {
	private UUID academicId;
	private String academicCode;
	private String academicName;
	private String type;
	private UUID parentId;
	
	public AcademicUnit() {
		super();
	}
	public AcademicUnit(UUID academicId, String academicCode, String academicName, String type, UUID parentId) {
		super();
		this.academicId = academicId;
		this.academicCode = academicCode;
		this.academicName = academicName;
		this.type = type;
		this.parentId = parentId;
	}
	public UUID getAcademicId() {
		return academicId;
	}
	public void setAcademicId(UUID academicId) {
		this.academicId = academicId;
	}
	public String getAcademicCode() {
		return academicCode;
	}
	public void setAcademicCode(String academicCode) {
		this.academicCode = academicCode;
	}
	public String getAcademicName() {
		return academicName;
	}
	public void setAcademicName(String academicName) {
		this.academicName = academicName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public UUID getParentId() {
		return parentId;
	}
	public void setParentId(UUID parentId) {
		this.parentId = parentId;
	}
	
}
