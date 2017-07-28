package com.anthony.librarymanagement.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anthony.librarymanagement.dao.AuthorDAO;
import com.anthony.librarymanagement.entity.Author;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Author> getAuthors() {
		@SuppressWarnings("unchecked")
		TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("from Author");
		return query.getResultList();
	}

	@Override
	public Author getAuthor(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("from Author where id=:id");
		query.setParameter("id", id);
		Author author = query.getSingleResult();

		return author;
	}

	@Override
	public void add(Author author) {
		if (author.getId() == null)
			sessionFactory.getCurrentSession().save(author);
		else
			sessionFactory.getCurrentSession().merge(author);
	}

	@Override
	public void delete(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("delete Author where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();

	}

}
