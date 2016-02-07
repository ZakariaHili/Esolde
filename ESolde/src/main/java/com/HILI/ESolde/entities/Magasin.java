package com.HILI.ESolde.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Magasin implements Serializable{
		
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Magasin;

	private String Slogan;
	@Lob
	private byte[] Logo;

	private String Direction;

	private String Frome_juridique;
	private double Chiffre_affaire;
	private Date Date_creation;
	
	@OneToMany(mappedBy="magasin",fetch = FetchType.EAGER)
	private List <Filiale> filiale;
	
public Magasin (){
		
		
		filiale= new LinkedList <Filiale>();
	}
	
	public Magasin (String Slogan, String Direction,String Frome_juridique,double Chiffre_affaire, Date Date_creation){
		
		
		this.Slogan=Slogan;
		
		this.Direction=Direction;
		this.Frome_juridique=Frome_juridique;
		this.Chiffre_affaire=Chiffre_affaire;
		this.Date_creation=Date_creation;
		filiale= new LinkedList <Filiale>();
	}

	public int getId_Magasin() {
		return Id_Magasin;
	}

	public void setId_Magasin(int id_Magasin) {
		Id_Magasin = id_Magasin;
	}

	public String getSlogan() {
		return Slogan;
	}

	public void setSlogan(String slogan) {
		Slogan = slogan;
	}

	public byte[] getLogo() {
		return Logo;
	}

	public void setLogo(byte[] logo) {
		Logo = logo;
	}

	public String getDirection() {
		return Direction;
	}

	public void setDirection(String direction) {
		Direction = direction;
	}

	public String getFrome_juridique() {
		return Frome_juridique;
	}

	public void setFrome_juridique(String frome_juridique) {
		Frome_juridique = frome_juridique;
	}

	public double getChiffre_affaire() {
		return Chiffre_affaire;
	}

	public void setChiffre_affaire(double chiffre_affaire) {
		Chiffre_affaire = chiffre_affaire;
	}

	public Date getDate_creation() {
		return Date_creation;
	}

	public void setDate_creation(Date date_creation) {
		Date_creation = date_creation;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Filiale> getFiliale() {
		return filiale;
	}

	public void setFiliale(LinkedList <Filiale> filiale) {
		this.filiale = filiale;
	}
	public int filialecount(){
		return this.filiale.size();
	}

}
