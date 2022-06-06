package com.company.sample.controller;

import com.company.sample.dto.Book;
import com.company.sample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService service;

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @PostMapping("/addBooks")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return service.saveBooks(books);
    }

    @GetMapping("/books")
    public List<Book> findAllBooks() {
        return service.getBooks();
    }

    @GetMapping("/bookById/{id}")
    public Book findBookById(@PathVariable int id) {
        return service.getBookById(id);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        return service.deleteBook(id);
    }
}
