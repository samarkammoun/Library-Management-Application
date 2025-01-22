package dao;

import java.sql.Connection;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ToConnect {

    public static void main(String[] args) {

        Properties properties = new Properties();

        try (InputStream input = ToConnect.class.getClassLoader().getResourceAsStream("resources/config.properties")) {
            if (input == null) {
                throw new IOException("config.properties ne se trouve pas dans le dossier resources.");
            }

      
            properties.load(input);

        } catch (IOException e) {
            e.printStackTrace();
            return; 
        }

        String dbUser = properties.getProperty("DB_USERNAME");
        String dbPass = properties.getProperty("DB_PASSWORD");
        String dbUrl = properties.getProperty("DB_URL");

        // Etablir la connexion
        Connection con = Test.connection(dbUrl, dbUser, dbPass);

        if (con != null) {
            System.out.println("Connexion établie avec succées !");
        } else {
            System.out.println("Connexion échouée.");
        }
    }
}
