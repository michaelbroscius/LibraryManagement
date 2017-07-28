package com.anthony.librarymanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anthony.librarymanagement.entity.Author;
import com.anthony.librarymanagement.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/addAuthor")
	public String authorForm(Model model) {
		model.addAttribute("author", new Author());
		model.addAttribute("authors", authorService.getAuthors());

		return "AuthorForm";
	}

	@PostMapping("/saveAuthor")
	public String saveAuthor(@ModelAttribute("author") @Valid Author author, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "AuthorForm";
		}

		System.out.println(author);

		authorService.add(author);
		model.addAttribute("authors", authorService.getAuthors());

		return "AuthorForm";
	}

	@GetMapping("/getAuthor")
	public String getBook(@RequestParam("id") String id, Model model) {

		System.out.println(id);

		model.addAttribute("author", authorService.getAuthor(id));
		model.addAttribute("authors", authorService.getAuthors());
		return "AuthorForm";
	}
}
