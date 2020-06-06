package com.iud.dao;

import java.sql.SQLException;

import com.iud.model.LoginUser;

public interface LoginDAO {
	
	public LoginUser isLoginUser(String email, String password) throws SQLException;
	
	public boolean isLoginUserExist(String email) throws SQLException;
	
	public void userChangePassword(String email, String newPassword, String oldPassword) throws SQLException;
	
	public int registerUser(LoginUser userDetails) throws SQLException;
	
	public String resetCustomerPassword(String email) throws SQLException;

}
