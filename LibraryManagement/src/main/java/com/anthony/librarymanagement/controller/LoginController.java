package com.anthony.librarymanagement.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.anthony.librarymanagement.entity.User;
import com.anthony.librarymanagement.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String validateUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model,
			HttpSession session) {

		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		if (userService.validateUser(user.getEmail(), user.getPassword()) != null) {
			session.setAttribute("userEmail", user.getEmail());
			return "Menu";
		}

		model.addAttribute("errorMessage", "User e-mail or password is incorrect");
		return "loginForm";
	}

}
