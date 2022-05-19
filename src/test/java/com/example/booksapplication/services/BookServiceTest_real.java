package com.example.booksapplication.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest_real {

    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
    }

    @DisplayName("bookService list size")
    @Test
    void list() {
        int res = 5;
        assertEquals(res, bookService.list().size());
    }

    @DisplayName("bookService check id 1")
    @Test
    void get() {
        int id = 1;
        int res = 1;
        assertEquals(res, bookService.get(id).getId());
    }

    @DisplayName("bookService check name by id")
    @Test
    void getNameById() {
        int id = 1;
        String res = "Hacking with Spring Boot 2.3";
        assertEquals(res, bookService.get(id).getName());
    }

}
