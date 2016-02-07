package com.HILI.ESolde.Dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.HILI.ESolde.entities.*;

public interface EsoldeDao {
		
	
	
	public int AjouterCategorie(Categorie c);
	public void ModifierCategorie(Categorie c);
	public void SupprimerCategorie(int idCat);
	public List<Categorie> listCategories();
	public Categorie getCategorie(int idCat);
	
	public int AjouterProduit(Produits p,int idCat);
	public void ModifierProduit(Produits p);
	public void SupprimerProduit(int idProdt);
	public List<Produits> listProduit();
	public List<Produits> listProduitParRepresentant(int idRep);
	public Produits getProduit(int idProdt);
	public List<Produits> getProduitparCat(int idCat);
	public List<Produits> produitsParMotCle(String mc);
	public List<Produits> ProduitsAvance(Map <String,String> map,String s);
	public List<Produits> listlastProduit();
	public List<Produits> listlastProduitOrderByCat();
	public List<Produits> listProduitlowCost();
	public List<Promotion> listPromotionParRepresentant(int idRep);
	
	public int AjouterCommentaire(Commentaire c);
	public void SupprimerCommentaire(int idComment);
	public List<Commentaire> CommentaireParUtilisateur(int idUser);
	public List<Commentaire> CommentaireParProduit(int idProdt);
	public Commentaire getCommentaire(int idComment);
	public int CountCommentaires(int idProdt);
	
	public int AjoutEquipe_ESolde(Equipe_ESolde equipe);
	public void ModifierEquipe_ESolde(Equipe_ESolde equipe);
	public void SupprimerEquipe_ESolde(int idEquipe);
	public List<Equipe_ESolde> listEquipe_ESolde();
	public Equipe_ESolde getEquipe(int idEquipe);
	
	
	public int AjouterFiliale(Filiale p,int idMagasin);
	public void ModifierFiliale(Filiale p);
	public List<Filiale> listFiliale(int idMagasin);
	public Filiale getFiliale(int idFiliale);
	public List<Object []> Joint_MagasinFiliale();

	
	
	public int AjouterMagasin(Magasin m);
	public void ModifierMagasin(Magasin m);
	public List<Magasin> listMagasin();
	public Magasin getMagasin(int idMagasin);
	
	public int AjouterMessage(Messages m);
	public Messages getMessage(int idMessage);
	public List<Messages> MessagesParRepresentant(int idRepresentant);
	public List<Messages> MessagesParEquipe_ESolde(int idEquipe);
	
	public int AjouterNotation(Notation n);
	public Notation getNotation(int idNotation);
	
	public int AjouterPromotion(Promotion p);
	public void ModifierPromotion(Promotion p);
	public Promotion getPromotion(int idPromotion);
	public List<Promotion> PromotionParDate(Date date1,Date date2);
	public List<Promotion> PromotionParRepresentant_magasin(int idRepresentant);
	public List<Promotion> PromotionParProduit(int p);
	public List<Object []> Joint_PormotionProduits();
	public List<Promotion> ListPromotion();
	
	public int AjouterRepresentant_Magasin(Representant_magasin representant);
	public void ModifierRepresentant_Magasin(Representant_magasin representant);
	public List<Representant_magasin> listRepresentant_magasin();
	public Representant_magasin getRepresentant_Magasin(int idRepresentant);
	
	public int AjouterSubscribe(Subscribe s);
	public void SupprimerSubscribe(int idSubscribe);
	public Subscribe getSubscribe(int idSubscribe);
	
	public int AjouterUtilisateur(Utilisateur user);
	public void ModifierUtilisateur(Utilisateur user);
	public Utilisateur getUtilisateur(int idUser);
	public List<Utilisateur> listUtilisateur();
	
	public void ModifierAdministrateur(Administrateur A);
	public List<User> getUserbyName(String Name);
	
	
}
