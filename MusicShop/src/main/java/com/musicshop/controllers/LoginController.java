package com.musicshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.musicshop.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String showLoginPage() {
	
		return "views/loginForm";
	}
	

    @GetMapping("/logged")
    public String accessDenied() {
        return "/views/logged";
    }
		

}
