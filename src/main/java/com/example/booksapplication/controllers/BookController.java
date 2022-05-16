package com.example.booksapplication.controllers;

import com.example.booksapplication.domains.Book;
import com.example.booksapplication.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books-v1")
public class BookController {

    private final BookService bookService;

    static {
        System.out.println("3. class BookController() called...");
    }

    public BookController(BookService bookService) {
        System.out.println("constructor BookController() called...");
        this.bookService = bookService;
//        System.out.println(this.bookService.getClass());
    }

    @GetMapping("/")
    public List<Book> list() {
        return bookService.list();
    }

    @GetMapping("/hello")
    public String hello() {
        String res = "Mock";
//        return String.format("Hello, %s!", bookService.getClass());
        return String.format("Hello, %s", res);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable int id) {
        return bookService.get(id);
    }

    @PostMapping
    public void create(@RequestBody Book book) {
        bookService.create(book);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Book book, @PathVariable int id) {
        bookService.update(book, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }

}
