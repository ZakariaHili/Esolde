package com.HILI.ESolde.Dao;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.HILI.ESolde.entities.*;


public class EsoldeDaoImpl implements EsoldeDao{
		
	
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public int AjouterCategorie(Categorie c) {
		em.persist(c);
		return c.getId_categorie();
	}

	@Override
	public void ModifierCategorie(Categorie c) {
		
		em.merge(c);
		
	}

	@Override
	public void SupprimerCategorie(int idCat) {
		
		Categorie c=em.find(Categorie.class, idCat);
		em.remove(c);
		
	}

	@Override
	public List<Categorie> listCategories() {
		
		Query req=em.createQuery("select c from Categorie c");
		return req.getResultList();
		
		
	}

	@Override
	public Categorie getCategorie(int idCat) {
		return em.find(Categorie.class, idCat);
		
	
	}

	@Override
	public int AjouterProduit(Produits p, int idCat) {
		Categorie c=getCategorie(idCat);
		p.setCategorie(c);
		em.persist(p);
		return p.getId_Produit();
	}

	@Override
	public void ModifierProduit(Produits p) {
		em.merge(p);
		
	}

	@Override
	public void SupprimerProduit(int idProdt) {
		Produits p=em.find(Produits.class, idProdt);
		em.remove(p);
		
	}

	@Override
	public List<Produits> listProduit() {

		Query req=em.createQuery("select p from Produits p");
		return req.getResultList();

		
	}

	@Override
	public Produits getProduit(int idProdt) {
		return em.find(Produits.class, idProdt);
		
	}
	
	@Override
	public List<Produits> produitsParMotCle(String mc) {
		Query req=em.createQuery("from Promotion p where "
				+ "upper (p.produits.Description) like upper( :x) or upper( p.produits.Marque ) like upper( :x )"
				+ " and p.Date_debut_promotion < NOW() and p.Date_Fin_Promotion > NOW() ORDER BY p.Id_Promotion DESC");
				req.setParameter("x", "%"+mc+"%");
				return req.getResultList();
	}
	
	@Override
	public int AjouterCommentaire(Commentaire c) {
		em.persist(c);
		return c.getId_Commentaire();
	}

	@Override
	public void SupprimerCommentaire(int idComment) {
		Commentaire c=em.find(Commentaire.class, idComment );
		em.remove(c);
	}

	@Override
	public List<Commentaire> CommentaireParUtilisateur(int idUser) {
		Query req=em.createQuery("select c from Commentaire c where c.produits.Id_utilisateur=:x");
		req.setParameter("x",idUser );
		return req.getResultList();
		
	}
	@Override
	public List<Commentaire> CommentaireParProduit(int idProdt) {
		Query req=em.createQuery("select c from Commentaire c where c.produits.Id_Produit=:x");
		req.setParameter("x",idProdt );
		return req.getResultList();
		
	}
	@Override
	public Commentaire getCommentaire(int idComment) {
		return em.find(Commentaire.class,idComment);
	}

	@Override
	public int AjoutEquipe_ESolde(Equipe_ESolde equipe) {
		
		em.persist(equipe);
		return equipe.getId_user();
	}

	@Override
	public void ModifierEquipe_ESolde(Equipe_ESolde equipe) {
		em.merge(equipe);
		
	}

	@Override
	public void SupprimerEquipe_ESolde(int idEquipe) {
		Equipe_ESolde equipe= em.find(Equipe_ESolde.class, idEquipe);
		em.remove(equipe);
		
	}

	@Override
	public List<Equipe_ESolde> listEquipe_ESolde() {
		Query req = em.createQuery("select u from user u,equipe_esolde e where u.id_user=e.id_user");
		return req.getResultList();
	}

	@Override
	public int AjouterFiliale(Filiale p, int idMagasin) {
		Magasin m = getMagasin(idMagasin);
		p.setMagasin(m);
		em.persist(p);
		return p.getId_Filiale();
	}

	@Override
	public void ModifierFiliale(Filiale p) {
		em.merge(p);
		
	}

	@Override
	public List<Filiale> listFiliale(int idMagasin) {
	Query req = em.createQuery("select f from Filiale f where f.magasin.Id_Magasin=:x");
	req.setParameter("x", idMagasin);
	
		return req.getResultList();
	}

	@Override
	public Filiale getFiliale(int idFiliale) {
		 return em.find(Filiale.class, idFiliale);

	
	}
	
