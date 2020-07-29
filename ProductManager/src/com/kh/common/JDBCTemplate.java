package com.kh.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	public static Connection getConnection() {
		
		Properties prop = new Properties(); // 파일 불러오기 
		try {
			prop.load(new FileReader("resources/driver.properties"));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
	
		Connection conn = null; 
		
		try {
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),
											   prop.getProperty("username"),
											   prop.getProperty("password"));
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn; 
	}// e.getConnection
	
	public static void commit(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//e.commit
	
	public static void rollback(Connection conn) {
		
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//e.rollback
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//e.close.conn
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && stmt.isClosed()) {
				stmt.close(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//e.stmt.close
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close(); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//e.close.rset
}




