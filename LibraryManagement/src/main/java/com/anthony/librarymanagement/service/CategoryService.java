package com.anthony.librarymanagement.service;

import java.util.List;
import java.util.Map;

import com.anthony.librarymanagement.entity.Category;

public interface CategoryService {

	void add(Category cat);

	List<Category> getCategories();
	
	public Map<String, String> getCategoryMap();

	public Category getCategory(String id);
}
