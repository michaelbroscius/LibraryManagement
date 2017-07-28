package com.anthony.librarymanagement.dto;

import com.anthony.librarymanagement.entity.Book;
import com.anthony.librarymanagement.entity.User;

public class WishListItem {
	private Book book;
	private User user;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