	public List<Object []> Joint_MagasinFiliale(){
		Query req =em.createQuery("from filiale as f,Magasin as m where f.Id_Magasin= m.Id_Magasin");
		return req.getResultList();
	}

	@Override
	public int AjouterMagasin(Magasin m) {
		em.persist(m);
		return m.getId_Magasin();
	}

	@Override
	public void ModifierMagasin(Magasin m) {
		em.merge(m);
		
	}

	@Override
	public List<Magasin> listMagasin() {
		Query req = em.createQuery("select m from  Magasin m");
		return req.getResultList();
	}

	@Override
	public Magasin getMagasin(int idMagasin) {
		
		return em.find(Magasin.class, idMagasin);
	}

	@Override
	public int AjouterMessage(Messages m) {
		em.persist(m);
		return m.getId_Message();
	}

	@Override
	public Messages getMessage(int idMessage) {
		return em.find(Messages.class, idMessage);
	}

	@Override
	public List<Messages> MessagesParRepresentant(int idRepresentant) {
		Query req = em.createQuery("select m from Messages m where m.Id_representant=:x");
		req.setParameter("x", idRepresentant);
		return req.getResultList();
	}

	@Override
	public List<Messages> MessagesParEquipe_ESolde(int idEquipe) {
		Query req = em.createQuery("select m from Messages m where m.Id_Equipe=:x");
		req.setParameter("x", idEquipe);
		return req.getResultList();
	}

	@Override
	public int AjouterNotation(Notation n) {
		em.persist(n);
		return n.getId_Notation();
	}

	@Override
	public Notation getNotation(int idNotation) {
		return em.find(Notation.class, idNotation);
	}

	@Override
	public int AjouterPromotion(Promotion p) {
		em.persist(p);
		return p.getId_Promotion();
	}

	@Override
	public void ModifierPromotion(Promotion p) {
	em.merge(p);
		
	}

	@Override
	public Promotion getPromotion(int idPromotion) {
		return em.find(Promotion.class, idPromotion);
	}

	@Override
	public List<Promotion> PromotionParDate(Date date1, Date date2) {
		Query req = em.createQuery("select p from Promotion p where p.Date_debut_promotion < :x and p.Date_Fin_Promotion > :y");
		req.setParameter("x", date1);
		req.setParameter("y", date2);
		return req.getResultList();
	}
	
	@Override
	public List<Promotion> ListPromotion() {
		Query req = em.createQuery("select p from Promotion p where p.Date_debut_promotion < NOW() and p.Date_Fin_Promotion > NOW()");
		
		return req.getResultList();
	}
	
	@Override
	public List<Promotion> PromotionParRepresentant_magasin(int idRepresentant) {
		Query req = em.createQuery("select p from Promotion p where p.Id_representant = :x AND p.Date_debut_promotion < NOW() and p.Date_Fin_Promotion > NOW()");
		req.setParameter("x", idRepresentant);
		
		return req.getResultList();
	}

	@Override
	public List<Promotion> PromotionParProduit(int p) {
		Query req = em.createQuery("select * from Promotion where Id_Produit = :x");
		req.setParameter("x", p);
		
		return req.getResultList();
	}

	@Override
	public List<Object[]> Joint_PormotionProduits() {
	Query req =em.createQuery("select p from Produits  p,Promotion m where m.Id_Produit=p.Id_Produit");
	/*	Query req =em.createQuery("from Produits  p LEFT JOIN FETCH p.Promotion LEFT JOIN FETCH p.Categorie"
				+ " where  m.Date_debut_promotion"
					+ " <NOW() and m.Date_Fin_Promotion > NOW() and p.Id_categorie=c.Id_categorie");
		              */
		return req.getResultList();
	}
	
	
	@Override
	public int AjouterRepresentant_Magasin(Representant_magasin representant) {
		em.persist(representant);
		return representant.getId_user();
	}

	@Override
	public void ModifierRepresentant_Magasin(Representant_magasin representant) {
		em.merge(representant);
		
	}

	@Override
	public List<Representant_magasin> listRepresentant_magasin() {
		Query req = em.createQuery("select r  from Representant_magasin r");
		return req.getResultList();
	}

	@Override
	public Representant_magasin getRepresentant_Magasin(int idRepresentant) {
		return em.find(Representant_magasin.class,idRepresentant);
	}

	@Override
	public int AjouterSubscribe(Subscribe s) {
		em.persist(s);
		return s.getId_Subscribe();
	}

	@Override
	public void SupprimerSubscribe(int idSubscribe) {
		Subscribe s=getSubscribe(idSubscribe);
		em.remove(s);
		
	}

