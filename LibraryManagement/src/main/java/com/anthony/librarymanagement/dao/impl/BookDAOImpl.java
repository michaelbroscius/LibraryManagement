package com.anthony.librarymanagement.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anthony.librarymanagement.dao.BookDAO;
import com.anthony.librarymanagement.entity.Book;

@Repository
public class BookDAOImpl implements BookDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Book> getBooks() {
		@SuppressWarnings("unchecked")
		TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book");
		return query.getResultList();
	}

	@Override
	public Book getBook(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book where id=:id");
		query.setParameter("id", id);
		Book book = query.getSingleResult();

		return book;
	}

	@Override
	public void add(Book book) {
		if (book.getId() == null)
			sessionFactory.getCurrentSession().save(book);
		else
			sessionFactory.getCurrentSession().merge(book);
	}

}
