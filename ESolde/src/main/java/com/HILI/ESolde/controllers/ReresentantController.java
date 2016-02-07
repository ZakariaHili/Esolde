package com.HILI.ESolde.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;




import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
















import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.HILI.ESolde.HomeController;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Representant_magasin;
import com.HILI.ESolde.metier.Representant_magasinMetier;


@Controller
@RequestMapping(value="/Representant")
public class ReresentantController {
	
	@Autowired  
	@Qualifier("Representant_magasinMetier")
	private Representant_magasinMetier metier;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeR(Locale locale, Model model) {
		
		return "/Representant/home";
	}
	
	
	@RequestMapping(value="/NewProduct")
	public String NewProduct(Model model){
	
		
		model.addAttribute("categories", metier.listCategories());
		
		return "Representant/NewProduct";
	}
	@RequestMapping(value="/SaveProduct")
	public String SaveProduct(@Valid Produits p,Model model,BindingResult bindingResult,MultipartFile file
			,HttpServletRequest request) throws IOException{
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("categories", metier.listCategories());
			return ("Representant/NewProduct") ;
		}
		if(!file.isEmpty())
		{
			BufferedImage bi = ImageIO.read(file.getInputStream());
			p.setImage(file.getBytes());
			
		}	

		if(p.getId_Produit()!=0){ 
			if(file.isEmpty()){
				Produits produit =metier.getProduit(p.getId_Produit());
				p.setImage(produit.getImage());
			}
		
			
		}
		else {
			
		metier.AjouterProduit(p, Integer.parseInt(request.getParameter("categorie")));
		}
		model.addAttribute("categories", metier.listCategories());
		return "Representant/NewProduct";
	}
	
	@RequestMapping(value="/Product")
	public String listProduct(Model model){

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username
			
	      
		model.addAttribute("produits", metier.listProduitParRepresentant(metier.getUserbyName(name).get(0).getId_user()));
		
		return "Representant/Product";
	}
	
	@RequestMapping(value="/Promotion")
	public String listPromotion(Model model){

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
			
	      
		model.addAttribute("promotion", metier.listPromotionParRepresentant(metier.getUserbyName(name).get(0).getId_user()));
		
		return "Representant/Promotion";
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
	
	@RequestMapping(value="/NewPromotion")
	public String NewPromotion(Model model){

		
		model.addAttribute("produits", metier.listProduit());
		model.addAttribute("categories", metier.listCategories());
		
		return "Representant/NewPromotion";
	}
	
	@RequestMapping(value="/SavePromotion")
	public String SavePromotion(Model model
			,HttpServletRequest request) throws IOException, NumberFormatException, ParseException{
		
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	      double x=( Double.parseDouble(request.getParameter("Prix_original"))-
	    		  Double.parseDouble(request.getParameter("Prix_Solde")))/
	    		  Double.parseDouble(request.getParameter("Prix_original"));
	      DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    
	      	Promotion p= new Promotion((Date)formatter.parse(request.getParameter("Date_debut_promotion")),
	    		  (Date)formatter.parse(request.getParameter("Date_Fin_Promotion")),
	    		  Double.parseDouble(request.getParameter("Prix_original")), Double.parseDouble(request.getParameter("Prix_Solde"))
	    		  ,x,metier.getProduit(Integer.valueOf(request.getParameter("SubCat"))),
	    		  metier.getRepresentant_Magasin(metier.getUserbyName(name).get(0).getId_user())
	    		  );
	     
	    
	     
	      metier.AjouterPromotion(p);
		model.addAttribute("produits", metier.listProduit());
		model.addAttribute("categories", metier.listCategories());
		
		return "Representant/NewPromotion";
	}
	
	
	@RequestMapping(value="/Compte")
	public String MonCompte(Model model){

		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
	      
	      
		model.addAttribute("Representant", metier.getRepresentant_Magasin(metier.getUserbyName(name).get(0).getId_user()));
		
		
		return "Representant/Compte";
	}
	@RequestMapping(value="/SaveCompte")
	public String SaveCompte(Model model,HttpServletRequest request){

		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); 
			
	      
		int id=metier.getUserbyName(name).get(0).getId_user();
		Representant_magasin r= metier.getRepresentant_Magasin(id);
		
		if(request.getParameter("Email").isEmpty()!=true)
		r.setEmail(request.getParameter("Email"));
		
		if(request.getParameter("Password").isEmpty()!=true)
		r.setPassword(request.getParameter("Password"));
		
		if(request.getParameter("Num_Tel_representant").isEmpty()!=true)
			r.setNum_Tel_representant(request.getParameter("Num_Tel_representant"));
		if(request.getParameter("Login").isEmpty()!=true)
			r.setLogin(request.getParameter("Login"));
		
	
		
		//name = auth.getName(); 
		//id=metier.getUserbyName(name).get(0).getId_user();
		metier.ModifierRepresentant_Magasin(r);
		
		Authentication req = new UsernamePasswordAuthenticationToken(r.getLogin(), r.getPassword());
	      
	      SecurityContextHolder.getContext().setAuthentication(req);
	     
	      Authentication authentication = new UsernamePasswordAuthenticationToken(r.getLogin(), r.getPassword());
	      SecurityContextHolder.getContext().setAuthentication(authentication);
	      
	      model.addAttribute("Representant", metier.getRepresentant_Magasin(id));
			
		return "/Representant/Compte";
	}
	
}
