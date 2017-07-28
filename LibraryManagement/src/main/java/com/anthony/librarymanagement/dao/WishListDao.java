package com.anthony.librarymanagement.dao;

import java.util.List;

import com.anthony.librarymanagement.entity.Book;
import com.anthony.librarymanagement.entity.User;

public interface WishListDao {
	List<Book> addBook(Book book, User user);

	List<Book> removeBook(Book book, User user);

	List<Book> getWishList(User user);
}
