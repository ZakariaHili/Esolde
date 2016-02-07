package com.HILI.ESolde.entities;

import java.io.Serializable;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commentaire implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Commentaire;

	private String Body_Commentaire;

	
	private Date date_commentaire=new Date();;
	
	@ManyToOne
	@JoinColumn(name="Id_Produit")
	private Produits produits;
	
	@ManyToOne
	@JoinColumn(name="Id_user")
	private User user;
	
	public Commentaire() {
		super();
		
	}
	
	public Commentaire(String body_Commentaire, Produits produits,
			User utilisateur) {
		super();
		Body_Commentaire = body_Commentaire;
		this.produits = produits;
		this.user = utilisateur;
	}

	public int getId_Commentaire() {
		return Id_Commentaire;
	}

	public void setId_Commentaire(int id_Commentaire) {
		Id_Commentaire = id_Commentaire;
	}

	public String getBody_Commentaire() {
		return Body_Commentaire;
	}

	public void setBody_Commentaire(String body_Commentaire) {
		Body_Commentaire = body_Commentaire;
	}

	public Produits getProduits() {
		return produits;
	}

	public void setProduits(Produits produits) {
		this.produits = produits;
	}

	public User getUtilisateur() {
		return user;
	}

	public void setUtilisateur(User utilisateur) {
		this.user = utilisateur;
	}

	public Date getDate_commentaire() {
		return date_commentaire;
	}

	public void setDate_commentaire(Date date_commentaire) {
		this.date_commentaire = date_commentaire;
	}
	
	
	
}
