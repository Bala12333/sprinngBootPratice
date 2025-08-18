package com.example.Book.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class AuthorDetails {
    @Id
    @Column(name = "authorid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    @Column(name = " authorname")
    private String authorName;
    @ManyToMany(mappedBy = "authors")
    @JsonIgnoreProperties("authors")
    private List<BookDetails> books = new ArrayList<>();

    public AuthorDetails() {

    }

    public AuthorDetails(int authorid, String authorName, List<BookDetails> books) {
        this.books = books;
        this.authorId = authorid;
        this.authorName = authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorIdId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<BookDetails> getBooks() {
        return books;
    }

    public void setBooks(List<BookDetails> books) {
        this.books = books;
    }


}
