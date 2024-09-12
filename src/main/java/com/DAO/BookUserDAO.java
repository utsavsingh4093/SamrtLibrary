package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.BookUser;
import com.dto.IssueBookDTO;
import com.dto.User;

public class BookUserDAO {
	static Connection connection = null;

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_project", "root", "4093");
		} catch (Exception p) {
			p.printStackTrace();
		}
		return connection;
	}

	public static int insertBook(BookUser bookUser) throws SQLException {
		int i = 0;
		try {
			Connection connection = BookUserDAO.getConnection();
			String query = "insert into addbook(adminName,BookName,Author,Edition,Quantity,Book) values(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bookUser.getAdminName());
			preparedStatement.setString(2, bookUser.getBookName());
			preparedStatement.setString(3, bookUser.getAuthorName());
			preparedStatement.setString(4, bookUser.getEdition());
			preparedStatement.setString(5, bookUser.getQuantity());
			preparedStatement.setString(6, bookUser.getBookimg());
			i = preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static BookUser fetch(int bookId) {
		BookUser bookUser = new BookUser();
		String query = "select * from addbook where id=?";
		try {
			Connection con = BookUserDAO.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, bookId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bookUser = new BookUser();
				bookUser.setId(rs.getInt(1));
				bookUser.setBookName(rs.getString(3));
				bookUser.setAuthorName(rs.getString(4));
				bookUser.setEdition(rs.getString(5));
				bookUser.setQuantity(rs.getString(6));
				bookUser.setBookimg(rs.getString(7));

			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookUser;
	}

	public static int deleteBookById(int bookId) {
		int i = 0;
		try {
			Connection conn = BookUserDAO.getConnection();
			String sql = "DELETE FROM library_project.addbook WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			i = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
		e.printStackTrace();	
		}
		return i;
	}

	public static int EditBookByID(BookUser bookUser) {
		int i = 0;
		try {
			Connection conn = BookUserDAO.getConnection();
			String sql = "update addbook set BookName=?, Author=?, Edition=?, Quantity=? where id=?;";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, bookUser.getBookName());
			preparedStatement.setString(2, bookUser.getAuthorName());
			preparedStatement.setString(3, bookUser.getEdition());
			preparedStatement.setString(4, bookUser.getQuantity());
			preparedStatement.setInt(5, bookUser.getId());
			i = preparedStatement.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public static List<BookUser> fetchAllBooks() {
		List<BookUser> list = new ArrayList<BookUser>();
		String query = "select * from addBook";
		try {
			Connection connection = BookUserDAO.getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				BookUser bookUser = new BookUser();
				bookUser.setId(rs.getInt(1));
				bookUser.setBookName(rs.getString(3));
				bookUser.setAuthorName(rs.getString(4));
				bookUser.setEdition(rs.getString(5));
				bookUser.setQuantity(rs.getString(6));
				bookUser.setBookimg(rs.getString(7));
				list.add(bookUser);

			}
			rs.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int updatebook(String Quantity, int bookId) {
		int i = 0;
		String query = "update addbook set Quantity=? where id=?";
		try {
			Connection connection = BookUserDAO.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, Quantity);
			ps.setInt(2, bookId);
			i = ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
//public static void main(String[] args) {
//	List<BookUser> bookList=BookUserDAO.fetchAllBooks();
//	for(BookUser bookUser:bookList)
//	{
//		
//		System.out.println(bookUser.getQuantity());
//	
//	}
//}
}
