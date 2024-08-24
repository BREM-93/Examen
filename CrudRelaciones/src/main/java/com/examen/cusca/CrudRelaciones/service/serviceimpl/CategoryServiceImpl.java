package com.examen.cusca.CrudRelaciones.service.serviceimpl;

import com.examen.cusca.CrudRelaciones.entities.Category;
import com.examen.cusca.CrudRelaciones.entities.Product;
import com.examen.cusca.CrudRelaciones.repository.CategoriRepository;
import com.examen.cusca.CrudRelaciones.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoriRepository categoriRepository;

    @Override
    public List<Category> getAllGategories() {
        return (List<Category>) this.categoriRepository.findAll();
    }
    @Override
    public Category getCategoryById(Long id) {
        return this.categoriRepository.findById(id).get();
    }
    @Override
    public Category createCategory(Category category) {
        category.setCategoryName(category.getCategoryName());
        this.categoriRepository.save(category);
        return null;
    }
    @Override
    public Category updateCategory(Long id, Category category) {
        Category existingCategory = categoriRepository.findById(id).orElse(null);
        if (existingCategory !=null){
            existingCategory.setCategoryName(category.getCategoryName());
            existingCategory.setCategoryType(category.getCategoryType());
            return categoriRepository.save(existingCategory);
        }
        return null;
    }
    @Override
    public void deleteCategory(Long id) {
        this.categoriRepository.deleteById(id);
    }
}
