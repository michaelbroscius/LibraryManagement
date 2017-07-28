package com.anthony.librarymanagement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(name = "UID")
	private Long id;

	@Column(name = "NAME")
	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	private String name;

	@Column(name = "EMAIL", unique = true)
	@Email(message = "{user.email.invalid}")
	private String email;

	private String password;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roleId")
	private Role role;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "WISH_USER_BOOK", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
	private List<Book> wishList;

	public List<Book> getWishList() {
		return wishList;
	}

	public void setWishList(List<Book> wishList) {
		this.wishList = wishList;
	}

	public void addBookToWishList(Book book) {
		if (wishList == null)
			wishList = new ArrayList<Book>();
		wishList.add(book);
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
