package com.HILI.ESolde.entities;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@SuppressWarnings("serial")
@Entity
public class Representant_magasin extends User implements Serializable{

	
	
	
	private String Num_Tel_representant;

	
	@OneToMany(mappedBy="representant_magasin")
	private List<Messages> messages;

	@OneToMany(mappedBy="representant_du_magasin",fetch = FetchType.EAGER)
	private List<Filiale> filiale;
	
	@OneToMany(mappedBy="representant_du_magasin")
	private List<Produits> produits;
	

	
	public Representant_magasin() {
		super();
	
		messages=new LinkedList<Messages>();
		filiale=new LinkedList<Filiale>();
		produits=new LinkedList<Produits>();
		super.setRoles(new Role(this,"ROLE_REPRESENTANT"));
	}
	public Representant_magasin(String login, String password, String nom,
			String prenom, String email) {
		super(login, password, nom, prenom, email);
		messages=new LinkedList<Messages>();
		filiale=new LinkedList<Filiale>();
		produits=new LinkedList<Produits>();
		super.setRoles(new Role(this,"ROLE_REPRESENTANT"));
	}
	public Representant_magasin(String login, String password, String nom,
			String prenom, String email,String Num_Tel_representant) {
		super(login, password, nom, prenom, email);
		messages=new LinkedList<Messages>();
		filiale=new LinkedList<Filiale>();
		produits=new LinkedList<Produits>();
		this.Num_Tel_representant=Num_Tel_representant;
		super.setRoles(new Role(this,"ROLE_REPRESENTANT"));
	}
	
	public String getNum_Tel_representant() {
		return Num_Tel_representant;
	}
	public void setNum_Tel_representant(String num_Tel_representant) {
		Num_Tel_representant = num_Tel_representant;
	}
	public List<Messages> getMessages() {
		return messages;
	}
	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}
	public List<Filiale> getFiliale() {
		return filiale;
	}
	public void setFiliale(List<Filiale> filiale) {
		this.filiale = filiale;
	}
	
	public void AddFiliale(Filiale filiale) {
		this.filiale.add(filiale);
	}
	
	public List<Produits> getProduits() {
		return produits;
	}
	public void setProduits(List<Produits> produits) {
		this.produits = produits;
	}
	

	
}