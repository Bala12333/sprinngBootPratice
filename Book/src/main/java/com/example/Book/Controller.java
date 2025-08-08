package com.example.Book;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Book.BookService;
import com.example.Book.BookDetails;

import java.util.ArrayList;

@RestController
public class Controller {
    BookService bookSer=new BookService();
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
}
