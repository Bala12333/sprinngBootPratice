package com.example.Book;

import java.util.ArrayList;
import com.example.Book.BookDetails;

public interface BookRepo {
    ArrayList<BookDetails> getBooks();
    BookDetails getBookId(int id);

    BookDetails add_book(BookDetails book);
    BookDetails update_Book(int id,BookDetails book);
}

