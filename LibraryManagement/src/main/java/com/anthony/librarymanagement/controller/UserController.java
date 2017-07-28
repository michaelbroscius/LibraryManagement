package com.anthony.librarymanagement.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anthony.librarymanagement.dto.UserDto;
import com.anthony.librarymanagement.entity.User;
import com.anthony.librarymanagement.service.RoleService;
import com.anthony.librarymanagement.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@GetMapping("/")
	public String userForm(Locale locale, Model model) {

		model.addAttribute("user", new User());
		model.addAttribute("users", userService.getUsers());

		return "loginForm";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") @Valid UserDto user, BindingResult result, Model model) {

		if (result.hasErrors()) {

			model.addAttribute("users", userService.getUsers());
			model.addAttribute("roles", roleService.getRoles());
			return "userForm";
		}

		System.out.println(user.getId() + " / " + user.getEmail() + " / " + user.getPassword());

		userService.add(user);

		return "redirect:/";
	}

	@GetMapping("/getUser")
	public String getUser(@RequestParam("id") String id, Model model) {

		System.out.println(id);

		model.addAttribute("user", userService.getUser(id));
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("roles", roleService.getRoles());

		return "userForm";
	}

	@GetMapping("/addUser")
	public String User(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("users", userService.getUsers());
		model.addAttribute("roles", roleService.getRoles());

		return "userForm";
	}

}
