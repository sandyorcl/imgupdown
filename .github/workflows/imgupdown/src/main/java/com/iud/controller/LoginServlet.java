package com.iud.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iud.dao.LoginDAO;
import com.iud.daoimpl.LoginDAOImpl;
import com.iud.model.LoginUser;

@WebServlet(description = "Login To The Application", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	if (session.getAttribute("loginUserDetails") == null) {
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	} else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/fileupload.jsp");
            dispatcher.forward(request, response);
    	}
    	
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String email = request.getParameter("userName");
    	String password = request.getParameter("password");
    	String msg = "";
    	
  	  LoginDAO login = new LoginDAOImpl();
	  
  		LoginUser loginUserDetails = null;
		try {
			loginUserDetails = login.isLoginUser(email, password);
		} catch (SQLException e) {
  			msg = "Something Went Wrong Try After Sometime";
  			request.setAttribute("msg", msg);
  			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
  		if(loginUserDetails != null) {
  			HttpSession session = request.getSession();
  			session.setAttribute("loginUserDetails", loginUserDetails);
  	        RequestDispatcher dispatcher = request.getRequestDispatcher("/fileupload.jsp");
  	        dispatcher.forward(request, response);
  		}
  		else
  		{
  			msg = "User ID Or Passward Is Entered Wrong";
  			request.setAttribute("msg", msg);
  			request.getRequestDispatcher("index.jsp").forward(request, response);
  		}
    	
    }
}