	@Override
	public Subscribe getSubscribe(int idSubscribe) {
		return em.find(Subscribe.class,idSubscribe);
	}

	@Override
	public int AjouterUtilisateur(Utilisateur user) {
		em.persist(user);
		return user.getId_user();
	}

	@Override
	public void ModifierUtilisateur(Utilisateur user) {
		em.merge(user);
		
	}

	@Override
	public Utilisateur getUtilisateur(int idUser) {
		return em.find(Utilisateur.class,idUser);
		
	}

	@Override
	public List<Utilisateur> listUtilisateur() {
	Query req = em.createQuery("select u from Utilisateur u");
	return req.getResultList();
	}

	@Override
	public void ModifierAdministrateur(Administrateur A) {
		em.merge(A);
		
	}

	@Override
	public List<Produits> ProduitsAvance(Map<String, String> map, String s) {
		//Query req=em.createQuery();
		String q=s;
			
				int i=0;
				//req.setParameter("x", "%"+mc+"%");
		for (Entry<String, String> m : map.entrySet()){
			if(m.getKey().equals("produit")==true){
				if(i==1) {q=q+" and ";}
				else i=1;
				q=q+" (upper (p.produits.Description) like upper('%"+ m.getValue()+"%') or upper( p.produits.Marque ) like upper( '%"+m.getValue()+"%' ) )";
				
			}
			else{
				if(m.getKey().equals("Magasin")==true){
					if(i==1) {q=q+" and ";}
					else i=1;
					q=q+" p.representant_magasin.id_user= f.representant_du_magasin.id_user and f.magasin.Id_Magasin=m.Id_Magasin and m.Id_Magasin='"+  m.getValue()+"' ";
					
					
				}
				else if (m.getKey().equals("Categorie")==true){
					if(i==1) {q=q+" and ";}
					else i=1;
				q=q+" p.produits.categorie.Id_categorie= c.Id_categorie and c.Id_categorie='"+m.getValue() +"' ";
				}
				else if(m.getKey().equals("Prix")==true){
					if(i==1) {q=q+" and ";}
					else i=1;
					q=q+"  p.Prix_Solde<='"+ m.getValue() +"' ";
					
				}
				
			}
		}
		q=q+ " and p.Date_debut_promotion < NOW() and p.Date_Fin_Promotion > NOW() ORDER BY p.Id_Promotion DESC";
		
		Query req = em.createQuery(q);	
		return req.getResultList();
	}

	@Override
	public List<User> getUserbyName(String Name) {
		Query req = em.createQuery("select u  from User u where Login=:x ");
		req.setParameter("x", Name);
		return req.getResultList();
	}

	@Override
	public List<Produits> listlastProduit() {
		Query req = em.createQuery("select p from promotion p order by p.produit.Id_Produit DESC");
		
		return req.getResultList();
	}

	@Override
	public List<Produits> getProduitparCat(int idCat) {
		Query req = em.createQuery("select p  from Produits p where p.categorie.Id_categorie=:x ");
		req.setParameter("x", idCat);
		return req.getResultList();
	}

	@Override
	public List<Produits> listlastProduitOrderByCat() {
		Query req = em.createQuery("select p  from Promotion p Order by p.produits.categorie.Id_categorie ,"
				+ "p.Id_Promotion DESC");
		
		return req.getResultList();
	}

	@Override
	public List<Produits> listProduitlowCost() {
		Query req = em.createQuery("select p  from Promotion p Order by p.procentage DESC ,"
				+ "p.Id_Promotion DESC");
		
		return req.getResultList();
	}

	@Override
	public List<Produits> listProduitParRepresentant(int idRep) {
		Query req = em.createQuery("select p  from Produits p where p.representant_du_magasin.id_user=:x ");
		req.setParameter("x", idRep);
		return req.getResultList();
	}
	
	@Override
	public List<Promotion> listPromotionParRepresentant(int idRep) {
		Query req = em.createQuery("select p  from Promotion p where p.produits.representant_du_magasin.id_user=:x ");
		req.setParameter("x", idRep);
		return req.getResultList();
	}

	@Override
	public Equipe_ESolde getEquipe(int idEquipe) {
	
		return em.find(Equipe_ESolde.class, idEquipe);
	}

	@Override
	public int CountCommentaires(int idProdt) {
		Query req=em.createQuery("select count(*) from Commentaire c where c.produits.Id_Produit=:x ");
		req.setParameter("x", idProdt);
		return req.getFirstResult();
	}
	
	
}
