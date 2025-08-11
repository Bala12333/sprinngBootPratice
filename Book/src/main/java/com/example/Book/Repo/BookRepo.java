package com.example.Book.Repo;

import java.util.ArrayList;
import com.example.Book.modal.BookDetails;

public interface BookRepo {
    ArrayList<BookDetails> getBooks();
    BookDetails getBookId(int id);

    BookDetails add_book(BookDetails book);
    BookDetails update_Book(int id,BookDetails book);
    void delete_Book(int id);
}

