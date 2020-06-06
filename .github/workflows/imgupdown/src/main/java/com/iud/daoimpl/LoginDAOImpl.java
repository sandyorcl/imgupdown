package com.iud.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.RandomStringUtils;

import com.iud.dao.LoginDAO;
import com.iud.model.LoginUser;

public class LoginDAOImpl implements LoginDAO {

	@Override
	public LoginUser isLoginUser(String email, String password) throws SQLException {
		String SQL_SELECTUSEREXIST = "select * from imglogin where email_id = ? and password = ?";
		DatabaseConnectionDAOImpl dbConn = null;
		ResultSet rst = null;
		LoginUser userDetails = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = DatabaseConnectionDAOImpl.getInstance();

			conn = dbConn.getConnection();

			preparedStatement = conn.prepareStatement(SQL_SELECTUSEREXIST);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			rst = preparedStatement.executeQuery();

			while (rst.next()) {
				userDetails = new LoginUser();
				userDetails.setFirst_name(rst.getString("first_name"));
				userDetails.setLast_name(rst.getString("last_name"));
				userDetails.setMobile(rst.getString("mobile"));
				userDetails.setGender(rst.getString("gender"));
				userDetails.setEmail_id(email);
			}
		} catch (SQLException e) {
			System.out.println("LoginDAOImpl"+":isLoginUser:"+e.getMessage());
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
				System.out.println("LoginDAOImpl"+":isLoginUser:"+e.getMessage());
				throw e;
			}
		}
		return userDetails;
	}

	@Override
	public boolean isLoginUserExist(String email) throws SQLException  {

		String SQL_SELECTUSEREXIST = "select * from imglogin where email_id = ?";
		DatabaseConnectionDAOImpl dbConn = null;
		ResultSet rst = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = DatabaseConnectionDAOImpl.getInstance();
			conn = dbConn.getConnection();

			preparedStatement = conn.prepareStatement(SQL_SELECTUSEREXIST);
			preparedStatement.setString(1, email);

			rst = preparedStatement.executeQuery();

			if (rst.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("LoginDAOImpl"+":isLoginUserExist:"+e.getMessage());
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
				System.out.println("LoginDAOImpl"+":isLoginUserExist:"+e.getMessage());
				throw e;
			}
		}
		return false;
	}

	@Override
	public void userChangePassword(String email, String newPassword, String oldPassword) throws SQLException  {
		String SQL_UPDATE = "update imglogin set password = ? where email_id = ? and password = ?";
		DatabaseConnectionDAOImpl dbConn = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = DatabaseConnectionDAOImpl.getInstance();
			conn = dbConn.getConnection();

			preparedStatement = conn.prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, oldPassword);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("LoginDAOImpl"+":userChangePassword:"+e.getMessage());
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
				System.out.println("LoginDAOImpl"+":userChangePassword:"+e.getMessage());
				throw e;
			}
		}

	}

	@Override
	public int registerUser(LoginUser userDetails) throws SQLException {

		String SQL_INSERT = "INSERT INTO imglogin (first_name, last_name, mobile, email_id, password, gender) VALUES (?,?,?,?,?,?)";
		DatabaseConnectionDAOImpl dbConn = null;
		int row = 0;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = DatabaseConnectionDAOImpl.getInstance();
			conn = dbConn.getConnection();

			preparedStatement = conn.prepareStatement(SQL_INSERT);
			preparedStatement.setString(1, userDetails.getFirst_name());
			preparedStatement.setString(2, userDetails.getLast_name());
			preparedStatement.setString(3, userDetails.getMobile());
			preparedStatement.setString(4, userDetails.getEmail_id());
			preparedStatement.setString(5, userDetails.getPassword());
			preparedStatement.setString(6, userDetails.getGender());

			row = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("LoginDAOImpl"+":registerUser:"+e.getMessage());
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
				System.out.println("LoginDAOImpl"+":registerUser:"+e.getMessage());
				throw e;
			}
		}
		return row;
	}

	@Override
	public String resetCustomerPassword(String email) throws SQLException {

		String randomPassword = RandomStringUtils.randomAlphanumeric(10);
		String SQL_UPDATE = "update imglogin set password = ? where email_id = ?";
		DatabaseConnectionDAOImpl dbConn = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			dbConn = DatabaseConnectionDAOImpl.getInstance();
			conn = dbConn.getConnection();

			preparedStatement = conn.prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, randomPassword);
			preparedStatement.setString(2, email);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("LoginDAOImpl"+":resetCustomerPassword:"+e.getMessage());
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
				System.out.println("LoginDAOImpl"+":resetCustomerPassword:"+e.getMessage());
				throw e;
			}
		}
		return randomPassword;
	}
}
