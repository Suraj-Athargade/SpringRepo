package com.librabry.book.service;

import com.librabry.book.BookException.EmptyListException;
import com.librabry.book.BookException.InvalidEntryException;
import com.librabry.book.entities.Book;



import java.util.ArrayList;

import java.util.List;





@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceInterface {
    List<Book> bookList = new ArrayList<>();
    public ServiceImpl() {
      //  bookList.add(new Book(1234567890,"maths","michel",22,2001));
    }


    @Override
    public List<Book> getBook() {
        try {
            if (bookList.isEmpty()) {
                throw new EmptyListException("No Book are present ...");
            }
            }catch (EmptyListException e) {
            System.out.println(e);
        }
        return bookList;
    }
    @Override
    public Book getBook(long bookIsbnId) {
       Book book=null;

        for (Book bookObj : bookList) {
            try {
                if (bookObj.getIsbnNo() == bookIsbnId) {
                    book = bookObj;
                    break;
                }else {
                    throw new InvalidEntryException("Invalid Isbn No");
                }
            }catch(InvalidEntryException e)
            {
                System.out.println(e);}
        }
        return book;
    }

    @Override
    public List<Book> addBook(Book book){
        String isbnLen=String.valueOf(book.getIsbnNo());
        try{
                if(isbnLen.length()!=10) {
                    throw new InvalidEntryException("IsbnNumber must be of 10 digits...");}
                if(!(book.getBookName().length()>4)) {
                    throw new InvalidEntryException("length of Book Name must be more than 4 character ..");}
                if(!(book.getYearOfPublication()>1980)){
                    throw new InvalidEntryException("this System only accepts entry of Book that are Publish after 1980");}
                else bookList.add(book);
        }catch (InvalidEntryException e) {
            System.out.println(e);
        }
        return bookList;
    }
    @Override
    public String deleteBook(long isbnNo){
        for(Book bookObj2: bookList){
            if(bookObj2.getIsbnNo() == isbnNo){
                bookList.remove(bookObj2);
                break;
            }
        }
        return "successfully deleted.....";
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
