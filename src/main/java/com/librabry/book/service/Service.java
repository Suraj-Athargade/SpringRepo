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







    }
