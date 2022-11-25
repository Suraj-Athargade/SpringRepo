package com.librabry.book.entities;

import java.util.Date;

public class Book {
    private long isbnNo;
    private String  bookName;
    private String author;

    private int authorId;
    private int yearOfPublication;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }



    public long getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(long isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Book(long isbnNo, String bookName, String author, int authorId, int yearOfPublication) {
        this.isbnNo = isbnNo;
        this.bookName = bookName;
        this.author = author;
        this.authorId = authorId;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbnNo=" + isbnNo +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", authorId=" + authorId +
                ", yearOfPublication=" + yearOfPublication +
                '}';
    }
}
