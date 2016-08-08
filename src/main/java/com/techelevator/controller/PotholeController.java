package com.techelevator.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PotholeController {
	
//	@Autowired
//	public PotholeController () {
//		
//	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		return "home";
	}

}
