package com.dushime.model;
import java.util.*;

import com.dushime.utility.Uuid;

public class Student {
	private UUID studentId;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String student_code;
	private UUID programId;
	
	public String getStudent_code() {
		return student_code;
	}

	public void setStudent_code(String student_code) {
		this.student_code = student_code;
	}

	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName, Date dateOfBirth,  UUID programID) {
		super();
		this.studentId = Uuid.getNew();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.programId = programID;
	}

	public UUID getProgramId() {
		return programId;
	}

	public void setProgramId(UUID programId) {
		this.programId = programId;
	}

	public UUID getStudentId() {
		return studentId;
	}
	public void setStudentId(UUID studentId) {
		this.studentId = studentId;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
