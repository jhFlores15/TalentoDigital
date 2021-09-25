package com.johfloresm.homeflix.controllers;

import com.johfloresm.homeflix.models.Category;
import com.johfloresm.homeflix.models.Film;
import com.johfloresm.homeflix.services.CategoryService;
import com.johfloresm.homeflix.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class ApiRestController{
    @Autowired
    private FilmService     filmService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("films")
    public Object getFilms(@RequestParam(value = "idCategory" , required = false) Long idCategory, @RequestParam(value = "title", required = false) String title){
        List<Film> films;
        Category   category = null;
        if(idCategory == null && title == null){
            films = filmService.getFilms();
        }
        else if(idCategory != null && title == null){
            category = categoryService.getCategoryById((long) idCategory);
            films = filmService.getFilmsByCategory(category);
        }
        else if(idCategory == null && title != null){
            films = filmService.getFilmsByTitle(title);
        }
        else{
            category = categoryService.getCategoryById((long) idCategory);
            films = filmService.getFilmsByCategoryAndTitle(category, title);
        }

        return films;
    }

    @GetMapping("categories")
    public Object getCategories(@RequestParam(value = "category" , required = false) String category){
        if(category == null){
            return categoryService.getCategories();
        }
        else{
            return categoryService.getCategoryByName(category);
        }
    }
}
