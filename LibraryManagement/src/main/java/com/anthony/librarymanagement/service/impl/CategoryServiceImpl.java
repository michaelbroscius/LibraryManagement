package com.anthony.librarymanagement.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anthony.librarymanagement.dao.CategoryDAO;
import com.anthony.librarymanagement.entity.Category;
import com.anthony.librarymanagement.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDao;
	
	@Transactional
	@Override
	public void add(Category cat) {
		categoryDao.add(cat);

	}

	@Transactional(readOnly = true)
	@Override
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, String> getCategoryMap() {
		List<Category> categorys = categoryDao.getCategories();
		Map<String, String> categoryMap = new HashMap<String, String>();
		for (Category category : categorys) {
			categoryMap.put(Long.toString(category.getId()), category.getName());
			System.out.println(category);
		}

		return categoryMap;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Category getCategory(String id) {
		Category cat = categoryDao.getCategory(Long.parseLong(id));

		return cat;
	}
}
