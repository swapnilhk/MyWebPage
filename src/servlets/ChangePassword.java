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

public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		try{
			HttpSession session = request.getSession(false);
			if(session != null && session.getAttribute("username") != null){
				if(request.getParameter("oldPassword") != null) {
					String oldPassword = request.getParameter("oldPassword");
					DBConnection con = new DBConnection();				
					ResultSet rs = con.executeQuery("SELECT DES_DECRYPT(password) as password FROM followers WHERE username = '"+session.getAttribute("username")+"'");
					rs.next();				
					if(oldPassword.equalsIgnoreCase(rs.getString("password"))){					
						String newPassword = request.getParameter("newPassword");
						con.executeUpdate("UPDATE followers SET password = DES_ENCRYPT('"+newPassword+"') WHERE username = '"+session.getAttribute("username")+"'");
						request.setAttribute("headerMessage", "Your password has been successfully changed.");
						rd = request.getRequestDispatcher("home");
						rd.forward(request, response);
					} else {
						request.setAttribute("errorMessage", "Incorrect Password");
						rd = request.getRequestDispatcher("pages/ChangePassword2.jsp");
						rd.forward(request, response);
					}
				}
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
