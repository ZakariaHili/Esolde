package com.HILI.ESolde.entities;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Equipe_ESolde extends User {

	@OneToMany(mappedBy="equipe")
	private List<Messages> messages;






	public Equipe_ESolde(){
		messages= new LinkedList <Messages>();
		super.setRoles(new Role(this,"ROLE_EQUIPE"));
	}


	public Equipe_ESolde(String login, String password, String nom,
			String prenom, String email) {
		super(login, password, nom, prenom, email);
		messages= new LinkedList <Messages>();
		super.setRoles(new Role(this,"ROLE_EQUIPE"));
	}


	public List<Messages> getMessages() {
		return messages;
	}


	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}


}
