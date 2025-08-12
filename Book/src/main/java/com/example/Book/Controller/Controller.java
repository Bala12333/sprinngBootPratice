package com.example.Book.Controller;


import com.example.Book.Service.H2service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Book.Service.BookService;
import com.example.Book.modal.BookDetails;

import java.util.ArrayList;


@RestController
public class Controller {
    @Autowired
    H2service bookSer;
    @GetMapping("/books")
    public ArrayList<BookDetails> getBooks(){

        return bookSer.getBooks();
    }
    @GetMapping("/books/{bookId}")
    public  BookDetails getBookId(@PathVariable("bookId") int id){

        return bookSer.getBookId(id);
    }
    @PostMapping("/books")
    public BookDetails add_book(@RequestBody BookDetails book){
       return bookSer.add_book(book);



    }
    @PutMapping("/books/{bookId}")
    public BookDetails update_Book(@PathVariable("bookId") int id,@RequestBody BookDetails book){
        return bookSer.update_Book(id,book);
    }
    @DeleteMapping("/books/{bookId}")
    public void delete_Book(@PathVariable("bookId") int id){
        bookSer.delete_Book(id);


    }
}
