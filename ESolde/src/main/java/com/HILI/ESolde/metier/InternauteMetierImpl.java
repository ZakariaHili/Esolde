package com.HILI.ESolde.metier;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.HILI.ESolde.Dao.EsoldeDao;
import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.entities.Commentaire;
import com.HILI.ESolde.entities.Filiale;
import com.HILI.ESolde.entities.Magasin;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Representant_magasin;
import com.HILI.ESolde.entities.User;
import com.HILI.ESolde.entities.Utilisateur;

@Component
@Transactional
public class InternauteMetierImpl implements InternauteMetier {
	
	
protected EsoldeDao dao;
	
	public void setDao(EsoldeDao dao) {
	this.dao = dao;
	}
	
	
	@Override
	public List<Produits> listProduit() {
		return dao.listProduit();
	}

	@Override
	public Produits getProduit(int idProdt) {
		return dao.getProduit(idProdt);
	}

	
	@Override
	public List<Magasin> listMagasin() {
		return dao.listMagasin();
	}

	@Override
	public List<Filiale> listFiliale(int idMagasin) {
		return dao.listFiliale(idMagasin);
	}
	@Override
	public Filiale getFiliale(int idFiliale) {
		return dao.getFiliale(idFiliale);
	}
	@Override
	public Promotion getPromotion(int idPromotion) {
		return dao.getPromotion(idPromotion);
	}

	@Override
	public List<Promotion> PromotionParDate(Date date1, Date date2) {
		return dao.PromotionParDate(date1, date2);
	}

	@Override
	public List<Promotion> PromotionParRepresentant_magasin(int idRepresentant) {
		return dao.PromotionParRepresentant_magasin(idRepresentant);

	}

	@Override
	public List<Promotion> PromotionParProduit(int p) {
		return dao.PromotionParProduit(p);
	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(int idCat) {
		return dao.getCategorie(idCat);
	}


	@Override
	public List<Object[]> Joint_MagasinFiliale() {
		return dao.Joint_MagasinFiliale();
	}


	@Override
	public List<Object[]> Joint_PormotionProduits() {
		return dao.Joint_PormotionProduits();
	}
	@Override
	public List<Promotion> ListPromotion() {
		return dao.ListPromotion();
				
	}


	@Override
	public List<Produits> produitsParMotCle(String mc) {
			return dao.produitsParMotCle(mc);
	}


	@Override
	public List<Produits> ProduitsAvance(Map<String, String> map,String s) {
		return dao.ProduitsAvance(map,s);
	}


	@Override
	public int AjouterUtilisateur(Utilisateur user) {
		return dao.AjouterUtilisateur(user);
	}


	@Override
	public int AjouterRepresentant_Magasin(Representant_magasin representant) {
		return dao.AjouterRepresentant_Magasin(representant);
	}


	@Override
	public List<User> getUserbyName(String Name) {
		return dao.getUserbyName(Name);
	}
	
	@Override
	public List<Produits> getProduitparCat(int idCat) {
		return dao.getProduitparCat(idCat);
	}


	@Override
	public List<Produits> listlastProduitOrderByCat() {
		return dao.listlastProduitOrderByCat();
	}


	@Override
	public List<Produits> listProduitlowCost() {
		return dao.listProduitlowCost();
	}


	@Override
	public Representant_magasin getRepresentant_Magasin(int idRepresentant) {
		return dao.getRepresentant_Magasin(idRepresentant);
	}


	@Override
	public Magasin getMagasin(int idMagasin) {
		return dao.getMagasin(idMagasin);
	}


	@Override
	public int AjouterFiliale(Filiale p, int idMagasin) {
		return dao.AjouterFiliale(p, idMagasin);
	}


	@Override
	public int AjouterCommentaire(Commentaire c) {
		return dao.AjouterCommentaire(c);
	}


	@Override
	public List<Commentaire> CommentaireParProduit(int idProdt) {
		return dao.CommentaireParProduit(idProdt);
	}


	@Override
	public int CountCommentaires(int idProdt) {
		return dao.CountCommentaires(idProdt);
	}
	
}
