package com.librabry.book.controller;


import com.librabry.book.entities.Book;
import com.librabry.book.service.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private ServiceInterface serviceInterface;

    @RequestMapping("/home")
    public String home() {
        logger.info("Library spring project started");
        return "welcome to the Library spring project.....";
    }

    @GetMapping("/book")
    public List<Book> getBook()  {
        logger.info("List of books displayed");
        //logger.warn("No books present");
        return this.serviceInterface.getBook();
    }

    @GetMapping("/book/ById/{isbnNo}")
    public Book getByIsbnNo(@PathVariable long isbnNo) {
        logger.info("Book with given isbnNo");
        return this.serviceInterface.getBook(isbnNo);
    }
    @GetMapping("/book/author/{author}")
    public Book searchByAuthor(@PathVariable String author){
        logger.info("List of books for given author");
        return this.serviceInterface.searchByAuthor(author);
    }

    @PostMapping("/book/add")
    public String addBook(@RequestBody Book book ) {
        return this.serviceInterface.addBook(book);
    }

    @DeleteMapping("/book/delete/{isbnNo}")
    public String deleteBook(@PathVariable String isbnNo) {
        logger.info("Book deleted");
        return this.serviceInterface.deleteBook(Long.parseLong(isbnNo));
    }
    @PutMapping("/book/update/{isbnNo}")
    public String updateBook(@PathVariable long isbnNo,@RequestBody Book book) {
        return serviceInterface.updateBook(isbnNo,book);
    }
}
