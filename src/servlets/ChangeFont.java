package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBConnection;

public class ChangeFont extends HttpServlet {
	private static final long serialVersionUID = 1L;	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("username") == null){
			request.setAttribute("message", "Session Expired");			
			rd = request.getRequestDispatcher("pages/Error.jsp");
			rd.forward(request, response);
		} else{
			String newFontFamily = request.getParameter("fontFamily");			
			String newFontColor = request.getParameter("fontColor");
			String username = (String)session.getAttribute("username");
			// Get index into the RHS list for this user
			int index = Home.followerUsernames.indexOf(session.getAttribute("username"));
			try{			
				if(!newFontFamily.equals((String)session.getAttribute("fontFamily"))){
					DBConnection con = new DBConnection();
					con.executeUpdate("Update followers SET font_family = '"+newFontFamily+"' WHERE username = '"+username+"'");
					session.setAttribute("fontFamily", newFontFamily);
					Home.fontFamily.set(index, newFontFamily);
				}
				if(!newFontColor.equals((String)session.getAttribute("fontColor"))){
					DBConnection con = new DBConnection();
					con.executeUpdate("Update followers SET font_color = '"+newFontColor+"' WHERE username = '"+username+"'");
					session.setAttribute("fontColor", newFontColor);
					Home.fontColor.set(index, newFontColor);
				}
				request.setAttribute("HeaderMessage", "Your changes have been saved.");			
				rd = request.getRequestDispatcher("home");
				rd.forward(request, response);				
			} catch (SQLException e) {
				request.setAttribute("message", e.getMessage());			
				rd = request.getRequestDispatcher("pages/Error.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException e) { 
				request.setAttribute("message","Couldn't load JdbcOdbcDriver: "+e.getMessage());
				rd = request.getRequestDispatcher("pages/Error.jsp");
				rd.forward(request, response);
			}
		}
	}

}
