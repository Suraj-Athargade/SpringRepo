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
        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == bookIsbnId) {
                book = bookObj;
                break;
            }
        }
        return book;
    }

    @Override
    public List<Book> addBook(Book book){
        String name=book.getBookName();
        if(name.length()>4) {
            bookList.add(book);
        }else{
            System.out.println("length must be greater than 4");
        }
        return bookList;
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
    public Book updateBook(int isbnNo, Book book) {
         Book book1 = null;
        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == isbnNo) {
                bookObj.setIsbnNo(isbnNo);
                bookObj.setBookName(book.getBookName());
                bookObj.setAuthor(book.getAuthor());
                book1 = bookObj;
                break;
            }
        }
        return book1;

    }

    @Override
    public Book searchByAuthor(String authorName) {
        Book book=null;
        for(Book bookObj1:bookList){
            if(bookObj1.getAuthor().equalsIgnoreCase(authorName)){
                bookObj1.setAuthor(authorName);
                book=bookObj1;
                break;
            }
        }
        return book;
    }


}
