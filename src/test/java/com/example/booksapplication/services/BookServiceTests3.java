package com.example.booksapplication.services;

import java.util.List;

import com.example.booksapplication.domains.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookServiceTests3 {
	@Mock
	List<Book> books;
	@InjectMocks
	BookService bookService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testList() {
		List<Book> result = bookService.list();
		Assertions.assertEquals(List.of(new Book(0, "name", "author")), result);
	}

	@Test
	void testGet() {
		Book result = bookService.get(0);
		Assertions.assertEquals(new Book(0, null, null), result);
	}

	@Test
	void testCreate() {
		bookService.create(new Book(0, null, null));
	}

	@Test
	void testUpdate() {
		bookService.update(new Book(0, null, null), 0);
	}

	@Test
	void testDelete() {
		bookService.delete(0);
	}

	@Test
	void testGreet() {
		String result = bookService.greet();
		Assertions.assertEquals("replaceMeWithExpectedResult", result);
	}
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme