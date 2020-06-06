package com.iud.dao;

import java.sql.SQLException;
import java.util.List;

import com.iud.model.UploadFileDetail;

public interface FileUploadDAO {
	
	public int uploadFileDetails(List<UploadFileDetail> uploadFileDetails) throws SQLException;
	
	public List<UploadFileDetail> getFileList(String uploadedby) throws SQLException;

}
