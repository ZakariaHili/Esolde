package com.HILI.ESolde.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;





@SuppressWarnings("serial")
@Entity
public class Utilisateur extends User implements  Serializable{

	
	
	private Date Date_Naissance;
	
	@ManyToOne
	@JoinColumn(name="Id_Subscribe")
	private Subscribe subscribe;
	
	
	
	

	public Utilisateur (){
		super();
		super.setRoles(new Role(this,"ROLE_USER"));	
	}
	
	
	public Utilisateur(String login, String password, String nom,
			String prenom, String email) {
		super(login, password, nom, prenom, email);
		super.setRoles(new Role(this,"ROLE_USER"));	
	}


	public Utilisateur(String login, String password, String nom,
			String prenom, String email, Date date_Naissance) {
		super(login, password, nom, prenom, email);
		Date_Naissance = date_Naissance;
		super.setRoles(new Role(this,"ROLE_USER"));	
	}

	
	


	public Date getDate_Naissance() {
		return Date_Naissance;
	}


	public void setDate_Naissance(Date date_Naissance) {
		Date_Naissance = date_Naissance;
	}


	public Subscribe getSubscribe() {
		return subscribe;
	}


	public void setSubscribe(Subscribe subscribe) {
		this.subscribe = subscribe;
	}


	
	
	
	
}
