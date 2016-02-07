package com.HILI.ESolde.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

















import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.HILI.ESolde.HomeController;
import com.HILI.ESolde.entities.Categorie;
import com.HILI.ESolde.entities.Equipe_ESolde;
import com.HILI.ESolde.entities.Magasin;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Representant_magasin;
import com.HILI.ESolde.metier.Equipe_ESoldeMetier;
import com.HILI.ESolde.metier.Representant_magasinMetier;
@Controller
@RequestMapping(value="/Equipe")
public class EquipeController {
	
	@Autowired  
	@Qualifier("Equipe_ESoldeMetier")
	private Equipe_ESoldeMetier metier;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeE(Locale locale, Model model) {
		
		return "/Equipe/home";
	}
	
	@RequestMapping(value="/photoProd",produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] getPhoto(int idProdt) throws IOException{
		Produits c=metier.getProduit(idProdt);
		if(c.getImage()==null) return new byte[0];
		else {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(c.getImage()));
			BufferedImage thumbnail = Scalr.resize(image, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
					 268, 249 , Scalr.OP_ANTIALIAS);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( thumbnail, "png", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;}
	}
	
	@RequestMapping(value="/Product")
	public String listProduct(Model model){

		
	      
		model.addAttribute("produits", metier.listProduit());
		
		return "/Equipe/Product";
	}
	
	@RequestMapping(value="/Promotion")
	public String listPromotion(Model model){

	
	      
		model.addAttribute("promotion", metier.ListPromotion());
		
		return "/Equipe/Promotion";
	}
	
	@RequestMapping(value="/Compte")
	public String MonCompte(Model model){

		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
	      
	     
		model.addAttribute("Representant", metier.getEquipe(metier.getUserbyName(name).get(0).getId_user()));
		
		
		return "/Equipe/Compte";
	}
	@RequestMapping(value="/SaveCompte")
	public String SaveCompte(Model model,HttpServletRequest request){

		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
			
	      
		int id=metier.getUserbyName(name).get(0).getId_user();
		Equipe_ESolde r= metier.getEquipe(id);
		
		if(request.getParameter("Email").isEmpty()!=true)
		r.setEmail(request.getParameter("Email"));
		
		if(request.getParameter("Password").isEmpty()!=true)
		r.setPassword(request.getParameter("Password"));
		
		
		if(request.getParameter("Login").isEmpty()!=true)
			r.setLogin(request.getParameter("Login"));
		
	
		
		//name = auth.getName(); 
		//id=metier.getUserbyName(name).get(0).getId_user();
		metier.ModifierEquipe_ESolde(r);
		
		Authentication req = new UsernamePasswordAuthenticationToken(r.getLogin(), r.getPassword());
	      
	      SecurityContextHolder.getContext().setAuthentication(req);
	     
	      Authentication authentication = new UsernamePasswordAuthenticationToken(r.getLogin(), r.getPassword());
	      SecurityContextHolder.getContext().setAuthentication(authentication);
	      
	      model.addAttribute("Representant", metier.getEquipe(id));
			
		return "/Equipe/Compte";
	}
	
	@RequestMapping(value="/Categorie")
	public String listCategorie(Model model){
		model.addAttribute("categorie", metier.listCategories());
		
		return "/Equipe/Categorie";
	}
	@RequestMapping(value="/Magasin")
	public String listMagasin(Model model){
		model.addAttribute("magasin", metier.listMagasin());
		
		return "/Equipe/Magasin";
	}
	@RequestMapping(value="/photoMag",produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] getMag(int idMag) throws IOException{
		Magasin c=metier.getMagasin(idMag);
		if(c.getLogo()==null) return new byte[0];
		else {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(c.getLogo()));
			BufferedImage thumbnail = Scalr.resize(image, Scalr.Method.SPEED, Scalr.Mode.FIT_TO_WIDTH,
					 268, 249 , Scalr.OP_ANTIALIAS);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( thumbnail, "png", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return imageInByte;}
	}
	
	@RequestMapping(value="/Representant")
	public String listRepresentant(Model model){
		model.addAttribute("representant", metier.listRepresentant_magasin());
		
		return "/Equipe/Representant";
	}
	@RequestMapping(value="/Utilisateur")
	public String listUtilisateur(Model model){
		model.addAttribute("utilisateur", metier.listUtilisateur());
		
		return "/Equipe/Utilisateur";
	}
	
	@RequestMapping(value="/NewCategorie")
	public String NewCategorie(Model model){
		
		
		return "/Equipe/NewCategorie";
	}
	
	@RequestMapping(value="/SaveCategorie")
	public String SavePromotion(Model model
			,HttpServletRequest request) throws IOException, NumberFormatException, ParseException{
		
		 
	      	Categorie p= new Categorie(request.getParameter("Categorie"));
	    		 
	     
	    
	     
	      metier.AjouterCategorie(p);
		
		
		return "/Equipe/NewCategorie";
	}
	
	@RequestMapping(value="/NewMagasin")
	public String NewMagasin(Model model){
		
		
		return "/Equipe/NewMagasin";
	}
	
	@RequestMapping(value="/SaveMagasin")
	public String SaveMagasin(MultipartFile file
			,HttpServletRequest request) throws IOException, NumberFormatException, ParseException{
		 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 
		Magasin p= new Magasin(request.getParameter("Slogan"),request.getParameter("Direction")
				,request.getParameter("Frome_juridique"), Double.parseDouble(request.getParameter("Chiffre_affaire")),
				(Date)formatter.parse(request.getParameter("Date_creation")));
		
		if(!file.isEmpty())
		{
			BufferedImage bi = ImageIO.read(file.getInputStream());
			p.setLogo(file.getBytes());
			
		}	

		
			
		metier.AjouterMagasin(p);
		
		
		return "/Equipe/NewMagasin";
	}
}
