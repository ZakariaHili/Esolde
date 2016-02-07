package com.HILI.ESolde.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Notation implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Notation;

	private int Valeur_Notation;
	
	@ManyToOne
	@JoinColumn(name="Id_Produit")
	private Produits produits;
	
	@ManyToOne
	@JoinColumn(name="Id_user")
	private User utilisateur;

	
	public Notation() {
		super();
	;
	}
	
	public Notation(int valeur_Notation, Produits produits,
			User utilisateur) {
		super();
		Valeur_Notation = valeur_Notation;
		this.produits = produits;
		this.utilisateur = utilisateur;
	}

	public int getId_Notation() {
		return Id_Notation;
	}

	public void setId_Notation(int id_Notation) {
		Id_Notation = id_Notation;
	}

	public int getValeur_Notation() {
		return Valeur_Notation;
	}

	public void setValeur_Notation(int valeur_Notation) {
		Valeur_Notation = valeur_Notation;
	}

	public Produits getProduits() {
		return produits;
	}

	public void setProduits(Produits produits) {
		this.produits = produits;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

	
}
