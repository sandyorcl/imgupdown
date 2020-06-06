package com.iud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(description = "Logout From The Application", urlPatterns = { "/logout" })
public class LogoutServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost( request,  response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String msg = "You Are Logging Out Successfully";
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		request.setAttribute("msgcolor", "gray");
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
