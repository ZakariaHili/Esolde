package com.HILI.ESolde.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Filiale implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Filiale;

	private String Nom_Filiale;
	@Lob
	private byte[] Logo_Filiale;
	

	private String Adresse_Filiale;

	private String Num_Tel_Filiale;

	private String Web_Site;
	
	@ManyToOne
	@JoinColumn(name="Id_representant")
	private Representant_magasin representant_du_magasin;
	
	@ManyToOne
	@JoinColumn(name="Id_Magasin")
	private Magasin magasin;
	
	
	public Filiale (){
		

	}
	public Filiale (String Nom_Filiale,String Adresse_Filiale,String Num_Tel_Filiale,
			String Web_Site,Representant_magasin representant_du_magasin,Magasin magasin){
		
		this.Nom_Filiale=Nom_Filiale;
		this.Logo_Filiale=Logo_Filiale;
		this.Adresse_Filiale=Adresse_Filiale;
		this.Num_Tel_Filiale=Num_Tel_Filiale;
		this.Web_Site=Web_Site;
		this.representant_du_magasin = representant_du_magasin;
		this.magasin=magasin;

	}
	
	
	public int getId_Filiale() {
		return Id_Filiale;
	}


	public void setId_Filiale(int id_Filiale) {
		Id_Filiale = id_Filiale;
	}


	public String getNom_Filiale() {
		return Nom_Filiale;
	}


	public void setNom_Filiale(String nom_Filiale) {
		Nom_Filiale = nom_Filiale;
	}

	
	public byte[] getLogo_Filiale() {
		return Logo_Filiale;
	}


	public void setLogo_Filiale(byte[] logo_Filiale) {
		Logo_Filiale = logo_Filiale;
	}


	public String getAdresse_Filiale() {
		return Adresse_Filiale;
	}


	public void setAdresse_Filiale(String adresse_Filiale) {
		Adresse_Filiale = adresse_Filiale;
	}


	public String getNum_Tel_Filiale() {
		return Num_Tel_Filiale;
	}


	public void setNum_Tel_Filiale(String num_Tel_Filiale) {
		Num_Tel_Filiale = num_Tel_Filiale;
	}


	public String getWeb_Site() {
		return Web_Site;
	}


	public void setWeb_Site(String web_Site) {
		Web_Site = web_Site;
	}


	public Representant_magasin getRepresentant_du_magasin() {
		return representant_du_magasin;
	}


	public void setRepresentant_du_magasin(
			Representant_magasin representant_du_magasin) {
		this.representant_du_magasin = representant_du_magasin;
	}


	public Magasin getMagasin() {
		return magasin;
	}


	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}




}
