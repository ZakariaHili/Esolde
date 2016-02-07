package com.HILI.ESolde.metier;

import java.util.Date;
import java.util.List;

import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.entities.Commentaire;
import com.HILI.ESolde.entities.Filiale;
import com.HILI.ESolde.entities.Magasin;
import com.HILI.ESolde.entities.Notation;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Subscribe;
import com.HILI.ESolde.entities.Utilisateur;

public interface UtilisateurMetier extends InternauteMetier{
	
	
	public int AjouterCommentaire(Commentaire c);
	public void SupprimerCommentaire(int idComment);
	public List<Commentaire> CommentaireParProduit(int idProdt);
	
	
	public int AjouterNotation(Notation n);
	public Notation getNotation(int idNotation);
	
	
	public int AjouterSubscribe(Subscribe s);
	public void SupprimerSubscribe(int idSubscribe);
	public Subscribe getSubscribe(int idSubscribe);
	
	public void ModifierUtilisateur(Utilisateur user);
	public Utilisateur getUtilisateur(int idUser);
}
