package com.sangeethlabs.shiro.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Subject subject =  SecurityUtils.getSubject();
		
		req.setAttribute("username", subject.getPrincipal());
		
		req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
	}

}
