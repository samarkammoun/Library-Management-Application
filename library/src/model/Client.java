package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client extends Utilisateur{
	private String listeLivres;
	
	public Client(String mdp, String l) {
		super(mdp, l);
		listeLivres = new String();
	}
	
	public Client() {
		
	}
	
	public String commanderLivre(Connection con, String isbn) {
	    String selectQuery = "SELECT quantité FROM livre WHERE isbn=?";
	    String updateQuery = "UPDATE livre SET quantité=quantité-1 WHERE isbn=?";
	    String result=null;
	    try (PreparedStatement selectStmt = con.prepareStatement(selectQuery)) {
	        selectStmt.setString(1, isbn);
	        try (ResultSet rs = selectStmt.executeQuery()) {
	            if (rs.next()) {
	                int qte = rs.getInt("quantité");
	                if (qte > 0) {
	                    try (PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {
	                        updateStmt.setString(1, isbn);
	                        int rowsAffected = updateStmt.executeUpdate();
	                        if (rowsAffected > 0) {
	                            result="Livre Commandé avec succés!";
	                            listeLivres = listeLivres+isbn+",";
	                        } else {
	                            result="Aucun livre trouvé avec l'ISBN spécifié introuvable.";
	                        }
	                    }
	                } else {
	                	result="Le livre n'est plus en stock :( ";
	                }
	            } else {
	                result="Aucun livre trouvé avec l'ISBN spécifié.";
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	   return result;
	}
	
	public String getListeLivres() {
		return listeLivres;
	}
	
	 
	
    public boolean verifierClient(Connection con , String login , String pwd){
    	boolean found=false;
    	String requete="SELECT * FROM client WHERE motDePasse = ? AND login = ?";
    	try {
    		PreparedStatement pst = con.prepareStatement(requete);
    		pst.setString(1, pwd);
    		pst.setString(2, login);
    		ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                found = true;
            }
            rs.close();
            pst.close();
    	}	
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    		
    return found;
    }
    

  
}


	






