package com.anthony.librarymanagement.service;

import java.util.List;

import com.anthony.librarymanagement.dto.BookDto;
import com.anthony.librarymanagement.entity.Book;

public interface BookService {
	void add(BookDto book);

	void add(Book book);

	List<Book> getBooks();

	public BookDto getBook(String id);
	
}
