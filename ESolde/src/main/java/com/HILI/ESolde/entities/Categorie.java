package com.HILI.ESolde.entities;

import java.io.Serializable;
import java.util.LinkedList;





import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_categorie;
	
	private String Description_categorie;
	
	@OneToMany(mappedBy="categorie",fetch = FetchType.EAGER)
	private List<Produits> produits;
	public Categorie() {
		super();
		
	}

	public Categorie( String description_categorie) {
		super();
		
		Description_categorie = description_categorie;
		produits=new LinkedList<Produits> ();
	}

	public int getId_categorie() {
		return Id_categorie;
	}

	public void setId_categorie(int id_categorie) {
		Id_categorie = id_categorie;
	}

	public String getDescription_categorie() {
		return Description_categorie;
	}

	public void setDescription_categorie(String description_categorie) {
		Description_categorie = description_categorie;
	}

	public List<Produits> getProduits() {
		return produits;
	}

	public void setProduits(LinkedList<Produits> produits) {
		this.produits = produits;
	}

	public int produitsCount(){
		return this.produits.size();
	}
	
}
