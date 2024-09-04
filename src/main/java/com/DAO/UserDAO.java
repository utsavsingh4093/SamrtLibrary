package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DTO.Admin;
import com.DTO.User;

public class UserDAO {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_project", "root", "4093");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static User getUserByNumberAndPassword(String meberShipNumber,String password)
	{
		User user=null;
		try {
			Connection connection=UserDAO.getConnection();
			String query="select * from student where membernumber = ? and password = ?";
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, meberShipNumber);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
	         	user.setEmail(rs.getString(3));
	         	user.setRole(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setMembernumber(rs.getString(6));	
			}
			rs.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}
	public static List<User> getEmail(String email)
	{
		List<User> list=new ArrayList<User>();
	User user=null;
	try {
		String query="select * from student where email=?";
		Connection conn=AdminDAO.getConnection();
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			user=new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setRole(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setMembernumber(rs.getString(6));	
			list.add(user);
		}
		rs.close();
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
	}
	
	public static User FetchSingle(int id)
	{
		User user=null;
		String sql="Select name from student where id=?";
		try {
			Connection con=UserDAO.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				user=new User();
				user.setName(rs.getString(1));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
	}
	
}
