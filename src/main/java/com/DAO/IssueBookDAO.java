package com.DAO;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DTO.BookUser;
import com.DTO.IssueBookDTO;
import com.DTO.User;

public class IssueBookDAO {
public static Connection getConnection()
{
	Connection connection=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_project","root","4093");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return connection;
}
public static IssueBookDTO getBookById(int id)
{
	IssueBookDTO issueBookDTO=new IssueBookDTO();
	String query="select * from issuebooks where id=?";
	try {
		Connection connection=IssueBookDAO.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		ResultSet rs=preparedStatement.executeQuery();
		while(rs.next())
		{
			issueBookDTO.setId(rs.getInt(1));
			issueBookDTO.setUserBookQuantity(rs.getString(2));
		}
		connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return issueBookDTO;
}

public static int insetIssueBookData(IssueBookDTO issueBookDTO) {
	int i=0;
	BookUser bookUser=null;
	User user = null;
	String query="insert into issuebooks(sid,bookid,bookimg,studentname,bookName,authorname,edition,userbooks,status,issueDate,returnDate) values(?,?,?,?,?,?,?,?,?,?,?)";
	try {
		Connection connection=IssueBookDAO.getConnection();
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setInt(1, issueBookDTO.getSid());
		ps.setInt(2, issueBookDTO.getBookid());
		ps.setString(3, issueBookDTO.getBook());
		ps.setString(4, issueBookDTO.getStudentName());
		ps.setString(5, issueBookDTO.getBookName());
		ps.setString(6, issueBookDTO.getAuthor());
		ps.setString(7, issueBookDTO.getEdition());
		ps.setString(8, issueBookDTO.getUserBookQuantity());
		ps.setString(9, issueBookDTO.getStatus());
		ps.setString(10, issueBookDTO.getIssueDate());
		ps.setString(11, issueBookDTO.getReturnDate());
		i=ps.executeUpdate();
		connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return i;
}

public static IssueBookDTO fetchSingleUser(int id)
{
  IssueBookDTO issueBookDTO=null;
  String sql="select * from issuebooks where id=?";
  try {
	Connection conn=IssueBookDAO.getConnection();
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setInt(1, id);
	  ResultSet rs=ps.executeQuery();
	  while(rs.next())
	  {
		  issueBookDTO=new IssueBookDTO();
		 issueBookDTO.setId(rs.getInt(1));
		 issueBookDTO.setBook(rs.getString(2));
		 issueBookDTO.setStudentName(rs.getString(3));
		 issueBookDTO.setBookName(rs.getString(4));
		 issueBookDTO.setAuthor(rs.getString(5));
		 issueBookDTO.setEdition(rs.getString(6));
		 issueBookDTO.setUserBookQuantity(rs.getString(7));
		 issueBookDTO.setStatus(rs.getString(8));
		 issueBookDTO.setIssueDate(rs.getString(9));
		 issueBookDTO.setReturnDate(rs.getString(10));
		 
	  }
	  conn.close();
} catch (Exception e) {
	e.printStackTrace();
}
return issueBookDTO;	
}

public static int updateBook(IssueBookDTO issueBookDTO) throws SQLException{
    int i = 0;
    String query = "UPDATE issuebooks SET status=?, returnDate=?, userbooks=? WHERE id=?";
  
        Connection connection = IssueBookDAO.getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, issueBookDTO.getStatus());
        ps.setString(2, issueBookDTO.getReturnDate());
        ps.setString(3, issueBookDTO.getUserBookQuantity());
        ps.setInt(4, issueBookDTO.getId());
        i = ps.executeUpdate();
        connection.close();
    return i;
   
}

//Cretating method For Renew Book Updation

public static int renewBook(String issudate,String returndate, int sid) throws SQLException
{
	int i=0;
	String query="update issuebooks set issuedate=?,returnDate=? where id=?";
	Connection connection=IssueBookDAO.getConnection();
	
	PreparedStatement ps=connection.prepareStatement(query);
	ps.setString(1, issudate);
	ps.setString(2, returndate);
	ps.setInt(3, sid);
	i=ps.executeUpdate();
	connection.close();
	return i;
}
public static IssueBookDTO fetchSingleUserForReturnDate(int id)
{
  IssueBookDTO issueBookDTO=null;
  String sql="select returndate from issuebooks where id=?";
  try {
	Connection conn=IssueBookDAO.getConnection();
	PreparedStatement ps=conn.prepareStatement(sql);
	ps.setInt(1, id);
	  ResultSet rs=ps.executeQuery();
	  while(rs.next())
	  {
		  issueBookDTO=new IssueBookDTO();
		 issueBookDTO.setReturnDate(rs.getString(1));
	  }
	  conn.close();
} catch (Exception e) {
	e.printStackTrace();
}
return issueBookDTO;	

}
//
//public static IssueBookDTO fetchAccordingreturndate(int id)
//{
//	IssueBookDTO issueBookDTO=null;
//	String sql="select returndate from issuebooks where id=?";
//	try {
//		Connection con=IssueBookDAO.getConnection();
//		PreparedStatement ps=con.prepareStatement(sql);
//		ps.setInt(1, id);
//		ResultSet rs=ps.executeQuery();
//		while(rs.next())
//		{
//			issueBookDTO=new IssueBookDTO();
//			issueBookDTO.setReturnDate(rs.getString(1));
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return issueBookDTO;
//}
}