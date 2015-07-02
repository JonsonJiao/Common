package com.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static Connection dbConn = null;

	public static Connection getConnection() {
		if (dbConn == null) {

			// TODO Auto-generated method stub
			String driverName = "com.mysql.jdbc.Driver";
			String dbURL = "jdbc:mysql://127.0.0.1:3306/test";
			String userName = "root";
			String userPwd = "1234dhcc";
			try {
				Class.forName(driverName);
				System.out.println("加载驱动成功！");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("加载驱动失败！");
			}
			try {
				dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dbConn;
	}

	public static void closeConnection() {
		if (dbConn != null) {
			try {
				dbConn.close();
				dbConn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
