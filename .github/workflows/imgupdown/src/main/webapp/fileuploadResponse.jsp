<%@page import="java.util.List"%>
<%@page import="com.iud.model.UploadFileDetail"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.nio.charset.StandardCharsets"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include\Header.inc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <title>File Upload/Download</title>
        <link rel="stylesheet" href="resource/css/main.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    </head>
    <body>
        <div class="panel">
            <h1>File Upload Status</h1>
            <table class="bordered_table">
                <thead>
                    <tr align="center">
	                    <th>File Name</th>
	                    <th>File Size</th>
	                    <% 
	                    String allfilesReqAtt = (String) request.getAttribute("allfiles");
	                    if (! (allfilesReqAtt != null && allfilesReqAtt.equals("nostatus"))) { %>
	                    <th>Upload Status</th>
	                    <% } else {%>
                        <th>Uploaded On</th>
                        <% } %>
	                    <th>File Path</th>
	                    <th>File Type</th>
	                    <th>Uploaded By</th>
	                    <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    	
                    	List<UploadFileDetail> uploadDetails = (List<UploadFileDetail>)request.getAttribute("uploadedFiles");
                        for(int i=0; i<uploadDetails.size(); i++) {
                            String fileName = uploadDetails.get(i).getFileName();
                    %>
                    <tr>
                        <td align="center"><span id="fileName"><%=fileName%></span></td>
                        <td align="center"><span id="fileSize"><%=uploadDetails.get(i).getFileSize() %> KB</span></td>
                        <% if (! (allfilesReqAtt != null && allfilesReqAtt.equals("nostatus"))) { %>
                        <td align="center"><span id="fileuploadStatus"><%=uploadDetails.get(i).getUploadStatus() %></span></td>
                        <% } else {%>
                        <td align="center"><span id="uploadedon"><%=uploadDetails.get(i).getUploadedOn() %></span></td>
                        <% } %>
                        <td align="center"><span id="filepath"><%=uploadDetails.get(i).getFilePath() %></span></td>
                        <td align="center"><span id="filetype"><%=uploadDetails.get(i).getFileType() %></span></td>
                        <td align="center"><span id="uploadedby"><%=uploadDetails.get(i).getUploadedBy() %></span></td>
                        <td align="center"><span id="fileDownload">
                        <a id="downloadLink" class="hyperLink" 
                           href="<%=request.getContextPath()%>/fileDownload?fileName=<%=URLEncoder.encode(uploadDetails.get(i).getFilePath(), StandardCharsets.UTF_8.toString()) %>">
                           Download</a></span></td>                                       
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <div class="margin_top_15px">
                <a id="fileUpload" class="hyperLink" href="<%=request.getContextPath()%>/fileupload.jsp">Back</a>
            </div>
        </div>
    </body>
</html>