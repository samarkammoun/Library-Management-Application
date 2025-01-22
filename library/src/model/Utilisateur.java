package model;
import java.sql.Connection;


public class Utilisateur {
	private String motDePasse;
	private String login;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String mdp, String l) {
		this.motDePasse=mdp;
		this.login=l;
	}
	
	
	public String getMotDepASSE() {
		return motDePasse;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setMotDePasse(String motDePasse) {
		this.motDePasse=motDePasse;
	}
	
	public void setLogin(String login) {
		this.login=login;
	}
	

	
	
}








