package com.anthony.librarymanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anthony.librarymanagement.dao.AuthorDAO;
import com.anthony.librarymanagement.entity.Author;
import com.anthony.librarymanagement.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDAO authorDao;

	@Transactional
	@Override
	public void add(Author author) {
		authorDao.add(author);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Author> getAuthors() {
		return authorDao.getAuthors();
	}

	@Transactional(readOnly = true)
	@Override
	public Author getAuthor(String id) {
		Author author = authorDao.getAuthor(Long.parseLong(id));

		return author;
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, String> getAuthorMap() {
		List<Author> authors = authorDao.getAuthors();
		Map<String, String> authorMap = new HashMap<String, String>();
		for (Author author : authors) {
			authorMap.put(Long.toString(author.getId()), author.getLastName() + ", " + author.getFirstName());
			System.out.println(author);
		}

		return authorMap;
	}
}
