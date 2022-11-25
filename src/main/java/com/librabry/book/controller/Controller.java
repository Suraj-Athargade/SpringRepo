package com.librabry.book.controller;

import com.librabry.book.entities.Book;
import com.librabry.book.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class Controller {

    @Autowired
    private ServiceImpl serviceImpl;

    @RequestMapping("/home")
    public String home() {
        return "welcome to the Library spring project.....";
    }

    @GetMapping("/book")
    public List<Book> getBook() {
        return this.serviceImpl.getBook();
    }

    @GetMapping("/book/ById/{isbnNo}")
    public Book getByIsbnNo(@PathVariable long isbnNo) {
        return this.serviceImpl.getBook(isbnNo);
    }
    @GetMapping("/book/author/{author}")
    public Book searchByAuthor(@PathVariable String author){
        return this.serviceImpl.searchByAuthor(author);
    }

    @PostMapping("/book/add")
    public List<Book> addBook(@RequestBody Book book ) {
        return this.serviceImpl.addBook(book);
    }

    @DeleteMapping("/book/delete/{isbnNo}")
    public Book deleteBook(@PathVariable String isbnNo) {
        return this.serviceImpl.deleteBook(Long.parseLong(isbnNo));
    }
    @PutMapping("/book/update/{isbnNo}")
    public Book updateBook(@PathVariable long isbnNo,@RequestBody Book book) {
        return serviceImpl.updateBook(isbnNo,book);
    }
}
