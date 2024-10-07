/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.woe.projettp1;

/**
 * Classe qui lit des fichiers
*/
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe qui lit les informations du ficher pour connecter a base de données
 * @author Augusto ARROJO et Fernando ROJAS
*/
public class DatabaseConfig {
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private String dbDriver;

    /**
     * Constructeur par default de la classe DatabaseConfig  
    */
    public DatabaseConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db_config.properties")) {
            if (input == null) {
                System.out.println("Desculpe, não foi possível encontrar o arquivo db_config.properties");
            } else {
                //System.out.println("Arquivo 'db_config.properties' carregado com sucesso");
                // Carregar o arquivo de propriedades
                Properties properties = new Properties();
                properties.load(input);

                // Atribuir valores das propriedades
                this.dbUrl = properties.getProperty("db.url");
                this.dbUser = properties.getProperty("db.user");
                this.dbPassword = properties.getProperty("db.password");
                this.dbDriver = properties.getProperty("db.driver");

                // Carregar driver JDBC do PostgreSQL
                Class.forName(dbDriver);
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Méthode pour obtenir le Database URL
     * @return Database URL
    */
    public String getDbUrl () {
        return dbUrl;
    }
    
    /**
     * Méthode pour obtenir le Database User
     * @return Database User
    */
    public String getDbUser() {
        return dbUser;
    }
    
    /**
     * Méthode pour obtenir le Database mot de passe
     * @return Database mot de passe
    */
    public String getDbPassword() {
        return dbPassword;
    }
}
