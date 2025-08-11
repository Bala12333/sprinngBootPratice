package com.example.Book.Service;

import java.util.*;

import com.example.Book.Repo.BookRepo;
import com.example.Book.modal.BookDetails;
import org.springframework.web.server.ResponseStatusException;
import  org.springframework.http.HttpStatus;



public class BookService implements BookRepo {
    int uniId=104;
    private HashMap<Integer,BookDetails> bookMap=new HashMap<>();
    public BookService(){
        BookDetails b1=new BookDetails(101,"Psychology of Money","Psychology_of_Money.png");
        BookDetails b2=new BookDetails(102,"Rich Dad Poor Dad","Rich_Dad_Poor_Dad.jpg");
        BookDetails b3=new BookDetails(103,"Your Money or Your Life","Your_Money_or_Your_Life.jpg");
        bookMap.put(b1.getId(),b1);
        bookMap.put(b2.getId(),b2);
        bookMap.put(b3.getId(),b3);

    }
    @Override
    public ArrayList<BookDetails>  getBooks(){
        Collection<BookDetails> bookDetailsConnection=bookMap.values();
        ArrayList<BookDetails> books=new ArrayList<>(bookDetailsConnection);
        return  books;

    }
    @Override
    public BookDetails getBookId(int id){
        BookDetails book=bookMap.get(id);
        if (book==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return book;
    }
    @Override
    public  BookDetails add_book(BookDetails book){
        book.setId(uniId);
        bookMap.put(uniId,book);
        uniId+=1;

        return book;
    }

    @Override
    public BookDetails update_Book(int id, BookDetails book) {
        BookDetails exist_Book=bookMap.get(id);
        if (exist_Book==null){
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
        if (book.getImageUrl()!=null){
            exist_Book.setImageUrl(book.getImageUrl());

        }
        if (book.getName()!=null){
            exist_Book.setName(book.getName());


        }

        return exist_Book;

    }

    @Override
    public void delete_Book(int id) {
        BookDetails book=bookMap.get(id);
        if (book==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        else {
            bookMap.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }


}
