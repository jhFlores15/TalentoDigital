package com.johfloresm.homeflix.services;

import com.johfloresm.homeflix.models.Category;
import com.johfloresm.homeflix.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategories(){
        return categoryRepository.findCategoriesByNameIsNotNullOrderByName();
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }
}
