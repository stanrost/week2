package loginservlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import domain.User;



public class LoginController {
	
	
	private User u;
	
	
	

	public User getObject() throws IOException, ClassNotFoundException{
		
		/*User u = new User("Stan", "Stan");
		
		FileOutputStream fout = new FileOutputStream("Object.properties");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(u);
		oos.close();
		*/
		// hier staat de file C:\Users\stan\Documents\informatica\blok 4\server\eclipse
		FileInputStream fin = new FileInputStream("Object.properties");
		   ObjectInputStream ois = new ObjectInputStream(fin);
		  u = ( User) ois.readObject();
		   ois.close();
		   System.out.println(u.getGebruikersnaam());
		   return u;
		
	}
	
	public boolean checkUser(String us, String pass){
		
		if (us.equals(u.getGebruikersnaam()) && pass.equals(u.getPass()) ){
			return true;
		}
		else{
		return false;
		}
	}
}
