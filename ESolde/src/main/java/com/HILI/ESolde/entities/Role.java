package com.HILI.ESolde.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
public class Role {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_role;
	@OneToOne
	@JoinColumn(name="id_user")
	private User user;
	
	private String Role;

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(User user, String role) {
		super();
		this.user = user;
		Role = role;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public User getId_user() {
		return user;
	}

	public void setId_user(User user) {
		this.user =user;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	
}
