package com.johfloresm.mvcproject.controllers;

import com.johfloresm.mvcproject.models.Book;
import com.johfloresm.mvcproject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BooksController{

    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/index.jsp";
    }

    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    @RequestMapping(value="/books", method= RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }

    @RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model){
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "/books/show.jsp";
    }
}
