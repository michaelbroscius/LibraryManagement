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

import com.anthony.librarymanagement.dto.BookDto;
import com.anthony.librarymanagement.entity.Book;
import com.anthony.librarymanagement.service.AuthorService;
import com.anthony.librarymanagement.service.BookService;
import com.anthony.librarymanagement.service.CategoryService;
import com.anthony.librarymanagement.service.PublisherService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@Autowired
	private PublisherService publisherService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/addBook")
	public String bookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("books", bookService.getBooks());
		model.addAttribute("authors", authorService.getAuthorMap());
		model.addAttribute("categories", categoryService.getCategoryMap());
		model.addAttribute("publisherMap", publisherService.getPublisherMap());

		return "bookForm";
	}

	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") @Valid BookDto book, BindingResult result, Model model) {
		System.out.println("In saveBook");

		model.addAttribute("books", bookService.getBooks());
		model.addAttribute("authors", authorService.getAuthorMap());
		model.addAttribute("categories", categoryService.getCategoryMap());
		model.addAttribute("publisherMap", publisherService.getPublisherMap());

		if (result.hasErrors()) {

			return "bookForm";
		}

		System.out.println(book);

		bookService.add(book);
		model.addAttribute("book", new Book());
		model.addAttribute("books", bookService.getBooks());


		return "bookForm";
	}

	@GetMapping("/getBook")
	public String getBook(@RequestParam("id") String id, Model model) {

		System.out.println(id);

		model.addAttribute("book", bookService.getBook(id));
		model.addAttribute("books", bookService.getBooks());
		model.addAttribute("authors", authorService.getAuthorMap());
		model.addAttribute("categories", categoryService.getCategoryMap());
		model.addAttribute("publisherMap", publisherService.getPublisherMap());

		return "bookForm";
	}

}
