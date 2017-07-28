package com.anthony.librarymanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anthony.librarymanagement.dao.AuthorDAO;
import com.anthony.librarymanagement.dao.BookDAO;
import com.anthony.librarymanagement.dao.CategoryDAO;
import com.anthony.librarymanagement.dao.PublisherDAO;
import com.anthony.librarymanagement.dto.BookDto;
import com.anthony.librarymanagement.entity.Book;
import com.anthony.librarymanagement.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDAO bookDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private AuthorDAO authorDAO;

	@Autowired
	private PublisherDAO publisherDAO;

	@Transactional
	@Override
	public void add(BookDto bookDto) {
		Book book = new Book();
		if (bookDto.getId() != null)
			book.setId(bookDto.getId());
		book.setTitle(bookDto.getTitle());
		if (bookDto.getCategory() != null)
			book.setCategory(categoryDAO.getCategory(Long.parseLong(bookDto.getCategory())));
		if (bookDto.getPublicationYear() != null)
			book.setPublicationYear(bookDto.getPublicationYear());
		if (bookDto.getPublisher() != null)
			book.setPublisher(publisherDAO.getPublisher(Long.parseLong(bookDto.getPublisher())));
		if (bookDto.getAuthor() != null)
			book.setAuthor(authorDAO.getAuthor(Long.parseLong(bookDto.getAuthor())));

		bookDAO.add(book);
	}

	@Transactional
	@Override
	public void add(Book book) {
		bookDAO.add(book);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Book> getBooks() {
		return bookDAO.getBooks();
	}

	@Transactional(readOnly = true)
	@Override
	public BookDto getBook(String id) {
		Book book = bookDAO.getBook(Long.parseLong(id));
		BookDto bookDto = new BookDto();
		bookDto.setId(book.getId());
		bookDto.setTitle(book.getTitle());
		bookDto.setCategory(Long.toString(book.getCategory().getId()));
		bookDto.setAuthor(Long.toString(book.getAuthor().getId()));
		bookDto.setPublisher(Long.toString(book.getPublisher().getId()));
		bookDto.setPublicationYear(book.getPublicationYear());

		return bookDto;
	}

}
