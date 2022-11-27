package com.librabry.book.BookException;

public class InvalidEntryException extends Exception{

    public InvalidEntryException(String msg) {
        System.out.println(msg);
    }
}
