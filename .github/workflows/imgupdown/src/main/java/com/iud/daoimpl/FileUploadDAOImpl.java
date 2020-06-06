package com.iud.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iud.dao.FileUploadDAO;
import com.iud.model.UploadFileDetail;
import com.iud.util.DateUtil;

public class FileUploadDAOImpl implements FileUploadDAO {
	
	@Override
	public int uploadFileDetails(List<UploadFileDetail> uploadFileDetails) throws SQLException{
		String SQL_INSERT = "INSERT INTO FileUploadDownload (filename, filepath, filesize, filetype, uploadstatus, uploadedby, uploadedon) VALUES (?,?,?,?,?,?,?)";
		DatabaseConnectionDAOImpl dbConn = null;
		int rows = 0;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = DatabaseConnectionDAOImpl.getInstance();
			conn = dbConn.getConnection();

			preparedStatement = conn.prepareStatement(SQL_INSERT);
			
			for(UploadFileDetail uploadFileDetail : uploadFileDetails)
			{
				preparedStatement.setString(1, uploadFileDetail.getFileName());
				preparedStatement.setString(2, uploadFileDetail.getFilePath());
				preparedStatement.setString(3, String.valueOf(uploadFileDetail.getFileSize()));
				preparedStatement.setString(4, uploadFileDetail.getFileType());
				preparedStatement.setString(5, uploadFileDetail.getUploadStatus());
				preparedStatement.setString(6, uploadFileDetail.getUploadedBy());
				preparedStatement.setString(7, DateUtil.getCurrentDate());
				preparedStatement.addBatch();
			}
			
			preparedStatement.executeBatch();

		} catch (SQLException e) {
			System.out.println("FileUploadDAOImpl"+":uploadFileDetails:"+e.getMessage());
			throw e;
		} finally {
			try {
				if (conn != null)
				{
					conn.close();
				}
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
			} catch (SQLException e) {
				System.out.println("FileUploadDAOImpl"+":uploadFileDetails:"+e.getMessage());
				throw e;
			}
		}
		return rows;
	}

	@Override
	public List<UploadFileDetail> getFileList(String uploadedby) throws SQLException {
		String SQL_GETFILELIST = "select * from FileUploadDownload where uploadedby = ? and uploadstatus=?";
		DatabaseConnectionDAOImpl dbConn = null;
		ResultSet rst = null;
		
		List<UploadFileDetail> uploadFileDetail = new ArrayList<UploadFileDetail>();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = DatabaseConnectionDAOImpl.getInstance();

			conn = dbConn.getConnection();

			preparedStatement = conn.prepareStatement(SQL_GETFILELIST);
			preparedStatement.setString(1, uploadedby);
			preparedStatement.setString(2, "Success");

			rst = preparedStatement.executeQuery();

			while (rst.next()) {
				UploadFileDetail fileDetail = new UploadFileDetail();
				
				fileDetail.setFileName(rst.getString("filename"));
				fileDetail.setFilePath(rst.getString("filepath"));
				fileDetail.setFileSize(Long.parseLong(rst.getString("filesize")));
				fileDetail.setFileType(rst.getString("filetype"));
				fileDetail.setUploadStatus(rst.getString("uploadstatus"));
				fileDetail.setUploadedBy(rst.getString("uploadedby"));
				fileDetail.setUploadedOn(rst.getString("uploadedon"));
				uploadFileDetail.add(fileDetail);
			}
		} catch (SQLException e) {
			System.out.println("FileUploadDAOImpl"+":getFileList:"+e.getMessage());
			throw e;
		} finally {
			try {
				if (conn != null)
				{
					conn.close();
				}
				if(preparedStatement != null)
				{
					preparedStatement.close();
				}
			} catch (SQLException e) {
				System.out.println("FileUploadDAOImpl"+":getFileList:"+e.getMessage());
				throw e;
			}
		}
		return uploadFileDetail;
	}
}
