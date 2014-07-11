package servlets;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBConnection;

public class Home extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static ArrayList<String> followerUsernames = new ArrayList<String>();
	static ArrayList<String> followers = new ArrayList<String>();
	static ArrayList<String> fontFamily = new ArrayList<String>();
	static ArrayList<String> fontColor = new ArrayList<String>();
	
	public void init(ServletConfig config) throws ServletException{
		try{
			DBConnection con = new DBConnection();
			ResultSet rs = con.executeQuery("SELECT username, full_name, font_family, font_color FROM followers ORDER BY full_Name");
			while(rs.next()){
				followerUsernames.add(rs.getString("username"));
				followers.add(rs.getString("full_name"));
				fontFamily.add(rs.getString("font_family"));
				fontColor.add(rs.getString("font_color"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("followerUsernames", followerUsernames);
		request.setAttribute("followers", followers);
		request.setAttribute("fontFamily", fontFamily);
		request.setAttribute("fontColor", fontColor);
		RequestDispatcher rd = request.getRequestDispatcher("/pages/Home.jsp");
		rd.forward(request, response);			
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}