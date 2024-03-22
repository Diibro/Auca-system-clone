package com.dushime.services;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dushime.dao.UserDao;
import com.dushime.model.User;

@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private User user;
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			user = new User();
			user.setEmail(req.getParameter("email"));
			user.setPassword(req.getParameter("password"));
			User u = new UserDao().search(user);
			if(u != null && u.getPassword().equals(user.getPassword())) {
				Cookie emailCookie = new Cookie("email", u.getEmail());
				emailCookie.setMaxAge(60*60);
				res.addCookie(emailCookie);
				
				Cookie roleCookie = new Cookie("role", u.getRole());
				roleCookie.setMaxAge(60 * 60);
				res.addCookie(roleCookie);
				
				Cookie msgCookie = new Cookie("msg", "Successfully-logged-in!!");
				msgCookie.setMaxAge(2);
				res.addCookie(msgCookie);
				
				HttpSession session = req.getSession(true);
				session.setAttribute("email", u.getEmail());
				session.setAttribute("role", u.getRole());
				session.setAttribute("password", u.getPassword());
				session.setMaxInactiveInterval(60);
				System.out.println("Session set now");
				res.sendRedirect("index.html");
			}else {
				Cookie msgCookie = new Cookie("msgErr", "Fail.-invalid-login-credentials");
				msgCookie.setMaxAge(2);
				res.addCookie(msgCookie);
				res.sendRedirect("login.html");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
