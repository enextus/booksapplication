package com.example.booksapplication;

import com.example.booksapplication.domains.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookTest {

    Book book = new Book(1, "Hacking with Spring Boot 2.3", "Greg L. Turnquist");

    @DisplayName("getId by book")
    @Test
    void getId() {
        assertEquals(1, book.getId());
    }

    @DisplayName("getName by book")
    @Test
    void getName() {
        String res = "Hacking with Spring Boot 2.3";
        assertEquals(res, book.getName());
    }
}