package loginservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoogleLogin extends HttpServlet {
	
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean loginSuccess = false;
		String name = req.getParameter("username");
		
		System.out.println(name);
		
		if (name.equals("stanrost@msn.com")){
			loginSuccess= true;
		}
		else{ loginSuccess = false;}
		
		RequestDispatcher rd = null;
		if (loginSuccess)
			rd = req.getRequestDispatcher("google.com");
			
		else
			rd = req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
}
}