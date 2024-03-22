package com.dushime.dao;

import java.sql.*;
import java.util.UUID;

import com.dushime.model.DBConfig;
import com.dushime.model.Semester;
import com.dushime.utility.Return;
import com.dushime.utility.Uuid;


public class SemesterDao {
	private Statement st;
	private Connection con;
	private PreparedStatement pSt;
	
	public SemesterDao() {
		this.con = new DBConfig().getCon();
	}
	
	private boolean has(String name) {
		try {
			pSt = con.prepareStatement("select * semester where semester_name = ?");
			pSt.setString(1, name);
			ResultSet res = pSt.executeQuery();
			if(res.next()) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Return create(Semester s) {
		try {
			if(this.has(s.getSemesterName())) {
				return new Return("Semester-already-registered.", false, null);
			}
			pSt = con.prepareStatement("insert into semester values (?,?,?,?)");
			pSt.setObject(1, Uuid.getNew());
			pSt.setString(2, s.getSemesterName());
			pSt.setObject(3, s.getStartingDate());
			pSt.setObject(4, s.getEndDate());
			int res = pSt.executeUpdate();
			if(res > 0) {
				return new Return("Semester-added-successfully", true, null);
			}else {
				return new Return("Failed-to-add-the-semester-try-again-later", false, null);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new Return("some-server-error.", false, e);
		}
	}
	
	public Semester search(Date date) {
		try {
			pSt = con.prepareStatement("select * from semester where start_date >= CURRENT_DATE order by start_date asc  limit 1;");
			ResultSet res = pSt.executeQuery();
			if(res.next()) {
				return new Semester(UUID.fromString(res.getString("semester_id")), res.getString("semester_name"), res.getDate("start_date"), res.getDate("endDate"));
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
