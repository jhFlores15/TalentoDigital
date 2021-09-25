package com.johfloresm.homeflix.repositories;

import com.johfloresm.homeflix.models.Category;
import com.johfloresm.homeflix.models.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film,Long>{

    List<Film> findAllByTitleContainsOrderByTitle(String title);
    List<Film> findAllByTitleIsNotNullOrderByTitle();
    List<Film> findFilmByCategoriesIsOrderByTitle(Category category);
    List<Film> findFilmByCategoriesIsAndTitleContainsOrderByTitle(Category category, String title);
}
