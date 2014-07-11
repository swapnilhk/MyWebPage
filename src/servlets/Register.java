package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBConnection;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		try {
			DBConnection con = new DBConnection();
			ResultSet rs = con.executeQuery("SELECT * FROM secret_questions");
			HashMap<Integer, String> questions = new HashMap<Integer, String>();
			while(rs.next())
				questions.put(rs.getInt("secret_question_id"), rs.getString("question"));				
			request.setAttribute("questions", questions);
			rd = request.getRequestDispatcher("pages/Register.jsp");
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String username = request.getParameter("username2");
		String password = request.getParameter("password2");
		String fullName = request.getParameter("fullName");
		String question = request.getParameter("question");	
		String answer   = request.getParameter("answer");
		try{
			DBConnection con = new DBConnection();
			con.executeUpdate("INSERT INTO followers(username, password, full_name, secret_question_id, answer) VALUES('"+username+"', DES_ENCRYPT('"+password+"'), '"+fullName+"', "+question+", DES_ENCRYPT('"+answer+"'))");		
			
			// Add values to the session variable
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("fullName", fullName);
			session.setAttribute("fontFamily", "Merienda");
			session.setAttribute("fontColor", "#000000");
			
			// Add to the list of followers to be displayed on home page
			synchronized (Home.followerUsernames) {
				Home.followerUsernames.add(username);
				Home.followers.add(fullName);			
				Home.fontFamily.add("Merienda");
				Home.fontColor.add("#000000");
			}			
			request.setAttribute("headerMessage", "Welcome "+fullName);			
			rd = request.getRequestDispatcher("home");
			rd.forward(request, response);
		} catch (SQLException e) {
			if((e.getMessage().substring(0, 15)).equalsIgnoreCase("Duplicate entry")){
				request.setAttribute("headerMessage", "Username already exists!");
				rd = request.getRequestDispatcher("follow");
				rd.forward(request, response);
			}else{				
				request.setAttribute("message", e.getMessage());			
				rd = request.getRequestDispatcher("pages/Error.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) { 
			request.setAttribute("message","Couldn't load JdbcOdbcDriver: "+e.getMessage());
			rd = request.getRequestDispatcher("pages/Error.jsp");
			rd.forward(request, response);
		}
	}

}
