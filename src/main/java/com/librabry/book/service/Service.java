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
       Book book3=null;
        for (Book book1 : bookList) {
            if (book1.getIsbnNo() == bookIsbnId) {
                book3 = book1;
                break;
            }
        }
        return book3;
    }

    @Override
    public Book addBook(Book book){
        bookList.add(book);
        return book;
    }


    @Override
    public Book deleteBook(int isbnNo){
        Book bookObj1 = null;
        for(Book bookObj2: bookList){
            if(bookObj2.getIsbnNo() == isbnNo){
                bookObj1 = bookObj2;
                bookList.remove(bookObj1);
                break;
            }
        }
        return bookObj1;
    }
    @Override
    public Book updateBook(int isbnNo,Book book) {
        // Book book1 = null;
        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == isbnNo) {
                bookObj.setIsbnNo(isbnNo);
                bookObj.setBookName(book.getBookName());
                bookObj.setAuthor(book.getAuthor());
                book = bookObj;
                break;
            }
        }
        return book;

    }
}
