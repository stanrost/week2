package domain;

import java.io.Serializable;


public class User implements  Serializable{
	private String gebruikersnaam;
	private String pass;
	
	public User(String ge, String pa){
		gebruikersnaam = ge;
		pass = pa;
	}
	public String getGebruikersnaam() {
		return gebruikersnaam;
	}

	public void setGebruikersnaam(String gebruikersnaam) {
		this.gebruikersnaam = gebruikersnaam;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	
	
	
	
	
	
}

