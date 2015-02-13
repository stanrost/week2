package loginservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;



public class LogServlet extends HttpServlet {
		
		
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			
		}
		
		
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			boolean loginSuccess = false;
			String name = req.getParameter("username");
			String pass = req.getParameter("password");
			
			LoginController lc = new LoginController();
			
			User u;
			
			try {
				u  = lc.getObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			if (lc.checkUser(name, pass)){
					loginSuccess = true;
					}
			else{ 
				loginSuccess = false;
				}
			
			
			RequestDispatcher rd = null;
			if (loginSuccess)
				rd = req.getRequestDispatcher("rest/secret/");
				
			else
				rd = req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}
	

}


