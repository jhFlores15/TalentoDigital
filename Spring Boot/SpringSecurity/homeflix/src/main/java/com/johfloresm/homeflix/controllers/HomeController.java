package com.johfloresm.homeflix.controllers;

import com.johfloresm.homeflix.models.Category;
import com.johfloresm.homeflix.models.Film;
import com.johfloresm.homeflix.services.CategoryService;
import com.johfloresm.homeflix.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController{

    @Autowired
    private FilmService     filmService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String home(@RequestParam(value = "idCategory" , required = false) Long idCategory, @RequestParam(value = "title",required = false) String title, Model model){
        List<Film> films;
        Category category = null;
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

        model.addAttribute("categories",categoryService.getCategories());
        model.addAttribute("category",category);
        model.addAttribute("films",films);
        model.addAttribute("title",title);

        return "home.jsp";
    }
}
