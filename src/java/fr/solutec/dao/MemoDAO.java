/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.dao;

import fr.solutec.model.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author PC
 */
public class MemoDAO {

    public static void insertMemo(String contenu, boolean prive, User user) throws SQLException {
        // String sql = "INSERT INTO person (nom, prenom, login, password) VALUES (" + user.getNom() + ", " + user.getPrenom() + ", " + user.getLogin() + ", " + user.getPassword() + "";
        // A ne pas utiliser -> faille d'injection SQL
        String sql = "INSERT INTO note_rapide (contenu, prive, idperson) VALUES (?, ?, ?)";

        Connection connexion = AccessBD.getConnection();

        PreparedStatement requete = connexion.prepareStatement(sql);
        requete.setString(1, contenu);
        requete.setBoolean(2, prive);
        requete.setInt(3, UserDao.getIdByLogin(user.getLogin()));

        requete.execute();

    }

    public static List<Memo> getAllMemoPrive(User u) throws SQLException {
        List<Memo> noteRapidePrive = new ArrayList();

        String sql = "SELECT * FROM note_rapide n INNER JOIN person p ON n.idperson = p.idperson WHERE n.idperson = ?";

        Connection connection = AccessBD.getConnection();
        PreparedStatement prepare = connection.prepareStatement(sql);
        prepare.setInt(1, UserDao.getIdByLogin(u.getLogin()));

        ResultSet rs = prepare.executeQuery();

        while (rs.next()) {
            Memo m = new Memo();
            m.setId(rs.getInt("id"));
            m.setContenu(rs.getString("contenu"));
            m.setDateCreation(rs.getDate("date_creation"));
            m.setPrive(rs.getBoolean("prive"));

            User user = new User();
            user.setId(rs.getInt("idperson"));
            user.setNom(rs.getString("nom"));
            user.setPrenom(rs.getString("prenom"));
            user.setLogin(rs.getString("login"));
            
            m.setCreateur(user);
            noteRapidePrive.add(m);
        }

        return noteRapidePrive;
    }

    
        public static List<Memo> getAllMemoPublic(User u) throws SQLException {
        List<Memo> noteRapidePublic = new ArrayList();

        String sql = "SELECT * FROM note_rapide n INNER JOIN person p ON n.idperson = p.idperson WHERE n.prive = 0";

        Connection connection = AccessBD.getConnection();
        PreparedStatement prepare = connection.prepareStatement(sql);

        ResultSet rs = prepare.executeQuery();

        while (rs.next()) {
            Memo m = new Memo();
            m.setId(rs.getInt("id"));
            m.setContenu(rs.getString("contenu"));
            m.setDateCreation(rs.getDate("date_creation"));
            m.setPrive(rs.getBoolean("prive"));

            User user = new User();
            user.setId(rs.getInt("idperson"));
            user.setNom(rs.getString("nom"));
            user.setPrenom(rs.getString("prenom"));
            user.setLogin(rs.getString("login"));
            
            m.setCreateur(user);
            noteRapidePublic.add(m);
        }

        return noteRapidePublic;
    }
}
