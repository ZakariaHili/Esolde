package com.HILI.ESolde.metier;



import java.util.List;












import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.HILI.ESolde.Dao.EsoldeDao;
import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.entities.Filiale;
import com.HILI.ESolde.entities.Messages;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Representant_magasin;
import com.HILI.ESolde.entities.User;
import com.HILI.ESolde.entities.Utilisateur;

@Component
@Transactional
public class Representant_magasinMetierImpl extends UtilisateurMetierImpl implements Representant_magasinMetier  {
	
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
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}


	@Override
	public int AjouterProduit(Produits p, int idCat) {
		return dao.AjouterProduit(p, idCat);
	}

	@Override
	public void ModifierProduit(Produits p) {
		dao.ModifierProduit(p);
		
	}

	@Override
	public void SupprimerProduit(int idProdt) {
		dao.SupprimerProduit(idProdt);
		
	}

	@Override
	public int AjouterFiliale(Filiale p, int idMagasin) {
		return dao.AjouterFiliale(p, idMagasin);
	}

	@Override
	public void ModifierFiliale(Filiale p) {
		dao.ModifierFiliale(p);
		
	}

	

	@Override
	public int AjouterMessage(Messages m) {
		return dao.AjouterMessage(m);
	}

	@Override
	public Messages getMessage(int idMessage) {
		return dao.getMessage(idMessage);
	}

	@Override
	public List<Messages> MessagesParRepresentant(int idRepresentant) {
		return dao.MessagesParRepresentant(idRepresentant);
	}

	@Override
	public int AjouterPromotion(Promotion p) {
		return dao.AjouterPromotion(p);
	}

	@Override
	public void ModifierPromotion(Promotion p) {
		dao.ModifierPromotion(p);
		
	}

	@Override
	public void ModifierRepresentant_Magasin(Representant_magasin representant) {
		dao.ModifierRepresentant_Magasin(representant);
		
	}

	@Override
	public List<Representant_magasin> listRepresentant_magasin() {
		return dao.listRepresentant_magasin();
	}

	@Override
	public Representant_magasin getRepresentant_Magasin(int idRepresentant) {
		return dao.getRepresentant_Magasin(idRepresentant);
	}

	@Override
	public List<Utilisateur> listUtilisateur() {
		return dao.listUtilisateur();
	}
	
	@Override
	public List<User> getUserbyName(String Name) {
		return dao.getUserbyName(Name);
	}
	@Override
	public List<Produits> listProduitParRepresentant(int idRep) {
		return dao.listProduitParRepresentant(idRep);
	}
	@Override
	public List<Promotion> listPromotionParRepresentant(int idRep) {
		return dao.listPromotionParRepresentant(idRep);
	}
}
