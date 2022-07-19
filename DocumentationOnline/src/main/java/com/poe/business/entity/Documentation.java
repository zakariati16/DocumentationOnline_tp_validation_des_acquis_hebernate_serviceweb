
package com.poe.business.entity;

import com.mysql.cj.xdevapi.Client;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

    
@Entity
@Table(name="documentations")

public class Documentation {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    @Id
    private int id;


    private String auteur;
    private String titre;

    private String date;
    

    @ManyToOne
    @JoinColumn (name="categoryId")
    private Category category;

    public Documentation() {
    }

    public Documentation(String auteur, String titre, String date) {
        this.auteur = auteur;
        this.titre = titre;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void setNotNullData(Documentation newDocumentationData){
        if(newDocumentationData.getDate()!= null) {
            this.setDate(newDocumentationData.getDate());
        }
         if(newDocumentationData.getAuteur()!= null) {
            this.setAuteur(newDocumentationData.getAuteur());
        }
         if (newDocumentationData.getTitre()!= null) {
            this.setTitre(newDocumentationData.getTitre());
        }
         if (newDocumentationData.getCategory()!= null) {
            this.setCategory(newDocumentationData.getCategory());
        }
         
        
     }
    

    @Override
    public String toString() {
        return "Documentation{" + "id=" + id + ", auteur=" + auteur + ", titre=" + titre + ", date=" + date + '}';
    }
    

  
}

