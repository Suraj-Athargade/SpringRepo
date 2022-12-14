package com.librabry.book.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.librabry.book.BookException.EmptyListException;
import com.librabry.book.BookException.InvalidEntryException;
import com.librabry.book.controller.Controller;
import com.librabry.book.entities.Book;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.OrientationRequested;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
class ServiceImplTest {
Book book;
@Autowired
ServiceImpl service;

@Autowired
MockMvc mockMvc;

@Autowired
ServiceInterface serviceInterface;

@Autowired
Controller controller;

    @BeforeEach
    public void init(){
        book=new Book();
        book.setIsbnNo(1234567890L);
        book.setBookName("science");
        book.setAuthorName("chetan");
        book.setAuthorId(44);
        book.setYearOfPublication(2002);
    }
    @Order(1)
    @Test
    void getBookEmptyListTest(){
 //       serviceInterface.deleteBook(1234567890L);
        assertThrows(EmptyListException.class,()->serviceInterface.getBooks(),"No books present");
    }
    @Order(2)
    @Test
    void addBookTest() {
      //  book.setBookName("aaa");
        Book actual= serviceInterface.addBook(book);
        Book expected=serviceInterface.getBookByIsbnNo(book.getIsbnNo());
        assertEquals(expected,actual);
        assertThrows(InvalidEntryException.class,()->serviceInterface.addBook(book),"Invalid entry");
    }
    @Order(3)
    @Test
    void addBookAlreadyPresentTest(){
        book.setIsbnNo(7447948890L);
         serviceInterface.addBook(book);
        assertThrows(InvalidEntryException.class,()->serviceInterface.addBook(book),"\"same book is already present \"");
    }
    @Order(4)
    @Test
    void getBookByIsbnNoTest() {
        book.setIsbnNo(9087654321L);
        serviceInterface.addBook(book);
        assertThrows(InvalidEntryException.class,()->serviceInterface.getBookByIsbnNo(999911112223L));
    }
    @Order(5)
    @Test
    void searchByAuthorTest() {
        book.setAuthorName("netaji");
        book.setIsbnNo(8888877777L);
        serviceInterface.addBook(book);
        assertThrows(InvalidEntryException.class,()->serviceInterface.addBook(book),"no book are present in library with this author name");
    }
    @Order(6)
    @Test
    void updateBookTest() {
        book.setIsbnNo(7676767676L);
        book.setBookName("science");
        serviceInterface.addBook(book);
        Book actual=serviceInterface.updateBook(book.getIsbnNo(),book);
        Book expected =serviceInterface.getBookByIsbnNo(book.getIsbnNo());
        assertEquals(expected,actual);
        // assertThrows(InvalidEntryException.class,()->serviceInterface.updateBook(7676767676L,book),"invalid entry");
    }
    @Order(7)
    @Test
    void deleteBookIfPresentTest() {
        assertThrows(InvalidEntryException.class,()->serviceInterface.deleteBook(12345678909L),"invalid entry");
        // assertEquals(expected,actual);
    }
    @ParameterizedTest
    @MethodSource("bookCollection")
    public void bookNotNull(Book book){
        assertNotNull(book);
    }
    public static Stream<Book> bookCollection(){
        return Stream.of(new Book(1234567890L,"Science","suraj", 22,2004));
    }
    @ParameterizedTest
    @MethodSource("bookCollectionNull")
    public void bookNull(Book book){
        assertNull(book);
    }
    public static Stream<Book> bookCollectionNull(){
        return null;
    }


    @ParameterizedTest
    @MethodSource("addBookMethod")
    public void addBookMethodSourceTest(Book book){
        assertThrows(InvalidEntryException.class,()->serviceInterface.addBook(book),"Invalid Entry");
    }
    public static Stream<Book> addBookMethod(){
        return Stream.of(new Book(123567890L,"Science","suraj", 22,2004));
    }

    @ParameterizedTest
    @MethodSource("deleteBookMethod")
    public void deleteBookMethodSourceTest(Book book){
        assertThrows(InvalidEntryException.class,()->serviceInterface.addBook(book),"Invalid Entry");
    }
    public static Stream<Book> deleteBookMethod(){
        return Stream.of(new Book(123567890L,"Science","suraj", 22,2004));
    }

    @ParameterizedTest
    @MethodSource("getBookMethod")
    public void getBooksMethodSourceTest(List<Book> actual){
        book.setIsbnNo(1234567890);
        book.setBookName("hindi");
        book.setAuthorName("Gandhi");
        book.setAuthorId(55);
        book.setYearOfPublication(2002);
        serviceInterface.addBook(book);

        List<Book> expected = serviceInterface.getBooks();
        assertEquals(expected,actual);

    }
    public  List<Book> getBookMethod(){
        return serviceInterface.getBooks();
    }


}