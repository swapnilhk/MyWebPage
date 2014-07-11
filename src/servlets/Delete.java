package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBConnection;

public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		try{
			HttpSession session = request.getSession(false);
			if(session != null && session.getAttribute("username") != null){
				String username = (String)session.getAttribute("username");
				DBConnection con = new DBConnection();				
				int i = con.executeUpdate("DELETE FROM followers WHERE username = '"+username+"'");
				if(i == 0)
					request.setAttribute("headerMessage", "Unable to remove your name. Please try later.");
				else{
					session.invalidate();
					synchronized (Home.followerUsernames) {
						int index = Home.followerUsernames.indexOf(username);
						Home.followerUsernames.remove(index);
						Home.followers.remove(index);
						Home.fontFamily.remove(index);
						Home.fontColor.remove(index);						
					}
					request.setAttribute("headerMessage", "Your name has been removed.");
				}
				rd = request.getRequestDispatcher("home");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "Session Expired");
				rd = request.getRequestDispatcher("pages/Error.jsp");
				rd.forward(request, response);
			}
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