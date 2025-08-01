package com.example.Book;

import java.util.*;
import com.example.Book.BookDetails;
import com.example.Book.BookRepo;



public class BookService implements BookRepo{
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
        return book;
    }

}
