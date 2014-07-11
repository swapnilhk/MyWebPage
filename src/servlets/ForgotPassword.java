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

public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher rd = null;
			try{
				String username = request.getParameter("username");
				if(username != null){
				HttpSession session = request.getSession();
				session.setAttribute("username", username);				
				DBConnection con = new DBConnection();
				ResultSet rs = con.executeQuery("SELECT secret_question_id FROM followers WHERE username = '"+username+"'");
				if(rs.next() == true){				
					rs = con.executeQuery("SELECT question FROM secret_questions WHERE secret_question_id = "+rs.getString("secret_question_id"));
					rs.next();
					request.setAttribute("question", rs.getString("question"));
					rd = request.getRequestDispatcher("pages/ForgotPasswordQuestion.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("message", "Username not found");
					rd = request.getRequestDispatcher("pages/Error.jsp");
					rd.forward(request, response);
				}
			} else {
				HttpSession session = request.getSession(false);
				if(session != null && session.getAttribute("username") != null){
					if(request.getParameter("answer") != null) {
						String answer = request.getParameter("answer");
						DBConnection con = new DBConnection();				
						ResultSet rs = con.executeQuery("SELECT DES_DECRYPT(answer) as answer FROM followers WHERE username = '"+session.getAttribute("username")+"'");
						rs.next();				
						if(answer.equalsIgnoreCase(rs.getString("answer"))){					
							rd = request.getRequestDispatcher("pages/ChangePassword.jsp");
							rd.forward(request, response);
						} else {
							request.setAttribute("message", "Your answer does not match");
							rd = request.getRequestDispatcher("pages/Error.jsp");
							rd.forward(request, response);
						}				
					} else {
						String password = request.getParameter("newPassword");
						DBConnection con = new DBConnection();
						con.executeUpdate("UPDATE followers SET password = DES_ENCRYPT('"+password+"') WHERE username = '"+session.getAttribute("username")+"'");
						request.setAttribute("username", session.getAttribute("username"));
						request.setAttribute("password", password);						
						session.invalidate();
						rd = request.getRequestDispatcher("login");
						rd.forward(request, response);
					}
				} else {
					request.setAttribute("message", "Session Expired");
					rd = request.getRequestDispatcher("pages/Error.jsp");
					rd.forward(request, response);
				}
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
