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
        try{
            if(bookList.isEmpty()){
                throw new EmptyListException("No books present");
            }
        }catch (EmptyListException e){
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
    public String addBook(Book book){
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
        return "Successfully added....";
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
    public String updateBook(long isbnNo, Book book) {

        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == isbnNo) {
                bookObj.setIsbnNo(isbnNo);
                bookObj.setBookName(book.getBookName());
                bookObj.setAuthor(book.getAuthor());
                bookObj.setAuthorId((book.getAuthorId()));
                bookObj.setYearOfPublication((book.getYearOfPublication()));
                book1 = bookObj;
                System.out.println("successfully updated the existing entry ");
                break;
            }
        }
        return "successfully updated the existing entry ";

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
