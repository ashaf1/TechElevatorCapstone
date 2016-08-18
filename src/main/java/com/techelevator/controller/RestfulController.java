package com.techelevator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDAO;

@RestController
public class RestfulController {
	
	private PotholeDAO potholeDAO;

	@Autowired
	public RestfulController(PotholeDAO potholeDAO) {
		this.potholeDAO = potholeDAO;
	}
	
	@RequestMapping(path={"/home"}, method=RequestMethod.GET)
	public List<Pothole> showHomePage(ModelMap model) {
		
		return potholeDAO.getPotholesNotDuplicateOrRepaired();
	}
}
