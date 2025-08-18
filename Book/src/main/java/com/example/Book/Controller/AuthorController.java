package com.example.Book.Controller;

import com.example.Book.Service.AuthorJpaService;
import com.example.Book.modal.AuthorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AuthorController {
    @Autowired
    AuthorJpaService authorser;

    @GetMapping("/authors")
    public ArrayList<AuthorDetails> getAuthors(){
        return authorser.getAuthorDetailss();
    }

    @GetMapping("/authors/{id}")
    public AuthorDetails getAuthorById(@PathVariable("id") int id){
        return authorser.getAuthorDetailsById(id);
    }

    @PostMapping("/authors")
    public AuthorDetails addAuthor(@RequestBody AuthorDetails author){
        return authorser.addAuthorDetails(author);
    }

    @PutMapping("/authors/{id}")
    public AuthorDetails updateAuthor(@RequestBody AuthorDetails author, @PathVariable("id") int id) {
        return authorser.updateAuthorDetails(id, author);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable("id") int id) {
        authorser.deleteAuthorDetails(id);
    }
}
