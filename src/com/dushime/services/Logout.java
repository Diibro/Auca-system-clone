package com.dushime.services;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			for(Cookie ck : cookies) {
				if(ck.getName().equals("email") || ck.getName().equals("role")) {
					ck.setMaxAge(0);
					res.addCookie(ck);
				}
			}
		}
		
		Cookie msgCookie = new Cookie("msg", "You-have-been-logout");
		msgCookie.setMaxAge(5);
		res.addCookie(msgCookie);
		res.sendRedirect("login.html");
		
	}
}
