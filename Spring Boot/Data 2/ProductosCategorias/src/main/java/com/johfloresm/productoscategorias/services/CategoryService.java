package com.johfloresm.productoscategorias.services;

import com.johfloresm.productoscategorias.models.Category;
import com.johfloresm.productoscategorias.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategoryById(Long id){
        return  categoryRepository.findCategoryById(id);
    }

    public List<Category> getCategories(){
        return  categoryRepository.findAll();
    }

    public Category createCategory (Category c){
        return categoryRepository.save(c);
    }
}
