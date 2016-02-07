package com.HILI.ESolde.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;







import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.HILI.ESolde.entities.User;
@Controller
public class LoginController {
	@RequestMapping("/login")
	public String login(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();;
		    System.out.println("\n \n \n \n \n "+name+"\n\n\n\n");
		return "login";
	}
	@RequestMapping("/log")
	public String log(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();;
		    System.out.println("\n \n \n \n \n "+auth.getPrincipal()+"\n\n\n\n");
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Login ou mot de passe est invalide");
		}
	   
		model.setViewName("login");

		return model;

	}
	
	
	@RequestMapping(value="/some_page.htm")
	   public String somePage (HttpServletRequest request, HttpServletResponse response) {
	        /* some business logic code */
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      if (auth != null){    
	         new SecurityContextLogoutHandler().logout(request, response, auth);
	         new PersistentTokenBasedRememberMeServices(null, null, null).logout(request, response, auth);
	      }
		return null;
	   }
}