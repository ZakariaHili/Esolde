package com.HILI.ESolde.metier;

import java.util.List;

import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.entities.Commentaire;
import com.HILI.ESolde.entities.Equipe_ESolde;
import com.HILI.ESolde.entities.Magasin;
import com.HILI.ESolde.entities.Messages;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Utilisateur;

public interface Equipe_ESoldeMetier extends Representant_magasinMetier{

	
	public int AjouterCategorie(Categorie c);
	public void ModifierCategorie(Categorie c);
	public void SupprimerCategorie(int idCat);
	
	
	public List<Commentaire> CommentaireParUtilisateur(int idUser);
	public Commentaire getCommentaire(int idComment);
	
	public void ModifierEquipe_ESolde(Equipe_ESolde equipe);
	public List<Equipe_ESolde> listEquipe_ESolde();
	public Equipe_ESolde getEquipe(int idEquipe);
	
	public int AjouterMagasin(Magasin m);
	public void ModifierMagasin(Magasin m);
	public List<Magasin> listMagasin();
	public Magasin getMagasin(int idMagasin);
	
	public List<Promotion> ListPromotion();
	
	public List<Messages> MessagesParEquipe_ESolde(int idEquipe);

	
	public Utilisateur getUtilisateur(int idUser);
	
	
	
}
