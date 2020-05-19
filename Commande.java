/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velo.Entity;

import java.sql.Date;

/**
 *
 * @author mouhamedahed
 */
public class Commande {
    private int id;
private Accessoire idproduit;
private int user;
private Date datecom;
private double prixtotale;
private int valide=0;

    public Commande() {
    }

    public Commande(int id, Accessoire idproduit, int user, Date datecom, double prixtotale) {
        this.id = id;
        this.idproduit = idproduit;
        this.user = user;
        this.datecom = datecom;
        this.prixtotale = prixtotale;
    }

    public Commande(Accessoire idproduit, int user, Date datecom, double prixtotale) {
        this.idproduit = idproduit;
        this.user = user;
        this.datecom = datecom;
        this.prixtotale = prixtotale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Accessoire getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Accessoire idproduit) {
        this.idproduit = idproduit;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Date getDatecom() {
        return datecom;
    }

    public void setDatecom(Date datecom) {
        this.datecom = datecom;
    }

    public double getPrixtotale() {
        return prixtotale;
    }

    public void setPrixtotale(double prixtotale) {
        this.prixtotale = prixtotale;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", idproduit=" + idproduit + ", user=" + user + ", datecom=" + datecom + ", prixtotale=" + prixtotale + ", valide=" + valide + '}';
    }

    
}
