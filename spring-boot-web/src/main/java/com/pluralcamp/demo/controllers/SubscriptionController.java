package com.pluralcamp.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//Semblant al RestController
//Però la difència és que gestiona peticions
//des de HTML o JSP
//No poso cap RequestMapping pq vull accedir a la URL sense path addicional
@Controller
public class SubscriptionController {
	
	//inject via application.properties
	//@Value("${welcome.email}")
	private String email;
	private boolean option = false;
	
	@GetMapping("/")
	public String mainWithParam() {
		return "index"; //view
	}

	//siempre que quiera comunicar desde el controlador
	//a la vista lo haré con el objeto de tipo Model
	@GetMapping("/subscription")
	public String mainWithParam(@RequestParam(name = "email", required = false, defaultValue = "") 
			String email, Model model) {
		
		if(email.equals("")) {
			model.addAttribute("option", this.option);
			option = false; 
		}else {
			model.addAttribute("email", email);
			option = true; 
		}
		
		return "subscription"; //view
	}
}

