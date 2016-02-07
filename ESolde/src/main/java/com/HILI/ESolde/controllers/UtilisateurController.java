package com.HILI.ESolde.controllers;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Representant_magasin;
import com.HILI.ESolde.entities.Utilisateur;
import com.HILI.ESolde.metier.Representant_magasinMetier;
import com.HILI.ESolde.metier.UtilisateurMetier;


@Controller
@RequestMapping(value="/Utilisateur")
public class UtilisateurController {

	@Autowired  
	@Qualifier("UtilisateurMetier")
	private UtilisateurMetier metier;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeU(Locale locale, Model model) {
		
		return "/Utilisateur/home";
	}
	
	@RequestMapping(value="/Compte")
	public String MonCompte(Model model){

		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
	      
	      
		model.addAttribute("Representant", metier.getUtilisateur(metier.getUserbyName(name).get(0).getId_user()));
		
		
		return "/Utilisateur/Compte";
	}
	@RequestMapping(value="/SaveCompte")
	public String SaveCompte(Model model,HttpServletRequest request) throws ParseException{

		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
			
	      
		int id=metier.getUserbyName(name).get(0).getId_user();
		Utilisateur r= metier.getUtilisateur(id);
		
		if(request.getParameter("Email").isEmpty()!=true)
		r.setEmail(request.getParameter("Email"));
		
		if(request.getParameter("Password").isEmpty()!=true)
		r.setPassword(request.getParameter("Password"));
		
		 DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 
		if(request.getParameter("Date_Naissance").isEmpty()!=true)
			r.setDate_Naissance((Date)formatter.parse(request.getParameter("Date_Naissance")));
		
		if(request.getParameter("Login").isEmpty()!=true)
			r.setLogin(request.getParameter("Login"));
		
	
		
		//name = auth.getName(); 
		//id=metier.getUserbyName(name).get(0).getId_user();
		metier.ModifierUtilisateur(r);
		
		Authentication req = new UsernamePasswordAuthenticationToken(r.getLogin(), r.getPassword());
	      
	      SecurityContextHolder.getContext().setAuthentication(req);
	      model.addAttribute("Representant",  metier.getUtilisateur(id));
			
		return "/Utilisateur/Compte";
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
		
		return "Utilisateur/Product";
	}
	
	@RequestMapping(value="/Promotion")
	public String listPromotion(Model model){

	
	      
		model.addAttribute("promotion", metier.ListPromotion());
		
		return "Utilisateur/Promotion";
	}
}
