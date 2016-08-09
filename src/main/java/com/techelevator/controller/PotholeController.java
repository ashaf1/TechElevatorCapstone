package com.techelevator.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "login";
	}
}
