package com.anthony.librarymanagement.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anthony.librarymanagement.dao.BookDAO;
import com.anthony.librarymanagement.dao.UserDAO;
import com.anthony.librarymanagement.dao.WishListDao;
import com.anthony.librarymanagement.dto.BookDto;
import com.anthony.librarymanagement.dto.UserDto;
import com.anthony.librarymanagement.dto.WishListItem;
import com.anthony.librarymanagement.entity.Book;
import com.anthony.librarymanagement.entity.User;
import com.anthony.librarymanagement.service.WishListService;

@Service
public class WishListServiceImpl implements WishListService {
	
	//TODO Check into AOP and DI
	private static final Logger logger = Logger.getLogger(WishListServiceImpl.class);

	@Autowired
	WishListDao wishListDao;

	@Autowired
	BookDAO bookDao;

	@Autowired
	UserDAO userDao;

	@Transactional
	@Override
	public List<Book> addBook(Book book, User user) {
		
		
		wishListDao.addBook(book, user);

		return wishListDao.getWishList(user);
	}

	@Transactional
	@Override
	public List<Book> addBook(BookDto bookDto, UserDto userDto) {

		return addBook(bookDao.getBook(bookDto.getId()), userDao.getUser(userDto.getId()));
	}
	
	@Transactional
	@Override
	public List<Book> addBook(WishListItem wishListItem) {
		
		return addBook(bookDao.getBook(wishListItem.getBook().getId()), userDao.getUser(wishListItem.getUser().getId()));
	}

	@Transactional
	@Override
	public void removeBook(Book book, User user) {
		// TODO Auto-generated method stub

	}

	@Transactional(readOnly = true)
	@Override
	public List<Book> getWishList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
