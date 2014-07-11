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


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("pages/Login.jsp");
		rd.forward(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		/* When username and password come from login page, they are request parameters (taken from web page);
		 * when they come from change password page, they are attributes (set through code).*/
		String username = request.getParameter("username") != null ? request.getParameter("username") : (String)request.getAttribute("username");
		String password = request.getParameter("password") != null ? request.getParameter("password") : (String)request.getAttribute("password");
		
		try{
			DBConnection con = new DBConnection();
			ResultSet rs = con.executeQuery("SELECT DES_DECRYPT(password) as password, full_name, font_family, font_color FROM followers WHERE username = '"+username+"'");
			
			if(rs.next() && rs.getString("password").equals(password)){				
				// Create session and add attributes
				HttpSession session = request.getSession();				
				session.setAttribute("username", username);
				session.setAttribute("fullName", rs.getString("full_name"));
				session.setAttribute("fontFamily", rs.getString("font_family"));
				session.setAttribute("fontColor", rs.getString("font_color"));
				
				request.setAttribute("headerMessage", "Welcome "+rs.getString("full_name"));			
				rd = request.getRequestDispatcher("home");
				rd.forward(request, response);			
			}
			else{
				request.setAttribute("loginError", "Incorrect username or password");			
				rd = request.getRequestDispatcher("pages/Login.jsp");
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
