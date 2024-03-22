package com.dushime.services;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dushime.dao.StudentDao;
import com.dushime.model.Student;
import com.dushime.utility.Return;

@WebServlet(urlPatterns="/apply")
public class Application extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		doPost(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			String userEmail = null;
			String role = null;
			Cookie[] cookies = req.getCookies();
			if(cookies == null) {
				Cookie errCk = new Cookie("msgErr", "first-login-please");
				errCk.setMaxAge(2);
				res.addCookie(errCk);
				res.sendRedirect("login.html");
			}else {
				for(Cookie ck : cookies) {
					if(ck.getName().equals("email")) {
						userEmail = ck.getValue();
					}
					if(ck.getName().equals("role")) {
						role = ck.getValue();
					}
				}
				
				if(userEmail != null && role.equals("student")) {
					 String firstName = req.getParameter("firstName");
					 String lastName = req.getParameter("lastName");
					 Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("dateOfBirth"));
					 UUID programId = UUID.fromString(req.getParameter("program"));
//					 System.out.println(firstName + " " + lastName + " " + dateOfBirth + " " + programId + " " + userEmail);
					 Return ret = new StudentDao().create(new Student(firstName, lastName, dateOfBirth, programId), userEmail);
					 if(ret.isCheck()) {
						 Cookie msgCookie = new Cookie("msg", ret.getMessage());
						 msgCookie.setMaxAge(2);
						 res.addCookie(msgCookie);
						 res.sendRedirect("index.html");
					 }else {
						 Cookie errCk = new Cookie("msgErr", ret.getMessage());
						 errCk.setMaxAge(2);
						 res.addCookie(errCk);
						 res.sendRedirect("apply.html");
					 }
				}else {
					Cookie errCk = new Cookie("msgErr", "Must-be-student-to-apply");
					errCk.setMaxAge(2);
					res.addCookie(errCk);
					res.sendRedirect("login.html");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return;
	}
}
