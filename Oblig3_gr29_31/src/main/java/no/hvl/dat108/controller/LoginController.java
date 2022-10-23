package no.hvl.dat108.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat108.util.LoginUtil;

@Controller
@RequestMapping("${app.url.login}")
public class LoginController {
	
	@Value("${app.message.invalidPassword}") private String INVALID_PASSWORD_MESSAGE;
	@Value("${app.url.login}")   private String LOGIN_URL;
	@Value("${app.url.shoppinglist}") private String SHOPPINGLIST_URL;
	@Value("${spring.datasource.password}") private String MASTER_PASSWORD;
	
	@GetMapping
	public String getLogin() {
		return "login";
	}

	@PostMapping
	public String loginAttempt(@RequestParam String pass, HttpServletRequest request, RedirectAttributes ra) {
		if(!pass.equals(MASTER_PASSWORD)) {
			ra.addFlashAttribute("redirectMessage",INVALID_PASSWORD_MESSAGE );
			return "redirect:" + LOGIN_URL;
		}
		LoginUtil.logInUser(request,pass);
		return "redirect:" + SHOPPINGLIST_URL;
	}
	
}
