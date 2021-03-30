package com.mysimpleproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysimpleproject.bean.UserBean;
import com.mysimpleproject.dao.RegisterDao;



public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterDao registerDao;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public void init() {
    	registerDao = new RegisterDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String password = request.getParameter("password");

        UserBean userbean = new UserBean();
        userbean.setName(name);
        userbean.setEmail(email);
        userbean.setUsername(username);
        userbean.setAddress(address);
        userbean.setPassword(password);
        
        try {
        	registerDao.userBean(userbean);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        response.sendRedirect("register.jsp");
	}

}
