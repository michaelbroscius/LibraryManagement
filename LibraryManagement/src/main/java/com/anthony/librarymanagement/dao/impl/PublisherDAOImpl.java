package com.anthony.librarymanagement.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anthony.librarymanagement.dao.PublisherDAO;
import com.anthony.librarymanagement.entity.Publisher;

@Repository
public class PublisherDAOImpl implements PublisherDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Publisher publisher) {

		if(publisher.getId()==null)
		sessionFactory.getCurrentSession().save(publisher);
		else
			sessionFactory.getCurrentSession().merge(publisher);

	}

	@Override
	public List<Publisher> getPublishers() {
		@SuppressWarnings("unchecked")
		TypedQuery<Publisher> query = sessionFactory.getCurrentSession().createQuery("from Publisher");
		return query.getResultList();
	}

	@Override
	public Publisher getPublisher(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Publisher> query = sessionFactory.getCurrentSession().createQuery("from Publisher where id=:id");
		query.setParameter("id", id);
		Publisher publisher = query.getSingleResult();

			return publisher;
	}

}
