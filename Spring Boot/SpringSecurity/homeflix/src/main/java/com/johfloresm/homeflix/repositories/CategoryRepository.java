package com.johfloresm.homeflix.repositories;

import com.johfloresm.homeflix.models.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{

    List<Category> findCategoriesByNameIsNotNullOrderByName();
}
