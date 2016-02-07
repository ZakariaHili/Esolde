package com.HILI.ESolde.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@SuppressWarnings("serial")
@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id_user;

	@Column(unique=true)
	protected String Login;

	@OneToMany(mappedBy="user")
	private List<Commentaire> commentaire;
	
	@OneToMany(mappedBy="utilisateur")
	private List<Notation> notation;
	
	protected String Password;


	protected String Nom;


	protected String Prenom;


	protected String Email;

	protected boolean activated;


	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	protected Role roles;



	public User() {
		super();
		activated=false;

	}
	public User(String login, String password, String nom, String prenom,
			String email) {
		super();
		Login = login;
		Password = password;
		Nom = nom;
		Prenom = prenom;
		Email = email;
		activated=true;

	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Role getRoles() {
		return roles;
	}
	public void setRoles(Role roles) {
		this.roles = roles;
	}

	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}


}
