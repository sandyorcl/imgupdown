package com.iud.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iud.dao.LoginDAO;
import com.iud.daoimpl.LoginDAOImpl;

//imgupdown2020@gmail.com
//imgupdown@123
@WebServlet(description = "Change The Password Of Registered User", urlPatterns = { "/changePassword" })
public class ChangePasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String page = "changeUserPassword.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(page).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email_id = request.getParameter("email");
		String newPassword = request.getParameter("newpassword");
		String oldPassword = request.getParameter("oldpassword");
		String msg = "";

		LoginDAO loginDAO = new LoginDAOImpl();
		boolean isUserExist = false;

		try {
			isUserExist = loginDAO.isLoginUserExist(email_id);
		} catch (SQLException e) {
  			msg = "Something Went Wrong Try After Sometime";
  			request.setAttribute("msg", msg);
  			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if (isUserExist) {
			try {
				loginDAO.userChangePassword(email_id, newPassword, oldPassword);
			} catch (SQLException e) {
	  			msg = "Something Went Wrong Try After Sometime";
	  			request.setAttribute("msg", msg);
	  			request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			request.setAttribute("msgcolor", "gray");
			// Set Success message to JSP
			msg = "Password Has Been Changed Successfully, Kindly Login";
		} else {
			// Set Error message to JSP
			request.setAttribute("msgcolor", "gray");
			msg = "User Id Does Not Exist";
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher(page).forward(request, response);
	}

}
