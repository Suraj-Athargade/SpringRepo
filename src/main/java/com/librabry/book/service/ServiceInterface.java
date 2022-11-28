package com.librabry.book.service;

import com.librabry.book.BookException.InvalidEntryException;
import com.librabry.book.entities.Book;


import java.util.List;
import java.util.Set;

public interface ServiceInterface {
    List<Book> getBook();

    Book getBook(long isbnNo);

    String addBook(Book book);

    String deleteBook(long  isbnNo);

   String updateBook(long isbnNo,Book book);

   Book searchByAuthor(String authorName);


}
