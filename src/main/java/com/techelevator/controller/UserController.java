package com.techelevator.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.Location;
import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDAO;
import com.techelevator.model.UserDAO;

@Controller
@SessionAttributes("allPotholes")
public class UserController {
	
	private UserDAO userDAO;
	private PotholeDAO potholeDAO;
	
	@Autowired
	public UserController(UserDAO userDAO, PotholeDAO potholeDAO) {
		this.userDAO = userDAO;
		this.potholeDAO = potholeDAO;
	}
	
	@RequestMapping(path="/users/{userName}", method=RequestMethod.GET)
	public String displayDashboard(ModelMap model, @PathVariable String userName) {
		return "userDashboard";
	}
	
	@RequestMapping(path="/report", method=RequestMethod.GET)
	public String displayReportPotholePage(ModelMap model) {
		return "report";
	}
	
	@RequestMapping(path="/report", method=RequestMethod.POST)
	public String processPotholeReport(@RequestParam String streetAddress,
									   @RequestParam String city,
									   @RequestParam String state,
									   @RequestParam String zip,
									   @RequestParam String comments,
									   ModelMap model
										) {
		Location location = new Location();
		location.setStreetAddress(streetAddress);
		location.setCity(city);
		location.setState(state);
		location.setZip(zip);
		if(comments != null) {
			location.setComments(comments);
		}
		potholeDAO.saveLocation(location);
		potholeDAO.savePothole();
		
		Pothole pothole = potholeDAO.getLastPothole();
		model.put("pothole", pothole);
		model.put("allPotholes", potholeDAO.getAllPotholes());
		return "redirect:/confirmation";
	}
	
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String displayConfirmationPage(ModelMap model) {
		return "confirmation";
	}

}
