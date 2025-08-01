package com.example.Book;
import java.util.*;
import com.example.Book.BookDetails;


public class BookService {
    private HashMap<Integer,BookDetails> hm=new HashMap<>();
    public BookService(){
        BookDetails b1=new BookDetails(101,"Psychology of Money","Psychology_of_Money.png");
        BookDetails b2=new BookDetails(102,"Rich Dad Poor Dad","Rich_Dad_Poor_Dad.jpg");
        BookDetails b3=new BookDetails(103,"Your Money or Your Life","Your_Money_or_Your_Life.jpg");
        hm.put(b1.getId(),b1);
        hm.put(b2.getId(),b2);
        hm.put(b3.getId(),b3);

    }
}
