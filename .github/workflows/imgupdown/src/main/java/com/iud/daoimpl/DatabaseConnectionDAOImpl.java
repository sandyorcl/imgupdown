package com.iud.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.iud.dao.DatabaseConnectionDAO;
import com.iud.util.Utility;

public class DatabaseConnectionDAOImpl implements DatabaseConnectionDAO {

	private static DatabaseConnectionDAOImpl instance;
	private Connection connection;


	private DatabaseConnectionDAOImpl() throws SQLException {
		try {
			
			Properties props = new Utility().readPropertiesFile("Connect_DB.Properties");
			Class.forName(props.getProperty("DBDriverName"));
			this.connection = DriverManager.getConnection(props.getProperty("DBURL"), props.getProperty("DBUserName"), props.getProperty("DBUserPassword"));
		} catch (ClassNotFoundException ex) {
			System.out.println("Database Connection Creation Failed : " + ex.getMessage());
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static DatabaseConnectionDAOImpl getInstance() throws SQLException {
		if (instance == null) {
			instance = new DatabaseConnectionDAOImpl();
		} else if (instance.getConnection().isClosed()) {
			instance = new DatabaseConnectionDAOImpl();
		}
		return instance;
	}
}
