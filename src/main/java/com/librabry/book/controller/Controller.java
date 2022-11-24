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

    @GetMapping("/book/{isbnNo}")
    public Book getIsbnNo(@PathVariable int isbnNo) {
        return this.serviceImpl.getBook(isbnNo);
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book ) {

        return this.serviceImpl.addBook(book);

    }

    @DeleteMapping("/book/{isbnNo}")
    public Book deleteBook(@PathVariable String isbnNo) {

        return this.serviceImpl.deleteBook(Integer.parseInt(isbnNo));

    }
    @PutMapping("/book/{isbnNo}")
    public Book updateBook(@PathVariable int isbnNo, @RequestBody Book book) {
        return this.serviceImpl.updateBook(isbnNo,book);
    }



}
