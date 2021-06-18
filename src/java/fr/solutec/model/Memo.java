/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.solutec.model;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class Memo {

    private int id;
    private String contenu;
    private Date dateCreation;
    private boolean prive;
    private User createur;

    public Memo(int id, String contenu, Date dateCreation, boolean prive, User createur) {
        this.id = id;
        this.contenu = contenu;
        this.dateCreation = dateCreation;
        this.prive = prive;
        this.createur = createur;
    }

    public Memo() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isPrive() {
        return prive;
    }

    public void setPrive(boolean prive) {
        this.prive = prive;
    }

    public User getCreateur() {
        return createur;
    }

    public void setCreateur(User createur) {
        this.createur = createur;
    }
    
    
    
}
