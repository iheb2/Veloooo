/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.velo.Entity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author mouhamedahed
 */
public class Accessoire {
        private static int id_courant ;





       private int id;
    private String name;
    private int quantite;
    private Double price;
    private String description;
    private String modele;
    private String image;
    public Accessoire(int id, String name, int quantite, Double price, String description, String modele, String image) {
        this.id = id;
        this.name = name;
        this.quantite = quantite;
        this.price = price;
        this.description = description;
        this.modele = modele;
        this.image = image;
    }
 

    public Accessoire(String name, int quantite, Double price, String description, String modele, String image) {
        this.name = name;
        this.quantite = quantite;
        this.price = price;
        this.description = description;
        this.modele = modele;
        this.image = image;
    }

    public Accessoire() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Accessoire{" + "id=" + id + ", name=" + name + ", quantite=" + quantite + ", price=" + price + ", description=" + description + ", modele=" + modele + ", image=" + image + '}';
    }
        public static int getId_courant() {
        return id_courant;
    }

    public static void setId_courant(int id_courant) {
        Accessoire.id_courant = id_courant;
    }
    
        public static ObservableList<Accessoire> getPanier() {
        return Panier;
    }

    public static void setPanier(ObservableList<Accessoire> Panier) {
        Accessoire.Panier = Panier;
    }

  public static ObservableList<Accessoire> Panier = FXCollections.observableArrayList();  
  public static class getPanier {

        public getPanier() {
        }
    }

     public static boolean setPanier(Accessoire P) {
        Boolean Test=true;
        
    	for (int i = 0; i < Panier.size(); i++) {
        if(Panier.get(i).getId()==P.getId())
        {
                    Test=false;
                        Panier.get(i).setQuantite(Panier.get(i).getQuantite()+1);
                        P.setQuantite(P.getQuantite()+1);
                      //  System.out.println( Panier.get(i));
                     
        }
		}
       if(Test==true)
            {
             P.setQuantite(P.getQuantite()+1);
           Panier.add(P);
           
            }
     return Test;
    }
 
  
}
