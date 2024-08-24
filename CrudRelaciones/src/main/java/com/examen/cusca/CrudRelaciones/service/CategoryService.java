package com.examen.cusca.CrudRelaciones.service;

import com.examen.cusca.CrudRelaciones.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllGategories();
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
