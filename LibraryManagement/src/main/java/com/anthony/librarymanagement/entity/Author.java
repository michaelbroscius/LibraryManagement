package com.anthony.librarymanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {

	

	@Id
	@GeneratedValue
	private Long id;
	private String lastName;
	private String firstName;
	
	public Author() {
	}

	public Author(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + "]";
	}
}
