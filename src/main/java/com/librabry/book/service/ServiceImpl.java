package com.librabry.book.service;

import com.librabry.book.BookException.EmptyListException;
import com.librabry.book.BookException.InvalidEntryException;
import com.librabry.book.controller.Controller;
import com.librabry.book.entities.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
@org.springframework.stereotype.Service
public class ServiceImpl implements ServiceInterface {
    Logger logger = LoggerFactory.getLogger(Controller.class);
    List<Book> bookList = new ArrayList<>();
    public ServiceImpl() {
    }

    /**
     * @return Books list
     * @throws EmptyListException
     */
    @Override
    public List<Book> getBooks()  {
        logger.info("getting book from library ");
        if(bookList.isEmpty()){
            throw new EmptyListException("No books present");}
        return bookList;
    }

    /**
     * @param bookIsbnId
     * @return book with given isbn number
     * @throws InvalidEntryException
     */
    @Override
    public Book getBookByIsbnNo(long bookIsbnId){ //todo-done
       Book book=null;
        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == bookIsbnId) {
                book = bookObj;
                break;}
        }
        if(book==null){throw new InvalidEntryException("Invalid Isbn No :-"+bookIsbnId);}
        logger.info("Book with given isbnNo");
        return book;
    }

    /**
     * @param book
     * @return new book object
     * @throws InvalidEntryException
     */
    @Override
    public Book addBook(Book book){
        for(Book bookobj:bookList){//todo
           if( book.getIsbnNo()==bookobj.getIsbnNo())
               throw new InvalidEntryException("same book is already present ");
        }
        String isbnLen=String.valueOf(book.getIsbnNo());
        if(isbnLen.length()!=10) {
                    throw new InvalidEntryException("IsbnNumber must be of 10 digits...");}
        if(!(book.getBookName().length()>4)&&(book.getBookName()!=null)) {
                    throw new InvalidEntryException("length of Book Name must be more than 4 character ..");}
        if(!(book.getYearOfPublication()>1980)){
                    throw new InvalidEntryException("this System only accepts entry of Book that are Publish after 1980");}
        else bookList.add(book);
        logger.info("Book successfully added "+book);//todo-done
        return book;//todo-done
    }

    /**
     *
     * @param isbnNo
     * @return Status of deletion
     * @throws InvalidEntryException
     */
    @Override
    public String deleteBook(long isbnNo){ //todo-don
        Book book=null;
        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == isbnNo) {
                book=bookObj;
                bookList.remove(bookObj);
                break;
            }}
        if(book==null)
        { throw new InvalidEntryException("Invalid ISBN Number or No book is present with this IsbnNo "+isbnNo);}
        logger.info("Book deleted");
        return "deleted";
    }

    /**
     *
     * @param isbnNo
     * @param book
     * @returnstatus of update
     */
    @Override
    public Book updateBook(long isbnNo, Book book) {
        ServiceImpl service=new ServiceImpl();
        for (Book bookObj : bookList) {
            if (bookObj.getIsbnNo() == isbnNo) {
                bookObj.setIsbnNo(isbnNo);//todo-done
                bookObj.setBookName(book.getBookName());
                bookObj.setAuthorName(book.getAuthorName());
                bookObj.setAuthorId((book.getAuthorId()));
                bookObj.setYearOfPublication((book.getYearOfPublication()));
                service.addBook(bookObj);
                break;
            }
        }
        logger.info("successfully updated the existing entry ");
        return book;

    }

    /**
     *
     * @param authorName
     * @return staus of search by author
     * @return InvalidEntryException
     */
    @Override
    public List<Book> searchByAuthor(String authorName) {//todo-done
        List<Book> bookList2 = new ArrayList<>();
        for(Book book1:bookList){
            if (book1.getAuthorName().equals(authorName))
                bookList2.add(book1);
        }
        if(bookList2.isEmpty())
        { throw new InvalidEntryException("no book are present in library with author name "+authorName);}
        logger.info("List of books for given author");
        return bookList2;
    }



}
