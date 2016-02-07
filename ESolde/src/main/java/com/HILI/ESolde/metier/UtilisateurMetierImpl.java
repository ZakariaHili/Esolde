package com.HILI.ESolde.metier;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HILI.ESolde.Dao.EsoldeDao;
import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.entities.Commentaire;
import com.HILI.ESolde.entities.Filiale;
import com.HILI.ESolde.entities.Magasin;
import com.HILI.ESolde.entities.Notation;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Subscribe;
import com.HILI.ESolde.entities.Utilisateur;
@Component
@Transactional
public class UtilisateurMetierImpl extends InternauteMetierImpl implements UtilisateurMetier{

	
	@Override
	public int AjouterCommentaire(Commentaire c) {
		return dao.AjouterCommentaire(c);
	}

	@Override
	public void SupprimerCommentaire(int idComment) {
		dao.SupprimerCommentaire(idComment);
		
	}

	@Override
	public List<Commentaire> CommentaireParProduit(int idProdt) {
		return dao.CommentaireParProduit(idProdt);
	}

	
	@Override
	public int AjouterNotation(Notation n) {
		return dao.AjouterNotation(n);
	}

	@Override
	public Notation getNotation(int idNotation) {
		return dao.getNotation(idNotation);
	}

	@Override
	public int AjouterSubscribe(Subscribe s) {
		return dao.AjouterSubscribe(s);
	}

	@Override
	public void SupprimerSubscribe(int idSubscribe) {
		dao.SupprimerSubscribe(idSubscribe);
		
	}

	@Override
	public Subscribe getSubscribe(int idSubscribe) {
		return dao.getSubscribe(idSubscribe);
	}

	@Override
	public void ModifierUtilisateur(Utilisateur user) {
		dao.ModifierUtilisateur(user);
		
	}

	@Override
	public Utilisateur getUtilisateur(int idUser) {
		return dao.getUtilisateur(idUser);
	}
}
