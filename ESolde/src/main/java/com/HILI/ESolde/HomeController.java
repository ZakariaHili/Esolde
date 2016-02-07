package com.HILI.ESolde;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.HILI.ESolde.metier.InternauteMetier;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired  
	@Qualifier("InternauteMetier")
	private InternauteMetier metier;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("produits", metier.ListPromotion());
		model.addAttribute("promotion", metier.listlastProduitOrderByCat());
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("magasins", metier.listMagasin());
		model.addAttribute("bas_prix", metier.listProduitlowCost());
		return "index";
	}
	@Controller
	public class LoginController {
		@RequestMapping("/test")
		public void test(HttpServletRequest request){
			System.out.print(request.getContentType());
			  //  System.out.println("\n \n \n \n \n "+name+"\n\n\n\n");
			
		}}
}
