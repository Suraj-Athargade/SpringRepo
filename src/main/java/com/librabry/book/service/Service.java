package com.librabry.book.service;

import com.librabry.book.BookException.BookException;
import com.librabry.book.entities.Book;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceImpl {
    List<Book> bookList = new ArrayList<>();

    public Service() {
    }


    @Override
    public List<Book> getBook() {
//        if(bookList.isEmpty()){
//                System.out.println("No Book Available..");
//                return null;
//        }
//        else {
            return bookList;
        }


    @Override
    public Book getBook(long bookIsbnId) {
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
        String isbnLen=String.valueOf(book.getIsbnNo());
        try{
                if((isbnLen.length()==10)&&(book.getBookName().length()>4)&& (book.getYearOfPublication()>1980)) {
                    bookList.add(book);
                }else{
                 throw new BookException();
                }
        }catch (BookException e) {
            e.printStackTrace();
        }
        return bookList;
    }


    @Override
    public Book deleteBook(long isbnNo){
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
    public Book updateBook(long isbnNo, Book book) {
         Book book1 = null;
        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == isbnNo) {
                bookObj.setIsbnNo(isbnNo);
                bookObj.setBookName(book.getBookName());
                bookObj.setAuthor(book.getAuthor());
                bookObj.setAuthorId((book.getAuthorId()));
                bookObj.setYearOfPublication((book.getYearOfPublication()));
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
