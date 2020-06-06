package com.iud.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.iud.dao.FileUploadDAO;
import com.iud.daoimpl.FileUploadDAOImpl;
import com.iud.model.LoginUser;
import com.iud.model.UploadFileDetail;
 
@WebServlet(description = "Upload File To The Given Server Path", urlPatterns = { "/fileUpload" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50)
public class FileUploadServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
    public static final String DIR_NAME = "uploadedFiles";
    public String fileType = "";
 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	HttpSession session = request.getSession();
    	if (session.getAttribute("loginUserDetails") == null) {
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	} else {
    		doPost(request, response);
    	}
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String msg = "";
        String appPath = getServletContext().getRealPath("");
        String dirPath = appPath + File.separator + DIR_NAME;

    	HttpSession session = request.getSession();
    	LoginUser loginUser = (LoginUser) session.getAttribute("loginUserDetails");
    	if (loginUser == null) {
    		request.getRequestDispatcher("index.jsp").forward(request, response);
    	}
    	
        File uploadFile = new File(dirPath);
        
        if (!uploadFile.exists())
        {
            uploadFile.mkdirs();
        }
 
        String fileName = "";
        
        UploadFileDetail details = null;
        List<UploadFileDetail> fileList = new ArrayList<UploadFileDetail>();
 
        for (Part part : request.getParts()) 
        {
        	fileType ="";
            fileName = fetchFileName(part);
            details = new UploadFileDetail();
            details.setFileSize(part.getSize() / 1024);
            
            String newDirPath =  getFolderPath(dirPath, fileName);
            details.setFileName(fileName);
            details.setFilePath(newDirPath+ File.separator +fileName);
            try 
            {
                part.write(newDirPath + File.separator + fileName);
                details.setUploadStatus("Success");
            } catch (FileAlreadyExistsException ex) {
            	details.setUploadStatus("FileAlreadyExists : "+ fileName);
        	} catch (IOException ex) {
                details.setUploadStatus("Failure : "+ fileName);
            }
            details.setUploadedBy(loginUser.getEmail_id());
            details.setFileType(fileType);
            fileList.add(details);
        }
 
        FileUploadDAO fileUploadDAO = new FileUploadDAOImpl();
        try {
		        int uploadedFileCount = fileUploadDAO.uploadFileDetails(fileList );
		        System.out.println("Number of files uploaded: " + uploadedFileCount);
			} catch (SQLException e) {
					msg = "Something Went Wrong Try After Sometime";
		  	        RequestDispatcher dispatcher = request.getRequestDispatcher("/fileupload.jsp");
		  	        dispatcher.forward(request, response);
			}
        
        request.setAttribute("uploadedFiles", fileList);
        request.setAttribute("msg", msg);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/fileuploadResponse.jsp");
        dispatcher.forward(request, response);
    }
 
    private String fetchFileName(Part part) 
    {
        String fileName = "";
        String contentHeader = part.getHeader("content-disposition");
        String[] items = contentHeader.split(";");
        for (String item : items) 
        {
            if (item.trim().startsWith("filename")) 
            {
                fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return fileName;
    }
    
    private String getFolderPath(String dirPath, String fileName)
    {
    	if(fileName.endsWith(".png") || fileName.endsWith(".ai") ||fileName.endsWith(".bmp") 
    			||fileName.endsWith(".gif") ||fileName.endsWith(".jpg") ||fileName.endsWith(".jpeg") ||fileName.endsWith(".ico") ) 
    	{
    		dirPath = dirPath + File.separator + "img";
            File uploadFile = new File(dirPath);
            
            if (!uploadFile.exists())
            {
                uploadFile.mkdirs();
            }
            fileType = "Image";
     
    	}
    	else if(fileName.endsWith(".doc") || fileName.endsWith(".docx")) 
    	{
    		dirPath = dirPath + File.separator + "doc";
            File uploadFile = new File(dirPath);
            
            if (!uploadFile.exists())
            {
                uploadFile.mkdirs();
            }
     
            fileType = "Document";
    	}
    	else if(fileName.endsWith(".xls") || fileName.endsWith(".xlsx")) 
    	{
    		dirPath = dirPath + File.separator + "excel";
            File uploadFile = new File(dirPath);
            
            if (!uploadFile.exists())
            {
                uploadFile.mkdirs();
            }
            
            fileType = "Excel";
     
    	}
    	else if(fileName.endsWith(".ppt") || fileName.endsWith(".pptx")) 
    	{
    		dirPath = dirPath + File.separator + "ppt";
            File uploadFile = new File(dirPath);
            
            if (!uploadFile.exists())
            {
                uploadFile.mkdirs();
            }
            
            fileType = "PPT";
     
    	}
    	else if(fileName.endsWith(".pdf")) 
    	{
    		dirPath = dirPath + File.separator + "pdf";
            File uploadFile = new File(dirPath);
            
            if (!uploadFile.exists())
            {
                uploadFile.mkdirs();
            }
     
            fileType = "PDF";
    	} 
    	else 
    	{
    		dirPath = dirPath + File.separator + "others";
            File uploadFile = new File(dirPath);
            
            if (!uploadFile.exists())
            {
                uploadFile.mkdirs();
            }
     
            fileType = "OTHERS";
            
    	}
    	return dirPath;
    }
}