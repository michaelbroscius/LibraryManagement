package com.anthony.librarymanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anthony.librarymanagement.dao.PublisherDAO;
import com.anthony.librarymanagement.entity.Publisher;
import com.anthony.librarymanagement.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	private PublisherDAO publisherDao;

	@Transactional
	@Override
	public void add(Publisher publisher) {
		publisherDao.add(publisher);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Publisher> getPublishers() {
		return publisherDao.getPublishers();
	}

	@Transactional(readOnly = true)
	@Override
	public Publisher getPublisher(String id) {
		Publisher publisher = publisherDao.getPublisher(Long.parseLong(id));

		return publisher;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Map<String, String> getPublisherMap() {
		Map<String, String> publisherMap = new HashMap<String, String>();
		for (Publisher publisher : publisherDao.getPublishers()) {
			publisherMap.put(Long.toString(publisher.getId()), publisher.getName());
		}

		return publisherMap;
	}

}
