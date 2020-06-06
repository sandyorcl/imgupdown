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
            <h1>Uploaded Files</h1>
            <table class="bordered_table">
               <thead>
                  <tr align="center"><th>File Name</th><th>File Size</th><th>Action</th></tr>
               </thead>
               <tbody>
                  <%
                  	List<UploadFileDetail> uploadDetails = (List<UploadFileDetail>)request.getAttribute("uploadedFiles");
                                       if(uploadDetails != null && uploadDetails.size() > 0) {
                                       for(int i=0; i<uploadDetails.size(); i++) {
                  %>
                  <tr>
                     <td align="center"><span id="fileName"><%=uploadDetails.get(i).getFileName() %></span></td>
                     <td align="center"><span id="fileSize"><%=uploadDetails.get(i).getFileSize() %> KB</span></td>
                     <td align="center"><span id="fileDownload"><a id="downloadLink" class="hyperLink" 
                     href="<%=request.getContextPath()%>/fileDownload?fileName=<%=URLEncoder.encode(uploadDetails.get(i).getFilePath(), StandardCharsets.UTF_8.toString()) %>">Download</a></span></td>
                  </tr>
                  <% }
                   } else { %>
                  <tr>
                     <td colspan="3" align="center"><span id="noFiles">No Files Uploaded.....!</span></td>
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