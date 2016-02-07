package com.HILI.ESolde.metier;



import com.HILI.ESolde.entities.Administrateur;
import com.HILI.ESolde.entities.Equipe_ESolde;

public interface AdministrateurMetier extends Equipe_ESoldeMetier {

	
	public int AjoutEquipe_ESolde(Equipe_ESolde equipe);
	public void SupprimerEquipe_ESolde(int idEquipe);

	public void ModifierAdministrateur(Administrateur A);
}
