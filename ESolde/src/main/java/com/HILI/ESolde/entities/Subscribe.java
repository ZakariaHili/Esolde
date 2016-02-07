package com.HILI.ESolde.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
public class Subscribe implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id_Subscribe;

	private Date Date_Subscribe;
	
	@OneToMany
	//@JoinColumn(name="Id_Subscribe")
	private List<Filiale> filiale;
	
	@ManyToOne
	@JoinColumn(name="Id_utilisateur")
	private Utilisateur utilisateur;

	
	public Subscribe() {
		super();
	
	}
	
	
	public Subscribe(int id_Subscribe, Date date_Subscribe,
			LinkedList<Filiale> filiale, Utilisateur utilisateur) {
		super();
		Id_Subscribe = id_Subscribe;
		Date_Subscribe = date_Subscribe;
		this.filiale = filiale;
		this.utilisateur = utilisateur;
	}

	public int getId_Subscribe() {
		return Id_Subscribe;
	}

	public void setId_Subscribe(int id_Subscribe) {
		Id_Subscribe = id_Subscribe;
	}

	public Date getDate_Subscribe() {
		return Date_Subscribe;
	}

	public void setDate_Subscribe(Date date_Subscribe) {
		Date_Subscribe = date_Subscribe;
	}

	public List<Filiale> getFiliale() {
		return filiale;
	}

	public void setFiliale(LinkedList<Filiale> filiale) {
		this.filiale = filiale;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
