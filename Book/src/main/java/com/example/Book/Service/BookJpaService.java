package com.example.Book.Service;

import com.example.Book.Repo.BookJpaRepo;
import com.example.Book.Repo.BookRepo;
import com.example.Book.modal.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
public class BookJpaService implements BookRepo {
    @Autowired
    private BookJpaRepo JpaRepo;
    @Override
    public ArrayList<BookDetails> getBooks() {
        List<BookDetails> listBook = JpaRepo.findAll();
        ArrayList<BookDetails> book=new ArrayList<>(listBook);
        return book;
    }

    @Override
    public BookDetails getBookId(int id) {
        try{
            BookDetails book=JpaRepo.findById(id).get();
            return book;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public BookDetails add_book(BookDetails book) {
        JpaRepo.save(book);
        return book;
    }

    @Override
    public BookDetails update_Book(int id, BookDetails book) {
        try{
            BookDetails existBook=JpaRepo.findById(id).get();
            if (book.getName()!=null){
                existBook.setName(book.getName());
            }
            if (book.getImageUrl()!=null){
                existBook.setName(book.getName());
            }
            JpaRepo.save(existBook);
            return existBook;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }



    }


    @Override
    public void delete_Book(int id) {
        if (!JpaRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        JpaRepo.deleteById(id);
    }

}
