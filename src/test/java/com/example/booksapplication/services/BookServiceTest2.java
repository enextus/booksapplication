package com.example.booksapplication.services;

import java.util.List;

import com.example.booksapplication.domains.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookServiceTest2 {

	private BookService bookServiceUnderTest;

	@BeforeEach
	void setUp() {
		bookServiceUnderTest = new BookService();
	}

	@Test
	void testList() {
		// Setup
		// Run the test
		final List<Book> result = bookServiceUnderTest.list();

		// Verify the results
	}

	@Test
	void testGet() {
		// Setup
		// Run the test
		final Book result = bookServiceUnderTest.get(0);

		// Verify the results
	}

	@Test
	void testCreate() {
		// Setup
		final Book book = new Book(0, "name", "author");

		// Run the test
		bookServiceUnderTest.create(book);

		// Verify the results
	}

	@Test
	void testUpdate() {
		// Setup
		final Book book = new Book(0, "name", "author");

		// Run the test
		bookServiceUnderTest.update(book, 0);

		// Verify the results
	}

	@Test
	void testDelete() {
		// Setup
		// Run the test
		bookServiceUnderTest.delete(0);

		// Verify the results
	}

	@Test
	void testGreet() {
		assertThat(bookServiceUnderTest.greet()).isEqualTo("Hello, Mock");
	}

}
