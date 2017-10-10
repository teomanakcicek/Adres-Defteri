package com.teomanakcicek.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user="adresDefteri";
		String pass="adresDefteri";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/adresdefteri?useSSL=false";
		
		String driver="com.mysql.jdbc.Driver";
		try {
			PrintWriter out=response.getWriter();
			
			out.println("connecting to database: "+jdbcUrl);
			Class.forName(driver);
			
			Connection conn= DriverManager.getConnection(jdbcUrl,user,pass);
			
			out.print("connection is successful");
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);			
		}
	}

}
