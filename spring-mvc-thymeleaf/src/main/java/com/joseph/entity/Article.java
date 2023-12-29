package com.joseph.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "libelle")
    private String libelle;

   /* @OneToMany(mappedBy = "article")
    private List<CommandArticle> commandArticles;*/

    // Getter and Setter methods
    
    private double prix;
    
    private int quantite;

	public Article() {
	
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Article(String libelle, double prix, int quantite) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.quantite = quantite;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", quantite=" + quantite + "]";
	}
	

   // @OneToMany(mappedBy = "article")
    //private List<CommandArticle> commandArticles;

    //@ManyToMany(mappedBy = "article")
   // private List<CommandArticle> commandes;
    
}

