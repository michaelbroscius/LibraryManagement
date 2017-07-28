package com.anthony.librarymanagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.librarymanagement.dto.WishListItem;
import com.anthony.librarymanagement.entity.Book;
import com.anthony.librarymanagement.service.WishListService;

@RestController
public class WishListWebService {
	@Autowired
	WishListService wishListService;

	@RequestMapping(value = "/rest/addbook", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<List<Book>> addBook(@RequestBody WishListItem wishListItem) {
		List<Book> wishList = null;
		ResponseEntity<List<Book>> responseEntityWishList;
		try {
			wishList = wishListService.addBook(wishListItem);
			for (Book book : wishList) {
				System.out.println("List of books:" );
				System.out.println(book);
			}
			responseEntityWishList = new ResponseEntity<List<Book>>(wishList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntityWishList = new ResponseEntity<List<Book>>(wishList, HttpStatus.NO_CONTENT);
		}

		System.out.println(responseEntityWishList);
		return responseEntityWishList;
	}

}
