package com.librabry.book.controller;


import com.librabry.book.BookException.EmptyListException;
import com.librabry.book.BookException.InvalidEntryException;
import com.librabry.book.entities.Book;
import com.librabry.book.service.ServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {

    @Autowired
    private ServiceInterface serviceInterface;

    @GetMapping("/books")
    public List<Book> getBooks() { //todo
       // logger.info("List of books displayed");
        //logger.warn("No books present");
        return this.serviceInterface.getBooks();
    }

    @GetMapping("/books/getBookByIsbnNo/{isbnNo}")//getbookbyIsbnNo-done
    public Book getBookByIsbnNo(@PathVariable long isbnNo) {
        return this.serviceInterface.getBookByIsbnNo(isbnNo);
    }
    @GetMapping("/books/author/{author}")
    public List<Book> searchByAuthor(@PathVariable String author){

        return this.serviceInterface.searchByAuthor(author);
    }

    @PostMapping("/books/add")
    public List<Book> addBook(@RequestBody Book book ) {

        return this.serviceInterface.addBook(book);
    }

    @DeleteMapping("/books/delete/{isbnNo}")
    public String deleteBook(@PathVariable long isbnNo) {

        return this.serviceInterface.deleteBook(isbnNo);
    }
    @PutMapping("/books/update/{isbnNo}")
    public Book updateBook(@PathVariable long isbnNo,@RequestBody Book book) {

        return serviceInterface.updateBook(isbnNo,book);
    }
}
