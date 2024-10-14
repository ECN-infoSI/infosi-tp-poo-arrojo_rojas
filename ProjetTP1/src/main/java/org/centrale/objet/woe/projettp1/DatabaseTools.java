/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package org.centrale.objet.woe.projettp1;
/**
 * Classe chargée d'établir une connexion avec la base de données
*/
import java.sql.Connection;
/**
 *  Classe qui gère la liste des pilotes de base de données disponibles.
*/
import java.sql.DriverManager;
/**
 * Interface utilisée pour exécuter des requêtes SQL précompilées.
*/ 
import java.sql.PreparedStatement;
/**
 * Interface qui représente le résultat d'une requête SQL qui renvoie des données, telle qu'un SELECT.
*/ 
import java.sql.ResultSet;
/** 
 * Interface d'exception qui détecte les erreurs liées aux opérations de base de données.
*/
import java.sql.SQLException;

/**
 * Classe qui gére des requêtes et la connexion avec la base de données
 * @author Augusto ARROJO et Fernando ROJAS
*/
public class DatabaseTools {

    private DatabaseConfig dbConfig;

    public DatabaseTools() {
        // Carregar as configurações do banco de dados
        dbConfig = new DatabaseConfig();
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            // Usar as propriedades carregadas do arquivo
            conn = DriverManager.getConnection(dbConfig.getDbUrl(), dbConfig.getDbUser(), dbConfig.getDbPassword());
            System.out.println("Conectado com sucesso ao banco de dados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
        // Método para buscar o ID do jogador
    public Integer getPlayerID(String nomJoueur, String password) {
        String query = "SELECT idJoueur FROM Joueurs WHERE nom = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(dbConfig.getDbUrl(), dbConfig.getDbUser(), dbConfig.getDbPassword());
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, nomJoueur);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("idJoueur");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
   
}
