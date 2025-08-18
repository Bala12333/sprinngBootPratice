package com.example.Book.Controller;


import com.example.Book.Service.BookJpaService;
import com.example.Book.modal.AuthorDetails;
import com.example.Book.modal.PublishersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Book.modal.BookDetails;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookJpaService bookSer;
    @GetMapping("/books")
    public ArrayList<BookDetails> getBooks(){

        return bookSer.getBooks();
    }
    @GetMapping("/books/{bookId}")
    public  BookDetails getBookId(@PathVariable("bookId") int id){

        return bookSer.getBookId(id);
    }
    @PostMapping("/publishers/books")
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
    @GetMapping("/books/{bookId}/publisher")
    public PublishersDetails  getBookPublisher(@PathVariable("bookId") int bookId){

        return bookSer.getBookPublisher(bookId);
    }
    @GetMapping("/books/{bookId}/authors")
    public List<AuthorDetails> getbookAuthors(@PathVariable("bookId") int bookId){
        return bookSer.getBookAuthors(bookId);
    }


}
