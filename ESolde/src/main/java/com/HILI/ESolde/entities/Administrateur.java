package com.HILI.ESolde.entities;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@SuppressWarnings("serial")
@Entity
public class Administrateur extends Equipe_ESolde implements Serializable {
	



		//@OneToMany(mappedBy="administrateur")
		@OneToMany
		//@JoinColumn(name="Id_Administrateur")
		private List<Equipe_ESolde> equipe;
		
		public Administrateur() {
			super();
			super.setRoles(new Role(this,"ROLE_ADMIN"));
			equipe = new LinkedList<Equipe_ESolde>();
		}
		
		public Administrateur( String login, String password, String nom,
				String prenom, String email) {
			
			super(login,  password,  nom,
					 prenom,  email);
			super.setRoles(new Role(this,"Admin"));	
			equipe = new LinkedList<Equipe_ESolde>();
		}

		public List<Equipe_ESolde> getEquipe() {
			return equipe;
		}

		public void setEquipe(LinkedList<Equipe_ESolde> equipe) {
			this.equipe = equipe;
		}
		
	

}
