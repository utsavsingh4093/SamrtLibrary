package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DTO.Admin;

public class AdminDAO {
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

	public static Admin getUserByNumberAndPassword(String meberShipNumber, String password) {
		Admin user = null;
		try {
			Connection connection = AdminDAO.getConnection();
			String query = "select * from admin where membernumber = ? and password = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, meberShipNumber);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new Admin();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setRole(rs.getString(3));
				user.setLibraryName(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setPassword(rs.getString(7));
				user.setMemberShipNumber(rs.getString(8));
			}
			rs.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

	public static List<Admin> getEmail(String email) {
		List<Admin> list = new ArrayList<Admin>();

		try {
			String query = "select * from admin where email=?";
			Connection conn = AdminDAO.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			Admin admin = null;
			while (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setLibraryName(rs.getString(3));
				admin.setAddress(rs.getString(4));
				admin.setEmail(rs.getString(5));
				admin.setRole(rs.getString(6));
				admin.setPassword(rs.getString(7));
				admin.setMemberShipNumber(rs.getString(8));
				list.add(admin);
			}
			rs.close();
			conn.close();
			System.out.println(list.size() == 0);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
