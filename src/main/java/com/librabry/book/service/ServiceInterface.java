package com.librabry.book.service;

import com.librabry.book.BookException.EmptyListException;
import com.librabry.book.BookException.InvalidEntryException;
import com.librabry.book.entities.Book;


import java.util.List;
import java.util.Set;

public interface ServiceInterface {
    List<Book> getBooks() ;//todo-done

    Book getBookByIsbnNo(long isbnNo);

    List<Book> addBook(Book book);//todo-done

    String deleteBook(long  isbnNo);

   Book updateBook(long isbnNo,Book book);

   List<Book> searchByAuthor(String authorName);


}
