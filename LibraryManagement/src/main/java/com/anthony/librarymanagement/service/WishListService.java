package com.anthony.librarymanagement.service;

import java.util.List;

import com.anthony.librarymanagement.dto.BookDto;
import com.anthony.librarymanagement.dto.UserDto;
import com.anthony.librarymanagement.dto.WishListItem;
import com.anthony.librarymanagement.entity.Book;
import com.anthony.librarymanagement.entity.User;

public interface WishListService {
	/**
	 * 
	 * @param book
	 * @param user
	 * @return User's wishlist (List<Book>) with book added or null if it could not be added.
	 */
	List<Book> addBook(Book book, User user);
	List<Book> addBook(BookDto bookDto, UserDto userDto);
	List<Book> addBook(WishListItem wishListItem);
	void removeBook(Book book, User user);
	List<Book> getWishList(User user);
}
