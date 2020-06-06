package com.iud.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iud.dao.LoginDAO;
import com.iud.daoimpl.LoginDAOImpl;
import com.iud.model.LoginUser;

@WebServlet(description = "Register To The Application", urlPatterns = { "/registerUser" })
public class RegisterUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	String page = "registerUser.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	    dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In RegisterUserServlet doPost method");

		String first_name = request.getParameter("firstName");
		String last_name = request.getParameter("lastName");
		String mobile = request.getParameter("mobile");
		String email_id = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String msg = "";

		LoginUser userDetails = new LoginUser(first_name, last_name, mobile, email_id, password, gender);

		System.out.println("User Details " + userDetails.toString());

		LoginDAO login = new LoginDAOImpl();
		
		try {
			if(login.isLoginUserExist(email_id)) {
				msg = "Email ID Is Exist, Kindly Use Different";
			}else {

				int result = login.registerUser(userDetails);
				if(result > 0) {
					msg = email_id+" Is Successfully Registered, Kindly Login";
					request.setAttribute("msgcolor", "gray");
				} else {
					msg = email_id+" Is Not Registered Something Went Wrong, Kindly Register Again";
				}
			}
		} catch (SQLException e) {
  			msg = "Something Went Wrong Try After Sometime";
  			request.setAttribute("msg", msg);
  			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		request.setAttribute("msg", msg);
	    RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	    dispatcher.forward(request, response);
	}

}
