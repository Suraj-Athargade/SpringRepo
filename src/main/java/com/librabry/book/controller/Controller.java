package com.librabry.book.controller;


import com.librabry.book.entities.Book;
import com.librabry.book.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class Controller {

    @Autowired
    private ServiceInterface serviceInterface;

    @RequestMapping("/home")
    public String home() {
        return "welcome to the Library spring project.....";
    }

    @GetMapping("/book")
    public List<Book> getBook()  {
        return this.serviceInterface.getBook();
    }

    @GetMapping("/book/ById/{isbnNo}")
    public Book getByIsbnNo(@PathVariable long isbnNo) {
        return this.serviceInterface.getBook(isbnNo);
    }
    @GetMapping("/book/author/{author}")
    public Book searchByAuthor(@PathVariable String author){
        return this.serviceInterface.searchByAuthor(author);
    }

    @PostMapping("/book/add")
    public List<Book> addBook(@RequestBody Book book ) {
        return this.serviceInterface.addBook(book);
    }

    @DeleteMapping("/book/delete/{isbnNo}")
    public String deleteBook(@PathVariable String isbnNo) {
        return this.serviceInterface.deleteBook(Long.parseLong(isbnNo));
    }
    @PutMapping("/book/update/{isbnNo}")
    public Book updateBook(@PathVariable long isbnNo,@RequestBody Book book) {
        return serviceInterface.updateBook(isbnNo,book);
    }
}
