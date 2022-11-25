package com.librabry.book.BookException;

public class InvalidEntryException extends Exception{
    public InvalidEntryException(){
        super("Invalid Entry " +
                "/n 1.Book Name must be of length more than 4" +
                "/n 2.IsbnNumber must be of length 10" +
                "/n 3.year of publication must be of year after 1980");
    }

}
