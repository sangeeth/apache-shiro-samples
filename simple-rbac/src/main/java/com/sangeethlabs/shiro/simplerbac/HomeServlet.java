package com.sangeethlabs.shiro.simplerbac;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public HomeServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Subject subject =  SecurityUtils.getSubject();
		
		req.setAttribute("username", subject.getPrincipal());
		
		req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String method = req.getParameter("method");

		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		ProtectedService protectedService = (ProtectedService)applicationContext.getBean("protectedService");
		
		try {
			if ("getUsers".equals(method)) {
				req.setAttribute("users", protectedService.getUsers());
			} else if ("getRoles".equals(method)) {
				req.setAttribute("roles", protectedService.getRoles());
			} else if ("getSystemTime".equals(method)) {
				req.setAttribute("systemTime", protectedService.getSystemTime());
			} else if ("sum".equals(method)) {
				int a = Integer.parseInt(req.getParameter("a"));
				int b = Integer.parseInt(req.getParameter("b"));
				req.setAttribute("sum",protectedService.sum(a, b));
			} else if ("diff".equals(method)) {
				int a = Integer.parseInt(req.getParameter("a"));
				int b = Integer.parseInt(req.getParameter("b"));
				req.setAttribute("diff",protectedService.diff(a, b));
			} else if ("getHomeFiles".equals(method)) {
				req.setAttribute("homeFiles",protectedService.getHomeFiles());
			} else if ("getGreetingMessage".equals(method)) {
				String name = req.getParameter("name");
				req.setAttribute("greetingMessage",protectedService.getGreetingMessage(name));
			}
		} catch(Exception e) {
			req.setAttribute("errorMessage", e.getMessage());
		}
		
		this.doGet(req, resp);
	}

}
