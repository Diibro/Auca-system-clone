package com.dushime.services;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dushime.dao.UserDao;
import com.dushime.model.User;
import com.dushime.utility.Return;
@WebServlet(urlPatterns="/register")
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private User user;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		user = new User(null, req.getParameter("email"), req.getParameter("password"), req.getParameter("role"));
		Return ret = new UserDao().create(user);
		if(ret.isCheck()) {
			System.out.println(ret);
			Cookie ck = new Cookie("msg", String.join("-", ret.getMessage().split(" ")));
			ck.setMaxAge(5);
			res.addCookie(ck);
			res.sendRedirect("login.html");
		}else {
			Cookie ck = new Cookie("msgErr", String.join("-", ret.getMessage().split(" ")));
			ck.setMaxAge(5);
			res.addCookie(ck);
			System.out.println(ret);
			res.sendRedirect("signup.html");
		}
		
	}
}
