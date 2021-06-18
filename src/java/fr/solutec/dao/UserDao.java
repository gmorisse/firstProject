/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;
import fr.solutec.model.*;
import java.sql.*;
import java.util.Set;
/**
 *
 * @author PC
 */
public class UserDao {
    
    public static void insertUser(User user) throws SQLException{
        // String sql = "INSERT INTO person (nom, prenom, login, password) VALUES (" + user.getNom() + ", " + user.getPrenom() + ", " + user.getLogin() + ", " + user.getPassword() + "";
        // A ne pas utiliser -> faille d'injection SQL
        String sql = "INSERT INTO person (nom, prenom, login, password) VALUES (?, ?, ?, ?)";
        
        Connection connexion = AccessBD.getConnection();
        
        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, user.getNom());
        requete.setString(2, user.getPrenom());
        requete.setString(3, user.getLogin());
        requete.setString(4, user.getPassword());
        
        requete.execute();
        
    }
    
    public static User getByLoginAndPassword(String login, String password) throws SQLException{
    User u = null;
    String sql = "SELECT * FROM person WHERE login=? AND password=?";
    
    Connection connexion = AccessBD.getConnection();
    
    PreparedStatement requete = connexion.prepareStatement(sql);
    requete.setString(1, login);
    requete.setString(2, password);
    
    ResultSet rs = requete.executeQuery();
    
        if (rs.next()) {
            u = new User();
            u.setId(rs.getInt("idperson"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setLogin(rs.getString("login"));
        }
    
    return u;
    }
    
    public static int getIdByLogin(String login) throws SQLException{
    User u = null;
    String sql = "SELECT * FROM person WHERE login=?";
    
    Connection connexion = AccessBD.getConnection();
    
    PreparedStatement requete = connexion.prepareStatement(sql);
    requete.setString(1, login);
    
    ResultSet rs = requete.executeQuery();
    
        if (rs.next()) {
            u = new User();
            u.setId(rs.getInt("idperson"));
            u.setNom(rs.getString("nom"));
            u.setPrenom(rs.getString("prenom"));
            u.setLogin(rs.getString("login"));
        }
    
    return u.getId();
    }
    
}
