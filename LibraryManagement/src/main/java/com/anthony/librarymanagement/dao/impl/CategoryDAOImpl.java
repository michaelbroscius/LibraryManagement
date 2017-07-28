package com.anthony.librarymanagement.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anthony.librarymanagement.dao.CategoryDAO;
import com.anthony.librarymanagement.entity.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Category category) {
		if (category.getId() == null)
			sessionFactory.getCurrentSession().save(category);
		else
			sessionFactory.getCurrentSession().merge(category);
	}

	@Override
	public List<Category> getCategories() {
		@SuppressWarnings("unchecked")
		TypedQuery<Category> query = sessionFactory.getCurrentSession().createQuery("from Category");
		return query.getResultList();
	}

	@Override
	public Category getCategory(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Category> query = sessionFactory.getCurrentSession().createQuery("from Category where id=:id");
		query.setParameter("id", id);
		Category category = query.getSingleResult();

		return category;
	}

}
