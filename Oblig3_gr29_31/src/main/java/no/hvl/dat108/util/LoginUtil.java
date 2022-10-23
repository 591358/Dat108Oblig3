package no.hvl.dat108.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginUtil {

	//Constant for the maximum allowed inactivity time
	private final static int MAX_INTERACTIVE_TIME = 60;
	
	/**
	 * This method will log in a user using a http request and a given password.
	 * @param request - A HttpServletRequest 
	 * @param pass - A password entered by the user
	 */
	public static void logInUser(HttpServletRequest request, String pass) {
		//good practice to log a user out, if there already is a user logged in.
		
		logOutUSer(request.getSession());
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(MAX_INTERACTIVE_TIME);
		
		//Propably not a good idea to store the password in the session.
		session.setAttribute("pass", pass);
	}
	/**
	 * This method will log a user out by invalidatin the session.
	 * @param session - the active session.
	 */
	private static void logOutUSer(HttpSession session) {
		session.invalidate();
	}
	/**
	 * This method will check whether or not the user is logged in the session
	 * @param session 
	 * @return true if logged in, false otherwise
	 */
	public static boolean isUserLoggedIn(HttpSession session) {
		return session!=null && session.getAttribute("pass") != null;
	}

}
