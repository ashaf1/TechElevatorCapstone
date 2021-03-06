package com.techelevator.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.PotholeDAO;
import com.techelevator.model.User;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes({"currentUser", "user"})
public class LoginController {
	
	private UserDAO userDAO;
	private PotholeDAO potholeDAO;
	
	@Autowired
	public LoginController (UserDAO userDAO, PotholeDAO potholeDAO) {
		this.userDAO = userDAO;
		this.potholeDAO = potholeDAO;
	}
	
	@RequestMapping(path="/users/new", method=RequestMethod.GET)
	public String displayNewUserForm(ModelMap model) {
		User user = getUser(model);
		if(user.getRole().equals("Administrator")){
			return "newUser";
		} 
		return "unauthorizedPage";
	}
	
	@RequestMapping(path="/users", method=RequestMethod.POST)
	public String createUser(@RequestParam String role, @RequestParam String firstName, 
							 @RequestParam String lastName, @RequestParam String userName, 
							 @RequestParam String password, ModelMap model) {
		User user = getUser(model);
		if(user.getRole().equals("Administrator")){
			User newUser = new User();
			newUser.setRole(role);
			newUser.setFirstName(firstName);
			newUser.setLastName(lastName);
			newUser.setUserName(userName);
			newUser.setPassword(password);
			
			userDAO.createUser(newUser);
			return "redirect:/login";
		}  else {
			return "unauthorizedPage";
		}
	}
	
	@RequestMapping(path="/login", method=RequestMethod.GET)
	public String showLoginPage(){
		return "login";
	}
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String redirectHomePage(ModelMap model, 
								   @RequestParam String userName, 
								   @RequestParam String password,
								   @RequestParam (required=false) String destination,
									HttpSession session){
		
		if(userDAO.searchForUsernameAndPassword(userName, password)) {
			session.invalidate();
			User user = userDAO.getUserByUsernameAndPassword(userName, password);
			model.put("currentUser", userName);
			model.put("user", user);
			if(isValidRedirect(destination)) {
				return "redirect:"+destination;
			} else {
				return "redirect:/users/"+userName;
			}
		} else {
			return "redirect:/login";
		}
		
	}
	@RequestMapping (path="/unauthorizedPage", method=RequestMethod.GET)
	public String returnUnauthorizedPage(){
		return "unauthorizedPage";
	}
	@RequestMapping(path="/logout", method=RequestMethod.POST)
	public String logout(ModelMap model, HttpSession session) {
		model.remove("currentUser");
		session.removeAttribute("currentUser");
		return "redirect:/";
	}
	
	private boolean isValidRedirect(String destination) {
		return destination != null && destination.startsWith("http://localhost");
	}
	private User getUser(ModelMap model){
		User user = (User)model.get("user");
		if(user == null){
			user = new User();
			model.put("user", user);
		}
		return user;
	}
}
