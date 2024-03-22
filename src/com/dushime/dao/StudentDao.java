package com.dushime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dushime.model.DBConfig;
import com.dushime.model.Student;
import com.dushime.utility.Mailer;
import com.dushime.utility.Return;
import com.dushime.utility.Uuid;

public class StudentDao {
	private Student stu;
	private Connection con;
	private PreparedStatement pSt;
	
	public StudentDao () {
		this.con = new DBConfig().getCon();
		this.stu = new Student();
	}
	
	private boolean has(Student u) {
		try {
			pSt = con.prepareStatement("select * from student where first_name  = ? and last_name = ? ;");
			pSt.setString(1,u.getFirstName());
			pSt.setString(2, u.getLastName());
			ResultSet res = pSt.executeQuery();
			if(res.next()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private int findAll () {
		int allStud = 0;
		try {
			pSt = con.prepareStatement("select count(*) as total from student;");
			ResultSet res = pSt.executeQuery();
			if(res.next()) {
				allStud = res.getInt("total");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return allStud;
	}
	public Return create(Student u, String email) {
		try {
			if(this.has(u)) {
				return new Return("Student-Already-exists.-Login-instead", false, null);
			}else {
				String studentCode = "STUD-"+(this.findAll()+1);
				String message = "Hello, thank you for applying to our university. These are your student credentials. Student Id: " + studentCode;
				boolean emailSent = new Mailer().sendMessage(email, message, "Admission");
				if(emailSent) {
					pSt = con.prepareStatement("insert into student values (?,?,?,?,?,?)");
					pSt.setObject(1, Uuid.getNew());
					pSt.setString(2, u.getFirstName());
					pSt.setString(3, u.getLastName());
					pSt.setDate(4, new java.sql.Date(u.getDateOfBirth().getTime()));
					pSt.setString(5, studentCode);
					pSt.setObject(6, u.getProgramId());
					int res = pSt.executeUpdate();
					if(res > 0) {
						return new Return("Student-Registration-was-successful.-Check-email-for-student-credentials", true, null);
					}else {
						return new Return("Student-registration-failed.-Please-try-again-later.", false, null);
					}
				}else {
					return new Return("Used-invalid-email-during-signup.Try-again-with-a-valid-email.", false, null);
				}
				
			}
		}catch (Exception e){
			e.printStackTrace();
			return new Return("Server-error.-Contact-admin-please", false, e);
		}
	}
}
