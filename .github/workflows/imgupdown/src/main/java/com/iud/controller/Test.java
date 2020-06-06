package com.iud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.iud.util.Utility;

public class Test {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Properties props = new Utility().readPropertiesFile("Connect_DB.Properties");
		Class.forName(props.getProperty("DBDriverName"));
		Connection connection = DriverManager.getConnection("jdbc:gil:sqlserver:10.10.6.249;databaseName=baanbatch", props.getProperty("DBUserName"), props.getProperty("DBUserPassword"));
		
	}
}
