package com.example.Book.Repo;

import com.example.Book.modal.AuthorDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public interface AuthorRepo {
    ArrayList<AuthorDetails> getAuthorDetailss();

    AuthorDetails getAuthorDetailsById(int authorId);

    AuthorDetails addAuthorDetails(AuthorDetails author);

    AuthorDetails updateAuthorDetails(int authorId, AuthorDetails author);

    void deleteAuthorDetails(int authorId);
}
