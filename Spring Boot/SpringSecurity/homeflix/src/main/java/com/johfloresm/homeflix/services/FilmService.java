package com.johfloresm.homeflix.services;

import com.johfloresm.homeflix.models.Category;
import com.johfloresm.homeflix.models.Film;
import com.johfloresm.homeflix.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService{

    @Autowired
    FilmRepository filmRepository;

    public List<Film> getFilmsByCategoryAndTitle(Category category, String title){
        return filmRepository.findFilmByCategoriesIsAndTitleContainsOrderByTitle(category,title);
    }

    public List<Film> getFilmsByCategory(Category category){
        return filmRepository.findFilmByCategoriesIsOrderByTitle(category);
    }

    public List<Film> getFilmsByTitle(String title){
        return filmRepository.findAllByTitleContainsOrderByTitle(title);
    }

    public List<Film> getFilms(){
        return filmRepository.findAllByTitleIsNotNullOrderByTitle();
    }
}
