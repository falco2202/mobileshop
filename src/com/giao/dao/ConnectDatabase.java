package com.giao.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDatabase {
	public static Connection cn;

	public static Connection connection()  {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			System.out.println("Oke");
			String url = "jdbc:sqlserver://DESKTOP-VVLTSBE\\SQLEXPRESS:1433;databaseName=TestEcommerce;user=sa; password=123456";
			cn = DriverManager.getConnection(url);
//			System.out.println("Oke");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cn;
	}
	
	public static void main(String[] args) {
		
	}
}
