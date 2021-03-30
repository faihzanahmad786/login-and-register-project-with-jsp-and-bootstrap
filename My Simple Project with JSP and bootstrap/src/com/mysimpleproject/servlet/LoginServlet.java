package com.mysimpleproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysimpleproject.bean.UserBean;
import com.mysimpleproject.dao.LoginDao;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private LoginDao loginDao;

	public void init() {
	        loginDao = new LoginDao();
	 }
	 
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserBean userBean = new UserBean();
			userBean.setUsername(username);
			userBean.setPassword(password);
			
			try {
				if (loginDao.validate(userBean)) {
					//HttpSession session = request.getSession();
					// session.setAttribute("username",username);
					response.sendRedirect("welcome.jsp");
				} else {
					@SuppressWarnings("unused")
					HttpSession session = request.getSession();
					//session.setAttribute("user", username);
					//response.sendRedirect("login.jsp");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	 
}
