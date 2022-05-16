package com.example.booksapplication.services;

import com.example.booksapplication.domains.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final List<Book> books;

    static {
        System.out.println("2. class BookService() called...");
    }

    public BookService() {
        System.out.println("constructor BookService() called...");
        books = new ArrayList<>();
        books.add(new Book(1, "Hacking with Spring Boot 2.3", "Greg L. Turnquist"));
        books.add(new Book(2, "97 Things Every Java Programmer Should Know", "Kevlin Henney and Trisha Gee"));
        books.add(new Book(3, "Spring Boot: Up and Running", "Greg L. Turnquist "));
        books.add(new Book(4, "Spring", "L. Turnquist "));
        books.add(new Book(5, "BootRunning", "Greg"));
    }

    public List<Book> list() {
        return books;
    }

    public Book get(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    public void create(Book book) {
        if (book != null) {
            book.setId(books.size() + 1);
            books.add(book);
        }
    }

    public void update(Book book, int id) {
        books.stream().filter(b -> b.getId() == id).findFirst().ifPresent(currentBook -> books.set(books.indexOf(currentBook), book));
    }

    public void delete(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public String greet() {
        return "Hello, Mock";
    }

}
