package com.HILI.ESolde.controllers;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.HILI.ESolde.entities.Commentaire;
import com.HILI.ESolde.entities.Filiale;
import com.HILI.ESolde.entities.Produits;
import com.HILI.ESolde.entities.Promotion;
import com.HILI.ESolde.entities.Representant_magasin;
import com.HILI.ESolde.entities.User;
import com.HILI.ESolde.entities.Utilisateur;
import com.HILI.ESolde.metier.InternauteMetier;


@Controller
@RequestMapping(value="/")
public class InternauteController {

	@Autowired  
	@Qualifier("InternauteMetier")
	private InternauteMetier metier;

	@RequestMapping(value="/index")
	public String index(Model model){

		model.addAttribute("produits", metier.ListPromotion());
		model.addAttribute("promotion", metier.listlastProduitOrderByCat());
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("magasins", metier.listMagasin());
		model.addAttribute("bas_prix", metier.listProduitlowCost());
		
		//model.addAttribute("filiales", metier.Joint_MagasinFiliale());
		
		return "index";
	}
	
	 @RequestMapping(value="/log", method = RequestMethod.GET)
	  public String printUser(ModelMap model) {
	 
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username
			
	      System.out.println("\n \n \n \n \n "+metier.getUserbyName(name).get(0).getEmail()+"\n\n\n\n");
	      return "index";
	 
	  }
	
	@RequestMapping("/RechercheAvancee")
	public String someAction(Model model, Map<String, Object> map,
			HttpServletRequest request) {

		if(request.getParameter("produit")!=null){
			String s="select p from Promotion p ";
			Map<String,String> m= new HashMap<String,String>();
			m.put("produit", request.getParameter("produit"));

			if(request.getParameter("magasin").compareTo("0")!=0){
				m.put("Magasin", request.getParameter("magasin"));
				s=s+",Magasin m, Filiale f,Representant_magasin r ";}

			if(request.getParameter("categorie").compareTo("0")!=0){
				m.put("Categorie", request.getParameter("categorie"));
				s=s+",Categorie c ";}

			if(request.getParameter("prix_min")!="")
				m.put("Prix", request.getParameter("prix_min"));


			s=s+" where ";
			model.addAttribute("produits",metier.ProduitsAvance(m,s));
		/*	for (Entry<String, String> m1 : m.entrySet()){
				System.out.println(m1.getKey()+"  "+m1.getValue());

			}     
*/

			return "result";


		}
		return "index";
	}
	
	@RequestMapping(value="/chercher")
	public String search(Model model,HttpServletRequest request){

		if(request.getParameter("produit")!=""){
			
			model.addAttribute("produits", metier.produitsParMotCle(request.getParameter("produit")));
			
			return "result";
			}     
return "index";
	}
		@RequestMapping(value="/rechercheAvancee")
		public String rechercheAvanceeFrom(Model model){

			model.addAttribute("produits", metier.ListPromotion());
			model.addAttribute("categories", metier.listCategories());
			model.addAttribute("magasins", metier.listMagasin());
			
		return "rechercheAvancee";
	}
/***********/
	@RequestMapping(value="/itemname")
	public String test(Model model){

		model.addAttribute("produits", metier.listProduit());
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("magasins", metier.listMagasin());
		//model.addAttribute("filiales", metier.Joint_MagasinFiliale());
		return "itemname";
	}
	
	@RequestMapping(value="/search_bar")
	public String search_bar(Model model){

		model.addAttribute("produits", metier.listProduit());
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("magasins", metier.listMagasin());
		//model.addAttribute("filiales", metier.Joint_MagasinFiliale());
		return "search_bar";
	}
	
	
	@RequestMapping(value="/NewUser")
	public String newuser(Model model){

		return "NewUser";
	}
	
	/**
	 * @throws ParseException ******************/
	@RequestMapping(value="/registerUser")
	public String RegisterUser(Model model,HttpServletRequest request) throws ParseException{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Utilisateur user= new Utilisateur (request.getParameter("Login"),request.getParameter("Password"),
				request.getParameter("Nom"),request.getParameter("Prenom"),request.getParameter("Email"),
				(Date)formatter.parse(request.getParameter("Date")));
		if(metier.AjouterUtilisateur(user)!=0) 
		return "index";
		else return "NewUser";
	}
	@RequestMapping(value="/NewRepresentant")
	public String NewRepresentant(Model model){
		model.addAttribute("magasins", metier.listMagasin());
		model.addAttribute("filiale", metier.listFiliale(1));
		return "NewRepresentant";
	}
	
	
	@RequestMapping(value="/registerRepresentant")
	public String RegisterRepresentant(Model model,MultipartFile file
			,HttpServletRequest request) throws IOException{
		
		Representant_magasin user= new Representant_magasin (request.getParameter("Login"),request.getParameter("Password"),
				request.getParameter("Nom"),request.getParameter("Prenom"),request.getParameter("Email"),
				request.getParameter("tel"));
		
		int id=metier.AjouterRepresentant_Magasin(user);
		if(id!=0){ 
		Filiale f= new Filiale(request.getParameter("filiale"),request.getParameter("Adresse_Filiale"),
				request.getParameter("Num_Tel_Filiale"),request.getParameter("Web_Site"),
				metier.getRepresentant_Magasin(id),
				metier.getMagasin(Integer.parseInt(request.getParameter("magasin"))));
		
		if(!file.isEmpty())
		{
			BufferedImage bi = ImageIO.read(file.getInputStream());
			f.setLogo_Filiale(file.getBytes());
			
		}	
			metier.AjouterFiliale(f,Integer.parseInt(request.getParameter("magasin")));
			return "index";}
		else return "NewRepresentant";
	
	}
	
	@RequestMapping(value="/photoProd",produces=MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] getPhoto(int  idProdt) throws IOException{
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
	
	
	
	@RequestMapping(value="/404")
	public String Error404(Model model){

	
		
		return "404";
	}
	
	
@RequestMapping(value="ProductDetails")
	
	public  String ProductDetails(@RequestParam("idProd")int idProd,Model model){
	
		Promotion p=metier.getPromotion(idProd);
		model.addAttribute("prod",p);
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("idProd", idProd);
		model.addAttribute("commentaires", metier.CommentaireParProduit(metier.getPromotion(idProd).getProduits().getId_Produit()));
		
		model.addAttribute("count", metier.CountCommentaires( idProd));
		return "ProductDetails";
	}



@RequestMapping(value="saveComment")

public  String saveComment(Model model,HttpServletRequest request){
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
     String name = auth.getName();
     User u=metier.getUserbyName(name).get(0);
	Commentaire c= new Commentaire(request.getParameter("Body_Commentaire"), 
			metier.getPromotion(Integer.parseInt(request.getParameter("idprod"))).getProduits(),
			u);
	Promotion p=metier.getPromotion(Integer.parseInt(request.getParameter("idprod")));
	metier.AjouterCommentaire(c);
	model.addAttribute("prod",p);
	model.addAttribute("categories", metier.listCategories());
	model.addAttribute("idProd", request.getParameter("idprod"));
	model.addAttribute("commentaires", metier.CommentaireParProduit(metier.getPromotion(Integer.parseInt(request.getParameter("idprod"))).getProduits().getId_Produit()));
	model.addAttribute("count", metier.CountCommentaires( Integer.parseInt(request.getParameter("idprod"))));
	
	return "ProductDetails";
}
@RequestMapping(value="contact-us")

public  String contact_us(Model model){
	
	return "contact-us";
}	
}