package org.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.test.entity.User;

//模型层：用于处理登陆(查询数据库)
public class LoginDao {
	private static String Driver = "com.mysql.cj.jdbc.Driver";
	private static String Url = "jdbc:mysql://localhost:3306/users?serverTimezone=GMT%2B8&userSSL=false";
	private static String User = "root";
	private static String Password = "2018";
	public static PreparedStatement  pstet = null;
	public static ResultSet rs = null;
	public static Connection conn = null;
	public static PreparedStatement getPreparedStatement(String sql, Object[] parmes) {
		try {
			Class.forName(Driver);
			conn = DriverManager.getConnection(Url,User,Password);
			pstet = conn.prepareStatement(sql);
			if(parmes != null) {
				pstet.clearParameters();
				for(int i = 0; i < parmes.length; i++) {
					pstet.setObject(i+1, parmes[i]);
				}
			}
			return pstet;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		closeAll(pstet, rs, conn);
		return null;
	}
	public static boolean Connect(String sql, Object[] parmes) {
		try {
			pstet = getPreparedStatement(sql, parmes);
			int cnt = 0;
			cnt = pstet.executeUpdate();
			if(cnt > 0) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeAll(pstet, rs, conn);
		return false;
	}
	public static ResultSet getResultSet(String sql, Object[] parmes) {
		pstet = getPreparedStatement(sql, parmes);
		try {
			rs = pstet.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Boolean closeAll(PreparedStatement pstet, ResultSet rs, Connection conn) {
		try {
			if(rs != null) rs.close();
			if(pstet != null) pstet.close();
			if(conn != null) conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}




