package com.example.Book.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
public class BookDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;
    @Column(name = "name")
    private String name;
    @Column(name="imageurl")
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "publisherid")
    private PublishersDetails publisher;
    @ManyToMany
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "bookid"),
            inverseJoinColumns = @JoinColumn(name = "authorid")

    )
    @JsonIgnoreProperties("books")
    private List<AuthorDetails> authors =new ArrayList<>();
    public BookDetails(int id,String name,String imageUrl,PublishersDetails publisher,List<AuthorDetails> authors){
        this.name=name;
        this.id=id;
        this.publisher=publisher;
        this.imageUrl=imageUrl;
        this.authors=authors;
    }

    public BookDetails() {

    }

    public void setId(int id){
        this.id=id;

    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String  getName(){
        return name;

    }

    public String getImageUrl() {
        return imageUrl;
    }

     public PublishersDetails getPublisher(){
        return publisher;
     }

    public void setPublisher(PublishersDetails publisher) {

        this.publisher=publisher;
    }

    public List<AuthorDetails> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDetails> authors) {
        this.authors = authors;
    }
}
