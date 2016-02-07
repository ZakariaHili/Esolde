package com.HILI.ESolde.metier;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.entities.Commentaire;
import com.HILI.ESolde.entities.Filiale;
import com.HILI.ESolde.entities.Magasin;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Representant_magasin;
import com.HILI.ESolde.entities.User;
import com.HILI.ESolde.entities.Utilisateur;

public interface InternauteMetier {
	
	
	
	
	public List<Produits> listProduit();
	public Produits getProduit(int idProdt);
	public List<Produits> listlastProduitOrderByCat();
	
	public List<Categorie> listCategories();
	public Categorie getCategorie(int idCat);
	
	
	public List<Magasin> listMagasin();
	public Magasin getMagasin(int idMagasin);
	public List<Filiale> listFiliale(int idMagasin);
	public List<Object []> Joint_MagasinFiliale();
	public Filiale getFiliale(int idFiliale);
	public int AjouterFiliale(Filiale p,int idMagasin);
	
	public Promotion getPromotion(int idPromotion);
	public List<Promotion> PromotionParDate(Date date1,Date date2);
	public List<Promotion> PromotionParRepresentant_magasin(int idRepresentant);
	public List<Promotion> PromotionParProduit(int p);
	public List<Object []> Joint_PormotionProduits();
	public List<Promotion> ListPromotion();
	public List<Produits> produitsParMotCle(String mc);
	public List<Produits> ProduitsAvance(Map<String, String> map,String s);
	public List<Produits> getProduitparCat(int idCat);
	public List<Produits> listProduitlowCost();
	public Representant_magasin getRepresentant_Magasin(int idRepresentant);
	
	public int AjouterUtilisateur(Utilisateur user);
	public int AjouterRepresentant_Magasin(Representant_magasin representant);
	public List<User> getUserbyName(String Name);
	public int AjouterCommentaire(Commentaire c);
	public List<Commentaire> CommentaireParProduit(int idProdt);
	public int CountCommentaires(int idProdt);
}
