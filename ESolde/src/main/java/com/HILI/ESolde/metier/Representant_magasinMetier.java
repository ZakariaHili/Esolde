package com.HILI.ESolde.metier;

import java.util.List;
import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.entities.Filiale;
import com.HILI.ESolde.entities.Messages;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Representant_magasin;
import com.HILI.ESolde.entities.Utilisateur;



public interface Representant_magasinMetier extends UtilisateurMetier{

	
	
	public Categorie getCategorie(int idCat);
	
	public int AjouterProduit(Produits p,int idCat);
	public void ModifierProduit(Produits p);
	public void SupprimerProduit(int idProdt);
	public List<Produits> listProduitParRepresentant(int idRep);
	public List<Promotion> listPromotionParRepresentant(int idRep);
	public int AjouterFiliale(Filiale p,int idMagasin);
	public void ModifierFiliale(Filiale p);
	
	
	public int AjouterMessage(Messages m);
	public Messages getMessage(int idMessage);
	public List<Messages> MessagesParRepresentant(int idRepresentant);
	
	public int AjouterPromotion(Promotion p);
	public void ModifierPromotion(Promotion p);
	
	public void ModifierRepresentant_Magasin(Representant_magasin representant);
	public List<Representant_magasin> listRepresentant_magasin();
	public Representant_magasin getRepresentant_Magasin(int idRepresentant);
	
	public List<Utilisateur> listUtilisateur();
	
	
}
