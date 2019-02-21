package com.musicshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.musicshop.services.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductsController {

	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public String showAdminProducts(Model model) {
		model.addAttribute("products", productService.findAll());
		return "views/adminProducts";
	}
}
