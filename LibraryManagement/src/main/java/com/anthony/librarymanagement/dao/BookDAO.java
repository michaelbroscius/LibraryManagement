package com.anthony.librarymanagement.dao;

import java.util.List;

import com.anthony.librarymanagement.entity.Book;

public interface BookDAO {
	public List<Book> getBooks();

	public Book getBook(Long id);

	public void add(Book book);
}
