
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Administrateur extends Utilisateur {

    public Administrateur(String mdp, String l) {
        super(mdp, l);
    }
    
    public Administrateur() {
    	super();
    }
    
    
    public ResultSet afficheLivres(Connection con) {
        String requete = "SELECT * FROM Livre";
        ResultSet rs=null;
        try {
        	Statement state = con.createStatement();
        	rs = state.executeQuery(requete);
         
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        return rs;
    }
    
    public ResultSet afficheLivresAuteur(Connection con, String auteur) {
        String requete = "SELECT * FROM Livre where auteur = ?";
        ResultSet rs=null;
        try {
        	PreparedStatement pst = con.prepareStatement(requete);
        	pst.setString(1,auteur);
        	rs = pst.executeQuery();
         
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        return rs;
    }
    
    public int supprimerLivres(Connection con, String isbn) {
    	int rowsAffected=-1;
        String requete = "DELETE FROM LIVRE WHERE isbn=?";
        try (PreparedStatement pstmt = con.prepareStatement(requete)) {
            pstmt.setString(1, isbn);
            rowsAffected = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Opération non effectuée");
        }
        return rowsAffected;
    }
    
    public boolean verifierAdmin(Connection con, String login, String pwd) {
        boolean found = false;
        String requete = "SELECT * FROM administrateur WHERE motDePasse = ? AND login = ?";
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }
    

}









