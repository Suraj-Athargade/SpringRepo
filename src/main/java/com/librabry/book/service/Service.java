package com.librabry.book.service;

import com.librabry.book.entities.Book;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImpl {
    List<Book> bookList = new ArrayList<>();

    public Service() {
        bookList.add(new Book(10, "Math", "HCverma"));
        bookList.add(new Book(11, "Science", "Golden"));
        bookList.add(new Book(12, "English", "helen"));
    }

    @Override
    public List<Book> getBook() {
        return bookList;
    }

    @Override
    public Book getBook(int bookIsbnId) {
       Book book=null;
        for (Book book1 : bookList) {
            if (book1.getIsbnNo() == bookIsbnId) {
                book = book1;
                break;
            }
        }
        return book;
    }

    @Override
    public Book addBook(Book book) {
        bookList.add(book);
        return book;
    }

    @Override
    public Book deleteBook(int isbnNo) {
        Book book=null;
        for (Book book1 : bookList) {
            if (book1.getIsbnNo() == isbnNo) {
                book = book1;
                bookList.remove(book);
                break;
            }
        }
        return book;
    }

    @Override
    public Book updateBook(int isbnNo, Book book) {
        Book book1=null;
        Book result = getBook(isbnNo);
        for (Book  bookObj: bookList) {
            if (bookObj.getIsbnNo() == isbnNo) {
                bookObj.setAuthor(book1.getAuthor());
                bookObj.setBookName(book1.getBookName());

                book1= bookObj;
                break;
            }
        }
        return book1;
    }


}
