<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include\Header.inc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload/Download</title>
         
        <link rel="stylesheet" href="resource/css/main.css" />
        <script type="text/javascript" src="resource/js/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="resource/js/fileupload.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    </head>
    <body class="body">
        <div class="panel">
            <h1>File Upload</h1>
            <h3>To Select Multiple Files Press 'CTRL' Key+Click On File in Open Dialog</h3>
            <form id="fileUploadForm" method="post" action="fileUpload" enctype="multipart/form-data">
                <div class="form_group">
                    <label>Upload File</label><span id="colon">: </span><input id="fileAttachment" type="file" name="fileUpload" multiple="multiple" />
                    <span id="fileUploadErr">Please Upload A File!</span>
                </div>
                <button id="uploadBtn" type="submit" class="btn btn_primary">Upload</button>
            </form>
        </div>
         
        <!-- List All Uploaded Files -->
        <div class="panel">
            <a id="allFiles" class="hyperLink" href="<%=request.getContextPath()%>/uploadedFiles">List all uploaded files</a>
        </div>
    </body>
</html>