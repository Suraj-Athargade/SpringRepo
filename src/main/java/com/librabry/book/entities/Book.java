package com.librabry.book.entities;

public class Book {
    private long isbnNo;
    private String  bookName;
    private String author;

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

    public Book() {
    }

    public Book(long isbnNo, String bookName, String author) {
        this.isbnNo = isbnNo;
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book[ " +
                "\n isbnNo=" + isbnNo +
                ",\n bookName='" + bookName + '\'' +
                ",\n author='" + author + '\'' +
                ']';
    }

}
