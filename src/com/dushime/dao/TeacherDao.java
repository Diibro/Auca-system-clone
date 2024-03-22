package com.dushime.dao;

import java.sql.*;
import java.util.*;

import com.dushime.model.DBConfig;
import com.dushime.model.Teacher;
import com.dushime.utility.Uuid;

public class TeacherDao {
	private Teacher teacher;
	private String query;
	private Statement st;
	private Connection con;
	private PreparedStatement pSt;
	
	public TeacherDao() {
		con = new DBConfig().getCon();
	}
	private boolean has(UUID id) {
		try {
			pSt = con.prepareStatement("select * from teacher where teacher_id = ? ;");
			pSt.setObject(1,id);
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
	public boolean create(Teacher t) {
		try {
			pSt = con.prepareStatement("insert into teacher values (?,?,?,?,?)");
			pSt.setObject(1,Uuid.getNew());
			pSt.setString(2, t.getFirstName());
			pSt.setString(3, t.getLastName());
			pSt.setString(4, t.getQualitfication());
			pSt.setObject(5, t.getCourseId());
			
			int res = pSt.executeUpdate();
			if(res > 0 ) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update (Teacher t) {
		try {
			if(this.has(t.getTeacherId())) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
