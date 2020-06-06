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
import com.iud.util.Utility;

@WebServlet(description = "Forgot The Password Of Registered User", urlPatterns = { "/forgotPassword" })
public class ForgotPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String host;
	private String port;
	private String email;
	private String name;
	private String pass;
	String page = "forgotPassword.jsp";

	public void init() {
		// reads SMTP server setting from web.xml file
		host = "smtp.gmail.com";
		port = "587";
		email = "sandyorcl@gmail.com";
		name = "Sandesh Shinde";
		pass = "**********";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	    dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String recipient = request.getParameter("email");
		String subject = "Your Password has been reset";

		LoginDAO loginDAO = new LoginDAOImpl();
		boolean isUserExist = false;
		String msg = "";

		try {
			isUserExist = loginDAO.isLoginUserExist(recipient);
		} catch (SQLException e) {
  			msg = "Something Went Wrong Try After Sometime";
  			request.setAttribute("msg", msg);
  			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if (isUserExist) {

			// Get random string password need to store in table also
			String newPassword = "";
			try {
				newPassword = loginDAO.resetCustomerPassword(recipient);
			} catch (SQLException e) {
	  			msg = "Something Went Wrong Try After Sometime";
	  			request.setAttribute("msg", msg);
	  			request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			String content = "Hi, this is your new password: " + newPassword;
			content += "\nNote: for security reason, " + "you must change your password after logging in.";

			try {
				Utility.sendEmail(host, port, email, name, pass, recipient, subject, content);
				request.setAttribute("msgcolor", "gray");
				msg = "Your Password Has Been Reset. Please Check Your E-mail.";
			} catch (Exception ex) {
				msg = "Something Went Wrong, Kindly Do The Steps Forgot Your Password After Few Minutes"; 
				System.out.println("ForgotPasswordServlet : doPost : "+ ex.getMessage());
			} finally {
				request.setAttribute("msg", msg);
			    RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			    dispatcher.forward(request, response);
			}

		} else {
			// Set Error message to JSP
			request.setAttribute("msgcolor", "gray");
			msg = "User ID Does Not Exist";
			request.setAttribute("msg", msg);
		    RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		    dispatcher.forward(request, response);
		}

	}

}
