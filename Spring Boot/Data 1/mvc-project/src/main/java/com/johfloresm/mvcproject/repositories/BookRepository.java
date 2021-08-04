package com.johfloresm.mvcproject.repositories;

import com.johfloresm.mvcproject.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

    //Este método recupera todos los libros de la base de datos
    List<Book> findAll();
    //Este método encuentra un libro por su descripción
    List<Book> findByDescriptionContaining(String search);
    //Este método cuenta cuántos libros contiene cierta cadena en el título
    Long countByTitleContaining(String search);
    //Este método borra un libro que empieza con un título específico
    Long deleteByTitleStartingWith(String search);

    @Transactional
    Long deleteBookById(Long id);
}
