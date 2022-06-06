package com.company.sample.controller;

import com.company.sample.dto.Author;
import com.company.sample.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorService service;

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        return service.saveAuthor(author);
    }

    @PostMapping("/addAuthors")
    public List<Author> addAuthors(@RequestBody List<Author> authors) {
        return service.saveAuthors(authors);
    }

    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return service.getAuthors();
    }

    @GetMapping("/authorById/{id}")
    public Author findAuthorById(@PathVariable int id) {
        return service.getAuthorById(id);
    }

    @PutMapping("/update")
    public Author updateAuthor(@RequestBody Author author) {
        return service.updateAuthor(author);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable int id) {
        return service.deleteAuthor(id);
    }
}
