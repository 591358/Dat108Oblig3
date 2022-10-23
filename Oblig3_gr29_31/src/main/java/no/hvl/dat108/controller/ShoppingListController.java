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
	@Value("${app.url.login}")
	private String LOGIN_URL;
	@Value("${app.url.shoppinglist}")
	private String SHOPPINGLIST_URL;
	@Value("${app.message.requiresLogin}")
	private String REQUIRES_LOGIN;

	@Autowired
	private Shoppinglist shoppingList;

	/**
	 * This method recieves a HTTP get request, and checks whether or not the user
	 * is logged in to the shoppinglist.
	 * 
	 * @param session - the users current session
	 * @param ra      - A RedirectAttribute - for error handling
	 * @return a shoppinglist view if the user is logged in, otherwise it redirects
	 *         the user to the login page
	 */
	@GetMapping
	public String getShoppinglist(HttpSession session, RedirectAttributes ra) {
		if (!LoginUtil.isUserLoggedIn(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN);
			return "redirect:" + LOGIN_URL;
		}
		
		session.setAttribute("shopping", shoppingList.getShoppinglist());

		return "shoppinglist";
	}

	/**
	 * This is a HTTP post method, and it will allow the user to make changes to the
	 * shoppinglist view. Allows for deleting and adding items to the shoppinglist.
	 * 
	 * @param item    - item to be added
	 * @param session - users current session
	 * @param ra      - A RedirectAttribute - for error handling
	 * @param delete  - an item to be deleted
	 * @return Redirect to login page if user is not logged in, otherwise it will
	 *         redirect to the updated shoppinglist view.
	 */
	@PostMapping
	public String addAndRemoveFromList(@RequestParam(required = false) String item, HttpSession session,
			RedirectAttributes ra, @RequestParam(required = false) String delete) {

		if (!LoginUtil.isUserLoggedIn(session)) {
			ra.addFlashAttribute("redirectMessage", REQUIRES_LOGIN);
			return "redirect:" + LOGIN_URL;
		}

		shoppingList.addItemToList(item);
		shoppingList.deleteItemFromList(delete);

		return "redirect:" + SHOPPINGLIST_URL;

	}

}