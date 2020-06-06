package com.iud.model;

import java.io.Serializable;

public class UploadFileDetail implements Serializable {

	private static final long serialVersionUID = 1L;
 
	private String fileName;
	private String uploadStatus;
    private long fileSize;
    private String filePath;
    private String fileType;
    private String uploadedBy;
    private String uploadedOn;
 
    public long getFileSize() {
        return fileSize;
    }
 
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
 
    public String getFileName() {
        return fileName;
    }
 
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
 
    public String getUploadStatus() {
        return uploadStatus;
    }
 
    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public String getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(String uploadedOn) {
		this.uploadedOn = uploadedOn;
	}
}
