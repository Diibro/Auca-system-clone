package com.dushime.services;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet(urlPatterns="/erroHandling")
public class ErrorHandling  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		Throwable throwable = (Throwable)req.getAttribute("javax.servlet.error.exception");
		
		Integer status = (Integer)req.getAttribute("javax.servlet.error.status_code");
		
		String servlet_name = (String)req.getAttribute("javax.servlet.error.servlet_name");
		
		if(servlet_name == null ) {
			servlet_name = "Unknown";
		}
		if(status == 404) {
			res.sendRedirect("notFound.html");
		}else if(status == 405) {
			res.sendRedirect("notFound.html");
		}else {
			res.sendRedirect("error.html");
		}
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doGet(req,res);
	}
}
