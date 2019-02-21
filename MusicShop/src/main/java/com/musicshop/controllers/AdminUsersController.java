package com.musicshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicshop.entities.User;
import com.musicshop.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminUsersController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String showAdminUsers(Model model) {

		model.addAttribute("users", userService.findAll());
		return "views/adminUsers";
	}

	@GetMapping("/users/{id}")
	public String deleteUserByName(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/admin/users";
	}

}
