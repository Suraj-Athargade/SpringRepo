package com.librabry.book.service;

import com.librabry.book.entities.Book;


import java.util.List;

public interface ServiceImpl {
    List<Book> getBook();

    Book getBook(int isbnNo);

    Book addBook(Book book);

    Book deleteBook(int  isbnNo);



  //  Book updateBook(int isbnNo,Book book);
}
