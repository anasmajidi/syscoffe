
package com.raven.model;

import javax.swing.Icon;



public class ModelItem {

    public int getId_produit() {
        return id_produit;
    }


    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }


    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

    public double getPrix_vente() {
        return prix_vente;
    }


    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }


    public int getCategorie_id() {
        return categorie_id;
    }


    public void setCategorie_id(int categorie_id) {
        this.categorie_id = categorie_id;
    }

    

    public ModelItem(int id_produit, String designation, Icon image, double prix_vente, int categorie_id) {
        this.id_produit = id_produit;
        this.designation = designation;
        this.image = image;
        this.prix_vente = prix_vente;
        this.categorie_id = categorie_id;
    }
    
    
    private int id_produit;
    private String designation;
    private Icon image ;
    private double prix_vente;
    private int categorie_id;
}
