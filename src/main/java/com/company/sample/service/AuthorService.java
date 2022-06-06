package com.company.sample.service;

import com.company.sample.dao.AuthorRepository;
import com.company.sample.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository aRepository;

    public Author saveAuthor(Author author){
        return aRepository.save(author);
    }

    public List<Author> saveAuthors(List<Author> authors){
        return aRepository.saveAll(authors);
    }

    public List<Author> getAuthors(){
        return aRepository.findAll();
    }

    public Author getAuthorById(int id){
        return aRepository.findById(id).orElse(null);
    }

    public String deleteAuthor(int id){
        aRepository.deleteById(id);
        return "Author Removed having id"+id;
    }

    public Author updateAuthor(Author author){
        Author existingAuthor=aRepository.findById(author.getAuthorId()).orElse(null);
        existingAuthor.setAuthorName(author.getAuthorName());;
        return aRepository.save(existingAuthor);
    }
}
