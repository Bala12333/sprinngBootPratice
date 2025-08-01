package com.example.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Book.BookService;

import java.util.ArrayList;

@RestController
public class Controller {
    BookService bookSer=new BookService();
    @GetMapping("/books")
    public ArrayList<BookDetails> getBooks(){

        return bookSer.getBooks();
    }
}
