package com.anthony.librarymanagement.dao;

import java.util.List;

import com.anthony.librarymanagement.entity.Author;

public interface AuthorDAO {

	public List<Author> getAuthors();

	public Author getAuthor(Long id);

	public void add(Author author);
	
	public void delete(Long id);

}
