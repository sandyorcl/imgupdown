package com.iud.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iud.dao.FileUploadDAO;
import com.iud.daoimpl.FileUploadDAOImpl;
import com.iud.model.LoginUser;
import com.iud.model.UploadFileDetail;
 
@WebServlet(description = "List The Already Uploaded Files", urlPatterns = { "/uploadedFiles" })
public class UploadedFilesServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
    public static final String UPLOAD_DIR = "uploadedFiles";
 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	if (session.getAttribute("loginUserDetails") == null) {
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	} else {
        	handleRequest(request, response);
    	}
    }
    
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	LoginUser loginUser = (LoginUser) session.getAttribute("loginUserDetails");
    	if (loginUser == null) {
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	}
    	
        FileUploadDAO fileUploadDAO = new FileUploadDAOImpl();
        List<UploadFileDetail> fileList = new ArrayList<UploadFileDetail>();
        String msg = "";
        try {
        		fileList = fileUploadDAO.getFileList(loginUser.getEmail_id());
			} catch (SQLException e) {
					msg = "Something Went Wrong Try After Sometime";
		  	        RequestDispatcher dispatcher = request.getRequestDispatcher("/fileupload.jsp");
		  	        dispatcher.forward(request, response);
			}
        request.setAttribute("msg", msg);
        request.setAttribute("uploadedFiles", fileList);
        request.setAttribute("allfiles", "nostatus");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/fileuploadResponse.jsp");
        dispatcher.forward(request, response);
    }
 
    public void handleRequestOld(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        String applicationPath = getServletContext().getRealPath(""),
                uploadPath = applicationPath + File.separator + UPLOAD_DIR;
 
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
 
        UploadFileDetail details = null;
        File[] allFilesDir = fileUploadDirectory.listFiles();
        List<UploadFileDetail> fileList = new ArrayList<UploadFileDetail>();        
 
        for (File fileDir : allFilesDir) {
	        for (File file : fileDir.listFiles()) {
	            details = new UploadFileDetail();
	            details.setFileName(file.getName());
	            details.setFilePath(uploadPath+ File.separator +fileDir.getName()+ File.separator +file.getName());
	            details.setFileSize(file.length() / 1024);
	            fileList.add(details);
	        }
        }
 
        request.setAttribute("uploadedFiles", fileList);
        request.setAttribute("allfiles", "nostatus");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/fileuploadResponse.jsp");
        dispatcher.forward(request, response);
    }
}