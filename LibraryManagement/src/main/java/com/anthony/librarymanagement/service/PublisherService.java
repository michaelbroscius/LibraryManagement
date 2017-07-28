package com.anthony.librarymanagement.service;

import java.util.List;
import java.util.Map;

import com.anthony.librarymanagement.entity.Publisher;

public interface PublisherService {
	void add(Publisher publisher);

	List<Publisher> getPublishers();
	
	public Map<String, String> getPublisherMap();

	public Publisher getPublisher(String id);
}
