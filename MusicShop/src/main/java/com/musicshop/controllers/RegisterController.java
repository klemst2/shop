package com.musicshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.musicshop.entities.User;
import com.musicshop.services.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerForm(Model model) {

		model.addAttribute("user", new User());
		return "views/registerForm";
	}

	@PostMapping("/register")
	public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {

		if (userService.userEmailExist(user.getEmail())) {
			model.addAttribute("isEmailExist", true);
			return "views/registerForm";
		}

		if (userService.userNameExist(user.getName())) {
			model.addAttribute("isNameExist", true);
			return "views/registerForm";
		}

		if (bindingResult.hasErrors()) {
			return "views/registerForm";
		}

		userService.createUser(user);

		return "views/registerSuccess";
	}

}
