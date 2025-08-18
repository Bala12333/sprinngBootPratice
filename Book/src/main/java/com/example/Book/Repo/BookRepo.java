package com.example.Book.Repo;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;

import com.example.Book.modal.AuthorDetails;
import com.example.Book.modal.BookDetails;
import com.example.Book.modal.PublishersDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo {
    ArrayList<BookDetails> getBooks();
    BookDetails getBookId(int id);

    BookDetails add_book(BookDetails book);
    BookDetails update_Book(int id,BookDetails book);
    void delete_Book(int id);
    PublishersDetails getBookPublisher(int bookId);
    List<AuthorDetails> getBookAuthors (int bookId);
}

