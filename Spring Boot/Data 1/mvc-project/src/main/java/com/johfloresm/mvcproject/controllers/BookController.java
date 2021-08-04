package com.johfloresm.mvcproject.controllers;

import com.johfloresm.mvcproject.models.Book;
import com.johfloresm.mvcproject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController{

    @Autowired
    private BookService bookService;

    @RequestMapping("/api/books")
    public List<Book> index(){
        return bookService.allBooks();
    }

    @RequestMapping(value="/api/books", method= RequestMethod.POST)
    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }

    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        Book book = bookService.findBook(id);
        return book;
    }

    @RequestMapping(value = "/api/books/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "Libro eliminado";
    }

}
