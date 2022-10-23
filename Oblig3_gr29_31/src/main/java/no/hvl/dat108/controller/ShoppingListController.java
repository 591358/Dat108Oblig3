package no.hvl.dat108.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.model.Shoppinglist;
import no.hvl.dat108.util.LoginUtil;

@Controller
@RequestMapping("/${app.url.shoppinglist}")
public class ShoppingListController {
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.shoppinglist}") private String SHOPPINGLIST_URL;
	@Value("${app.message.requiresLogin}") private String REQUIRES_LOGIN;
	
	@Autowired private Shoppinglist shoppingList;
	
	@GetMapping
	public String getShoppinglist(HttpSession session, RedirectAttributes ra) {
		if(!LoginUtil.isUserLoggedIn(session)) {
			ra.addFlashAttribute("redirectMessage",REQUIRES_LOGIN );
			return "redirect:" + LOGIN_URL;
		}
		session.setAttribute("shopping", shoppingList.getShoppinglist());			
	
		return "shoppinglist";
	}
	
	@PostMapping
	public String addAndRemoveFromList(@RequestParam(required=false) String item, HttpSession session, RedirectAttributes ra,
			@RequestParam(required=false) String delete) {
	
		if(!LoginUtil.isUserLoggedIn(session)) {
			ra.addFlashAttribute("redirectMessage",REQUIRES_LOGIN );
			return "redirect:" + LOGIN_URL;
		}
		
		
		shoppingList.addItemToList(item);
		shoppingList.deleteItemFromList(delete);
	
		return "redirect:" +  SHOPPINGLIST_URL;
		
	}
	
	
}