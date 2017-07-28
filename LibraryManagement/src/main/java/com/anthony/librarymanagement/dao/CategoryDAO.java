package com.anthony.librarymanagement.dao;

import java.util.List;

import com.anthony.librarymanagement.entity.Category;

public interface CategoryDAO {

	public List<Category> getCategories();

	public Category getCategory(Long id);

	public void add(Category category);

}
