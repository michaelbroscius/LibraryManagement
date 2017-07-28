package com.anthony.librarymanagement.dao;

import java.util.List;

import com.anthony.librarymanagement.entity.Publisher;

public interface PublisherDAO {
	public void add(Publisher publisher);

	public List<Publisher> getPublishers();

	public Publisher getPublisher(Long id);
}
