package com.dushime.model;

import java.util.*;

public class CourseDefinition {
	private UUID courseDefinitionId;
	private String courseDefinitionCode;
	private String courseDefinitionDescription;
	private UUID courseId;
	public CourseDefinition(UUID courseDefinitionId, String courseDefinitionCode, String courseDefinitionDescription,
			UUID courseId) {
		super();
		this.courseDefinitionId = courseDefinitionId;
		this.courseDefinitionCode = courseDefinitionCode;
		this.courseDefinitionDescription = courseDefinitionDescription;
		this.courseId = courseId;
	}
	public CourseDefinition() {
		super();
	}
	public UUID getCourseDefinitionId() {
		return courseDefinitionId;
	}
	public void setCourseDefinitionId(UUID courseDefinitionId) {
		this.courseDefinitionId = courseDefinitionId;
	}
	public String getCourseDefinitionCode() {
		return courseDefinitionCode;
	}
	public void setCourseDefinitionCode(String courseDefinitionCode) {
		this.courseDefinitionCode = courseDefinitionCode;
	}
	public String getCourseDefinitionDescription() {
		return courseDefinitionDescription;
	}
	public void setCourseDefinitionDescription(String courseDefinitionDescription) {
		this.courseDefinitionDescription = courseDefinitionDescription;
	}
	public UUID getCourseId() {
		return courseId;
	}
	public void setCourseId(UUID courseId) {
		this.courseId = courseId;
	}
	
	
}
