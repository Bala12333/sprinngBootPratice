package com.example.Book.Service;
import com.example.Book.Repo.BookRepo;
import com.example.Book.modal.BookDetails;
import com.example.Book.modal.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
public class H2service implements BookRepo{
    @Autowired
    private JdbcTemplate db;
    @Override
    public ArrayList<BookDetails> getBooks() {
        List<BookDetails> booksList=db.query("select * from book",new BookRowMapper());
        ArrayList<BookDetails> books=new ArrayList<>(booksList);
        //if (books==null){
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        //}
        return books;
    }

    @Override
    public BookDetails getBookId(int id) {
        try {
            BookDetails book = db.queryForObject("select *  from book where id = ?", new BookRowMapper(), id);

            return book;
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);


        }
    }

    @Override
    public BookDetails add_book(BookDetails book) {
        db.update("insert into book(name,imageUrl) values (?,?)",book.getName(),book.getImageUrl());
        BookDetails saveBook=db.queryForObject("select * from book where name = ? and imageUrl=?",
                new BookRowMapper(),book.getName(),book.getImageUrl()
        );
        return saveBook ;
    }

    @Override
    public BookDetails update_Book(int id, BookDetails book) {
        if (book.getImageUrl()!=null){
            db.update("update book set imageUrl=? where id =?",book.getImageUrl(),id);
        }
        if (book.getName()!=null){
            db.update("update book set name = ? where id = ?",book.getName(),id);
    }
        return getBookId(id);
    }

    @Override
    public void delete_Book(int id) {
        db.update("delete from book where id =?",id);

    }
}
