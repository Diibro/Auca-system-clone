package com.dushime.services;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dushime.utility.PathExtract;

@WebFilter(urlPatterns="/*")
public class AuthorizationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)  request;
		HttpServletResponse res  = (HttpServletResponse) response ;
		String pathname = PathExtract.getPathname(req.getRequestURL());
		System.out.println("path visited: " + pathname);
		Cookie[] cookies = req.getCookies();
		String role = new String();
		if(cookies != null) {
			for(Cookie ck: cookies) {
				if(ck.getName().equals("role")) {
					role = ck.getValue();
					break;
				}
			}
		}
		
		System.out.println("Session checking");
		if(role != null && !role.equals("") && !pathname.equals("login.html") && !pathname.equals("login") ) {
			System.out.println("role found");
			HttpSession session = req.getSession(false);
			if(session == null) {
				Cookie ck = new Cookie("msgErr", "Session-time-out");
				ck.setMaxAge(2);
				res.addCookie(ck);
				res.sendRedirect("login.html");
			}else {
				String redirect = PathExtract.getRedirect(pathname, role);
				if(redirect == null) {
					chain.doFilter(req, res);
				}else {
					Cookie ck = new Cookie("msgErr", "Not-authorised-to-view-this-page.-First-login-please!!");
					ck.setMaxAge(3);
					res.addCookie(ck);
					res.sendRedirect(redirect);
				}
			}
		}else {
			String redirect = PathExtract.getRedirect(pathname, role);
			if(redirect == null) {
				chain.doFilter(req, res);
			}else {
				Cookie ck = new Cookie("msgErr", "Not-authorised-to-view-this-page.-First-login-please!!");
				ck.setMaxAge(3);
				res.addCookie(ck);
				res.sendRedirect(redirect);
			}
		}
		
		
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
