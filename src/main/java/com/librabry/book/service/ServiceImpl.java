package com.librabry.book.service;

import com.librabry.book.entities.Book;


import java.util.List;

public interface ServiceImpl {
    List<Book> getBook();

    Book getBook(long isbnNo);

    List<Book> addBook(Book book);

    Book deleteBook(long  isbnNo);

   Book updateBook(long isbnNo,Book book);

   Book searchByAuthor(String authorName);


}
