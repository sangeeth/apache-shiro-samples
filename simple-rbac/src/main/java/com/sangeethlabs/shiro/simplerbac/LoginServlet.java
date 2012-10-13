package com.sangeethlabs.shiro.simplerbac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		try {
			SecurityUtils.getSubject().login(token);
			
			resp.sendRedirect(req.getContextPath()+"/home");	
		} catch (AuthenticationException e) {
			req.setAttribute("errorMessage", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if (SecurityUtils.getSubject().isAuthenticated()) {
			resp.sendRedirect(req.getContextPath()+"/home");
		} else {
			req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		}
	}
}
