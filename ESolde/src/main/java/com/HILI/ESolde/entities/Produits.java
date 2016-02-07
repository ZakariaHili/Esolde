package com.HILI.ESolde.entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;


@Entity
public class Produits implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Produit;

	private String Marque;

	private String Description;
	@Lob
	private byte[] Image;
	@ManyToOne
	@JoinColumn(name="Id_categorie")
	private Categorie categorie;
	
	@OneToMany(mappedBy="produits")
	private List<Commentaire> commentaire;
	@OneToMany(mappedBy="produits")
	private List<Notation> notation;
	@ManyToOne
	@JoinColumn(name="Id_representant")
	private Representant_magasin representant_du_magasin;
	
	
	public Produits() {
		super();
		
		commentaire=new LinkedList<Commentaire>();
		notation=new LinkedList<Notation>();
		
	}
	
	public Produits( String marque, String description,
			byte[] image) {
		super();
		
		Marque = marque;
		Description = description;
		Image = image;
		//this.representant_du_magasin = representant_du_magasin;
		commentaire=new LinkedList<Commentaire>();
		notation=new LinkedList<Notation>();
		
	}

	
	public int getId_Produit() {
		return Id_Produit;
	}

	public void setId_Produit(int id_Produit) {
		Id_Produit = id_Produit;
	}

	public String getMarque() {
		return Marque;
	}

	public void setMarque(String marque) {
		Marque = marque;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public byte[] getImage() {
		return Image;
	}

	public void setImage(byte[] image) {
		Image = image;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Commentaire> getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(LinkedList<Commentaire> commentaire) {
		this.commentaire = commentaire;
	}

	public List<Notation> getNotation() {
		return notation;
	}

	public void setNotation(LinkedList<Notation> notation) {
		this.notation = notation;
	}

	public Representant_magasin getRepresentant_du_magasin() {
		return representant_du_magasin;
	}

	public void setRepresentant_du_magasin(
			Representant_magasin representant_du_magasin) {
		this.representant_du_magasin = representant_du_magasin;
	}

	
}
