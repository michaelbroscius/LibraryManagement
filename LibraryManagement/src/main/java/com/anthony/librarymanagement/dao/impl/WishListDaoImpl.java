package com.anthony.librarymanagement.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anthony.librarymanagement.dao.WishListDao;
import com.anthony.librarymanagement.entity.Book;
import com.anthony.librarymanagement.entity.User;

@Repository
public class WishListDaoImpl implements WishListDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Book> addBook(Book book, User user) {
		if (book.getId() == null)
			sessionFactory.getCurrentSession().save(book);
		else
			sessionFactory.getCurrentSession().merge(book);
		
		user.addBookToWishList(book);
		if (user.getId() == null)
			sessionFactory.getCurrentSession().save(user);
		else
			sessionFactory.getCurrentSession().merge(user);

		return user.getWishList();
	}

	@Override
	public List<Book> removeBook(Book book, User user) {
		/* delete the book from the user's wish list */
		@SuppressWarnings("unchecked")
		TypedQuery<Book> query = sessionFactory.getCurrentSession()
				.createQuery("delete from WISH_USER_BOOK " + "where USER_ID = :user_id and BOOK_id =: book_id");  //TODO make native
		query.setParameter("user_id", user.getId());
		query.setParameter("book_id", book.getId());
		query.executeUpdate();

		return getWishList(user);
	}

	@Override
	public List<Book> getWishList(User user) {
		// WISH_USER_BOOK
		//TODO find a better way to implement this
		TypedQuery<Book> query = sessionFactory.getCurrentSession().createNativeQuery("select USER_ID, BOOK_ID from WISH_USER_BOOK where USER_ID = " + user.getId());
		return query.getResultList();
	}

}
