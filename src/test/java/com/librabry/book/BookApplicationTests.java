package com.librabry.book;

import com.librabry.book.entities.Book;
import com.librabry.book.service.ServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookApplicationTests {
	@Autowired
	private ServiceImpl serviceImpl;

	@Test
	void contextLoads() {
	}

//	@BeforeAll
//	 void init(){Book book=new Book();}

	@Test
	void addBook() {
		Book book=new Book();
		book.setIsbnNo(1234567890L);
		book.setBookName("science");
		book.setAuthor("mahesh");
		book.setAuthorId(55);
		book.setYearOfPublication(2001);
		Book expected=serviceImpl.addBook(book);
		Book actual=serviceImpl.getBookByIsbnNo(expected.getIsbnNo());
		//  assertEquals(expected,actual);
		assertEquals(expected.getIsbnNo(),actual.getIsbnNo());
		//  assertThrows(NullPointerException.class,()->{serviceImpl.getBookByIsbnNo(1234567890);});

	}
	@Test
	void searchByAuthor() {
	//	List<Book> list=new ArrayList<>();

		Book book=new Book();
		book.setIsbnNo(1234567890L);
		book.setBookName("science");
		book.setAuthor("mahesh");
		book.setAuthorId(55);
		book.setYearOfPublication(2001);
		serviceImpl.addBook(book);
	List<Book> expected =  serviceImpl.searchByAuthor(book.getAuthor());
	List<Book> actual=  serviceImpl.searchByAuthor(book.getAuthor());
	assertEquals(expected,actual);



	}

}
