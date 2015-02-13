package loginservlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

public class EmailLogin extends HttpServlet {
	
	
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
		if (loginSuccess == true){
		
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
	 
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("jometdebanjo1234@gmail.com", "jo1234!@#$");
				}
			  });
	 
			try {
	 
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("jometdebanjo1234@gmail.com"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("stanrost@msn.com"));
				message.setSubject("Testing Subject");
				message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!");
	 
				Transport.send(message);
	 
				System.out.println("Done");
	 
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			rd = req.getRequestDispatcher("index.html");
		}
		else
			rd = req.getRequestDispatcher("login.html");
		rd.forward(req, resp);
	}


	
}
