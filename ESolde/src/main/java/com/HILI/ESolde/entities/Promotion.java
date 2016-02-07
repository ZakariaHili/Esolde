package com.HILI.ESolde.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Promotion implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Promotion;

	private Date Date_debut_promotion;

	private Date Date_Fin_Promotion;

	private double Prix_original;

	private double Prix_Solde;

	private double procentage;
	
	@ManyToOne
	@JoinColumn(name="Id_Produit")
	private Produits produits;
	
	@ManyToOne
	@JoinColumn(name="Id_representant")
	private Representant_magasin representant_magasin;
	
	
	public Promotion() {
		super();
	
	}
	
	
	public Promotion(Date date_debut_promotion, Date date_Fin_Promotion,
			double prix_original, double prix_Solde, double procentage,
			Produits produits, Representant_magasin representant_magasin) {
		super();
		Date_debut_promotion = date_debut_promotion;
		Date_Fin_Promotion = date_Fin_Promotion;
		Prix_original = prix_original;
		Prix_Solde = prix_Solde;
		this.procentage = procentage;
		this.produits = produits;
		this.representant_magasin = representant_magasin;
	}

	public int getId_Promotion() {
		return Id_Promotion;
	}

	public void setId_Promotion(int id_Promotion) {
		Id_Promotion = id_Promotion;
	}

	public Date getDate_debut_promotion() {
		return Date_debut_promotion;
	}

	public void setDate_debut_promotion(Date date_debut_promotion) {
		Date_debut_promotion = date_debut_promotion;
	}

	public Date getDate_Fin_Promotion() {
		return Date_Fin_Promotion;
	}

	public void setDate_Fin_Promotion(Date date_Fin_Promotion) {
		Date_Fin_Promotion = date_Fin_Promotion;
	}

	public double getPrix_original() {
		return Prix_original;
	}

	public void setPrix_original(double prix_original) {
		Prix_original = prix_original;
	}

	public double getPrix_Solde() {
		return Prix_Solde;
	}

	public void setPrix_Solde(double prix_Solde) {
		Prix_Solde = prix_Solde;
	}

	public double getProcentage() {
		return procentage;
	}

	public void setProcentage(double procentage) {
		this.procentage = procentage;
	}

	public Produits getProduits() {
		return produits;
	}

	public void setProduits(Produits produits) {
		this.produits = produits;
	}

	public Representant_magasin getRepresentant_magasin() {
		return representant_magasin;
	}

	public void setRepresentant_magasin(Representant_magasin representant_magasin) {
		this.representant_magasin = representant_magasin;
	}
	
	
	
}
