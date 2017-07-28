package com.anthony.librarymanagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private Long id;

	private String street;
	private String city;
	private String stateOrProvince;
	private String zipOrPostal;
	private String country;

	public Address() {
	}

	public Address(String street, String city, String stateOrProvince, String zipOrPostal, String country) {
		this.street = street;
		this.city = city;
		this.stateOrProvince = stateOrProvince;
		this.zipOrPostal = zipOrPostal;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getZipOrPostal() {
		return zipOrPostal;
	}

	public void setZipOrPostal(String zipOrPostal) {
		this.zipOrPostal = zipOrPostal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", stateOrProvince=" + stateOrProvince
				+ ", zipOrPostal=" + zipOrPostal + ", country=" + country + "]";
	}
}
