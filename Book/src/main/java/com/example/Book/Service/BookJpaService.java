package com.example.Book.Service;

import com.example.Book.Repo.AuthorJpaRepo;
import com.example.Book.Repo.BookJpaRepo;
import com.example.Book.Repo.BookRepo;
import com.example.Book.Repo.PublisherJpaRepo;
import com.example.Book.modal.AuthorDetails;
import com.example.Book.modal.BookDetails;
import com.example.Book.modal.PublishersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.*;
@Service
public class BookJpaService implements BookRepo {
    @Autowired
    private AuthorJpaRepo authorJpaRepo;
    @Autowired
    private BookJpaRepo bookJpa;
    @Autowired
    private PublisherJpaRepo publisherJpaRepo;
    @Override
    public ArrayList<BookDetails> getBooks() {
        List<BookDetails> bookList=bookJpa.findAll();
        ArrayList<BookDetails> books=new ArrayList<>(bookList);
        return books;
    }

    @Override
    public BookDetails getBookId(int id) {
        try {
            BookDetails book = bookJpa.findById(id).get();
            return book;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public BookDetails add_book(BookDetails book) {
        PublishersDetails publishersDetails=book.getPublisher();
        int publisherId= publishersDetails.getPublisherId();
        List<Integer> authorIds= new ArrayList<>();
        for (AuthorDetails authorDetails : book.getAuthors()){
            authorIds.add(authorDetails.getAuthorId());

        }

        try{
            List<AuthorDetails> completeAuthor = authorJpaRepo.findAllById(authorIds);
            if(authorIds.size()!= completeAuthor.size()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"some author id is not found");
            }
            book.setAuthors(completeAuthor);
            PublishersDetails newPublishersDetails=publisherJpaRepo.findById(publisherId).get();
            book.setPublisher(newPublishersDetails);
            bookJpa.save(book);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Publisher_id incorrect");
        }
        return book;
    }

    @Override
    public BookDetails update_Book(int id, BookDetails book) {
        try {
            BookDetails newBook = bookJpa.findById(id).get();
            if (book.getName() != null) {
                newBook.setName(book.getName());
            }
            if (book.getImageUrl() != null) {
                newBook.setImageUrl(book.getImageUrl());
            }
           bookJpa.save(newBook);
            return newBook;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void delete_Book(int id) {
        if(!bookJpa.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bookJpa.deleteById(id);
    }



    @Override
    public PublishersDetails getBookPublisher(int bookId) {
        try{
            BookDetails bookDetails=bookJpa.findById(bookId).get();
            return bookDetails.getPublisher();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<AuthorDetails> getBookAuthors(int bookId) {
        try{
            BookDetails book=bookJpa.findById(bookId).get();
            return book.getAuthors();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
}
