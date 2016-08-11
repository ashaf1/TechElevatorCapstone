package com.techelevator.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDAO;
import com.techelevator.model.UserDAO;

@Transactional
@Controller
@SessionAttributes({"allPotholes", "pothole"})
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
	
	@RequestMapping(path="/users/{userName}/reports", method=RequestMethod.GET)
	public String displayReportPage(ModelMap model, @PathVariable String userName) {
		model.put("potholes", potholeDAO.getAllPotholes());
		return "searchReports";
	}
	@RequestMapping(path="/users/{userName}/reports", method = RequestMethod.POST)
	public String redirectToSearchReportsPage(@RequestParam (required = false) String status, 
											  @RequestParam (required = false) String priorityLevel,
											  @RequestParam (required = false) String city,
											  @RequestParam (required = false) String streetAddress,
											  ModelMap model) {		
		
		return "redirect:/searchReports";
	}
	
	@RequestMapping(path="/report", method=RequestMethod.GET)
	public String displayReportPotholePage(ModelMap model) {
		return "report";
	}
	
	@RequestMapping(path="/report", method=RequestMethod.POST)
	public String processPotholeReport(@RequestParam String streetAddress,
									   @RequestParam String city,
									   @RequestParam String zip,
									   @RequestParam String comments,
									   ModelMap model
										) {
		Pothole pothole = new Pothole();
		pothole.setStreetAddress(streetAddress);
		pothole.setCity(city);
		pothole.setZip(zip);
		if(!comments.equals("")) {
			pothole.setComments(comments);
		}
		potholeDAO.savePothole(pothole);
		
		model.put("pothole", pothole);
		return "redirect:/confirmation";
	}
	
	@RequestMapping(path="/confirmation", method=RequestMethod.GET)
	public String displayConfirmationPage(ModelMap model) {
		return "confirmation";
	}
	@RequestMapping(path="/users/{userName}/updatePothole", method=RequestMethod.GET)
	public String displayUpdatePotholePage(ModelMap model, @RequestParam int potholeId, @PathVariable String userName){
		model.put("currentPothole", potholeDAO.getPotholeByID(potholeId));
		return "updatePothole";
	}
	@RequestMapping(path="/users/{userName}/updatePothole", method=RequestMethod.POST)
	public String redirectToSearchReports(@PathVariable String userName,
										  @RequestParam int potholeId,
										  @RequestParam (required=false) String priorityLevel, 
										  @RequestParam (required=false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate inspectionDate,
										  @RequestParam (required=false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate repairDate,
										  @RequestParam String status){
		if(priorityLevel.equals("") == false){
			potholeDAO.updatePotholePriority(potholeId, priorityLevel);
		}
		if(inspectionDate != null){
			potholeDAO.updatePotholeInspectionDate(potholeId, inspectionDate);
		}
		if(repairDate != null){
			potholeDAO.updatePotholeFixedDate(potholeId, repairDate);
		}
		if(status.equals("NEW") == false){
			potholeDAO.updatePotholeStatus(potholeId, status);
		}
		
		
		return "redirect:/users/"+userName+"/reports";
	}
	
	@RequestMapping(path="/users/{userName}/changePassword", method=RequestMethod.GET)
	public String displayChangePasswordForm(ModelMap model, @PathVariable String userName) {
		model.put("userName", userName);
		return "changePassword";
	}
	
	@RequestMapping(path="/users/{userName}/changePassword", method=RequestMethod.POST)
	public String changePassword(@PathVariable String userName, @RequestParam String password) {
		userDAO.updatePassword(userName, password);
		return "userDashboard";
	}
}
