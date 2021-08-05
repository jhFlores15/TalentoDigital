package com.johfloresm.mvcproject.services;

import com.johfloresm.mvcproject.models.Book;
import com.johfloresm.mvcproject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService{

    @Autowired
    private BookRepository bookrepository;

    public List<Book> allBooks() {
        return bookrepository.findAll();
    }

    public Book createBook(Book b) {
        return bookrepository.save(b);
    }

    public Book findBook(Long id) {
        Book book = bookrepository.findById(id).orElse(null);
        return book;
    }

    public Long deleteBook(Long id){
        return bookrepository.deleteBookById(id);
    }

    public void updateBook(Book book){
        Book b = this.findBook(book.getId());

        b.setLanguage(book.getLanguage());
        b.setNumberOfPages(book.getNumberOfPages());
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());

        bookrepository.save(b);
    }
}
