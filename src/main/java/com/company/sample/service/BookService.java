package com.company.sample.service;

import com.company.sample.dao.BookRepository;
import com.company.sample.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookRepository bRepository;

    public Book saveBook(Book book){
        return bRepository.save(book);
    }

    public List<Book> saveBooks(List<Book> books){
        return bRepository.saveAll(books);
    }

    public List<Book> getBooks(){
        return bRepository.findAll();
    }

    public Book getBookById(int id){
        return bRepository.findById(id).orElse(null);
    }

    public String deleteBook(int id){
        bRepository.deleteById(id);
        return "Book Removed having id"+id;
    }

    public Book updateBook(Book book){
        Book existingBook=bRepository.findById(book.getBookId()).orElse(null);
        existingBook.setBookName(book.getBookName());
        existingBook.setCourse(book.getCourse());
        return bRepository.save(existingBook);
    }
}
