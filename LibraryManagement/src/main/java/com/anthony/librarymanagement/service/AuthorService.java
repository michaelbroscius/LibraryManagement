package com.anthony.librarymanagement.service;

import java.util.List;
import java.util.Map;

import com.anthony.librarymanagement.entity.Author;

public interface AuthorService {
	void add(Author author);

	List<Author> getAuthors();

	public Author getAuthor(String id);
	
	public Map<String, String> getAuthorMap();
}
