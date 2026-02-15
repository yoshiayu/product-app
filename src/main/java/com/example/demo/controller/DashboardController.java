package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class DashboardController {

	private final ProductRepository productRepository;
	private final UserRepository userRepository;

	public DashboardController(ProductRepository productRepository, UserRepository userRepository) {
		this.productRepository = productRepository;
		this.userRepository = userRepository;
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("productCount", productRepository.count());
		model.addAttribute("userCount", userRepository.count());
		return "dashboard";
	}
}
