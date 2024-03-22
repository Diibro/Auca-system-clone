package com.dushime.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.UUID;

import com.dushime.model.DBConfig;
import com.dushime.model.User;
import com.dushime.utility.Return;
import com.dushime.utility.Uuid;

public class UserDao {
	private User user;
	private String query;
	private Statement st;
	private Connection con;
	private PreparedStatement pSt;
	private Return ret;
	
	public UserDao() {
		con = new DBConfig().getCon();
		user = new User();
		ret = new Return(null, false, null);
	}
	
	private boolean has(String email) {
		try {
			pSt = con.prepareStatement("select * from users where user_email = ? ;");
			pSt.setString(1,email);
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
	
	public Return create(User u) {
		try {
			if(!this.has(u.getEmail())) {
				pSt = con.prepareStatement("insert into users values (?,?,?,?)");
				pSt.setObject(1,Uuid.getNew());
				pSt.setString(2, u.getEmail());
				pSt.setString(3, u.getPassword());
				pSt.setString(4, u.getRole());
				
				int res = pSt.executeUpdate();
				if(res > 0 ) {
					ret.setMessage("Account created successfully!!");
					ret.setCheck(true);
				}else {
					ret.setMessage("Failed to create the account. Some server error");
					ret.setCheck(false);
				}
			}else {
				ret.setMessage("User already exists. Login instead");
				ret.setCheck(false);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			ret.setMessage("Account creation failed. Server error");
			ret.setCheck(false);
			ret.setError(e);
		}
		return ret;
	}
	
	public User search(User u) {
		try {
			pSt = con.prepareStatement("select * from users where user_email = ? ;");
			pSt.setString(1,u.getEmail());
			ResultSet res = pSt.executeQuery();
			if(res.next()) {
				user.setEmail(res.getString("user_email"));
				user.setPassword(res.getString("user_password"));
				user.setRole(res.getString("role"));
				return user;
			}else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
