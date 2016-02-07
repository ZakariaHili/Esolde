package com.HILI.ESolde.metier;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.entities.Commentaire;
import com.HILI.ESolde.entities.Equipe_ESolde;
import com.HILI.ESolde.entities.Magasin;
import com.HILI.ESolde.entities.Messages;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Utilisateur;



@Component
@Transactional
public class Equipe_ESoldeMetierImpl extends Representant_magasinMetierImpl implements Equipe_ESoldeMetier {
	

	@Override
	public int AjouterCategorie(Categorie c) {
		return dao.AjouterCategorie(c);
	}

	@Override
	public void ModifierCategorie(Categorie c) {
		dao.ModifierCategorie(c);
		
	}

	@Override
	public void SupprimerCategorie(int idCat) {
		dao.SupprimerCategorie(idCat);
		
	}

	@Override
	public List<Commentaire> CommentaireParUtilisateur(int idUser) {
		return dao.CommentaireParUtilisateur(idUser);
	}

	@Override
	public Commentaire getCommentaire(int idComment) {
		return dao.getCommentaire(idComment);
	}

	@Override
	public void ModifierEquipe_ESolde(Equipe_ESolde equipe) {
		dao.ModifierEquipe_ESolde(equipe);
		
	}

	@Override
	public List<Equipe_ESolde> listEquipe_ESolde() {
		return dao.listEquipe_ESolde();
	}

	@Override
	public int AjouterMagasin(Magasin m) {
		return dao.AjouterMagasin(m);
	}

	@Override
	public void ModifierMagasin(Magasin m) {
		dao.ModifierMagasin(m);
		
	}

	@Override
	public Magasin getMagasin(int idMagasin) {
		return dao.getMagasin(idMagasin);
	}

	@Override
	public List<Messages> MessagesParEquipe_ESolde(int idEquipe) {
		return dao.MessagesParEquipe_ESolde(idEquipe);
	}

	@Override
	public Utilisateur getUtilisateur(int idUser) {
		return dao.getUtilisateur(idUser);
	}

	@Override
	public Equipe_ESolde getEquipe(int idEquipe) {
		return dao.getEquipe(idEquipe);
	}
	@Override
	public List<Promotion> ListPromotion(){
		return dao.ListPromotion();
	}
	@Override
	public List<Magasin> listMagasin() {
		return dao.listMagasin();
	}
	@Override
	public int AjouterPromotion(Promotion p) {
		return dao.AjouterPromotion(p);
	}
	@Override
	public int AjouterProduit(Produits p, int idCat) {
		return dao.AjouterProduit(p, idCat);
	}
}
