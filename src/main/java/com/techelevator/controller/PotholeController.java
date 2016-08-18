package com.techelevator.controller;

import java.time.LocalDate;

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
@SessionAttributes({"potholes", "pothole"})
public class PotholeController {
	
	private UserDAO userDAO;
	private PotholeDAO potholeDAO;
	
	@Autowired
	public PotholeController(UserDAO userDAO, PotholeDAO potholeDAO) {
		this.userDAO = userDAO;
		this.potholeDAO = potholeDAO;
	}
	
	@RequestMapping(path="/users/{userName}/reports", method=RequestMethod.GET)
	public String displayReportPage(ModelMap model, @RequestParam (required = false) String status, 
			  										@RequestParam (required = false) String priorityLevel,
			  										@RequestParam (required = false) String city,
			  										@RequestParam (required = false) String streetAddress,
			  										@RequestParam (required = false) String zip,
			  										@PathVariable String userName) {
		model.put("potholes", potholeDAO.getAllPotholes());		
		return "searchReports";
	}
	
	@RequestMapping(path="/users/{userName}/reports", method = RequestMethod.POST)
	public String redirectToAdvancedSearchPage(@RequestParam (required = false) String status, 
											  @RequestParam (required = false) String priorityLevel,
											  @RequestParam (required = false) String city,
											  @RequestParam (required = false) String street,
											  @RequestParam (required = false) String zip,
											  @PathVariable String userName,
											  ModelMap model) {	
		
		
		model.put("potholes", potholeDAO.getPotholesByCriteria(status, priorityLevel, city, street, zip));
		
		return "redirect:/users/"+userName+"/advancedSearch";
	}
	
	@RequestMapping(path="/users/{userName}/advancedSearch", method=RequestMethod.GET)
	public String dislayAdvancedSearchPage(@PathVariable String userName) {
		return "advancedSearch";
	}
	
	@RequestMapping(path="/report", method=RequestMethod.GET)
	public String displayReportPotholePage(ModelMap model) {
		return "report";
	}
	
	@RequestMapping(path="/report", method=RequestMethod.POST)
	public String processPotholeReport(@RequestParam (required = false) String addressNumber,
									   @RequestParam String street,
									   @RequestParam String city,
									   @RequestParam String zip,
									   @RequestParam String comments,
									   ModelMap model
										) {
		Pothole pothole = new Pothole();
		pothole.setAddressNumber(addressNumber);
		pothole.setStreet(street);
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
	
	@RequestMapping(path="/users/{userName}/metrics", method=RequestMethod.GET)
	public String displayPotholeMetricsPage(@PathVariable String userName,
											ModelMap model){
		
		model.put("avgRepairTime", potholeDAO.getAverageRepairTimeInDays());
		model.put("streetWithMostPotholes", potholeDAO.streetWithMostPotholes());
		model.put("cityMostPotholes", potholeDAO.cityWithMostPotholesAndNumOfPotholes());
		model.put("zipCityWithMostPotholes", potholeDAO.zipWithMostPotholes());
		
		return "metrics";
	}
}
