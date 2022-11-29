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
    public List<Book> getBook()  {

        return bookList;
    }
    @Override
    public Book getBook(long bookIsbnId) throws  InvalidEntryException{
       Book book=null;
        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == bookIsbnId) {
                book = bookObj;
                break;
           }else
                throw new InvalidEntryException("Invalid Isbn No");
        }
        return book;
    }

    @Override
    public String addBook(Book book) throws InvalidEntryException{
        String isbnLen=String.valueOf(book.getIsbnNo());
        String authorId=String.valueOf(book.getAuthorId());
        String regex="^[a-zA-Z0-9]*$";

        for(Book bookobj:bookList){
           if( book.getIsbnNo()==bookobj.getIsbnNo())
               throw new InvalidEntryException("same book is already present ");
        }
                if(isbnLen.length()!=10) {
                    throw new InvalidEntryException("IsbnNumber must be of 10 digits...");}
                if(!(book.getBookName().length()>4)) {
                    throw new InvalidEntryException("length of Book Name must be more than 4 character ..");}
                if(!(book.getYearOfPublication()>1980)){
                    throw new InvalidEntryException("this System only accepts entry of Book that are Publish after 1980");}
                if((authorId.length()==3) || authorId.matches(regex)){
                    throw  new InvalidEntryException("Author Id is invalid");}
                else bookList.add(book);
        return "Successfully added....";
    }
    @Override
    public String deleteBook(long isbnNo){
        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == isbnNo) {
                bookList.remove(bookObj);
                break;
            }else
                throw new InvalidEntryException("Invalid Isbn No");
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
                break;
            }
        }
        return "successfully updated the existing entry ";

    }

    @Override
    public String searchByAuthor(String authorName) {

        for(Book bookObj1:bookList){
            if(bookObj1.getAuthor().equalsIgnoreCase(authorName)){
                bookObj1.setAuthor(authorName);
                break;
            }else throw new InvalidEntryException("no book are present in library with author name "+authorName);
        }
        return "successfully added";
    }


}
