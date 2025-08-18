package com.example.Book.Service;

import com.example.Book.Repo.AuthorJpaRepo;
import com.example.Book.Repo.AuthorRepo;
import com.example.Book.Repo.BookJpaRepo;
import com.example.Book.modal.AuthorDetails;
import com.example.Book.modal.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorJpaService implements AuthorRepo {
    @Autowired
    BookJpaRepo bookJpaRepo;
    @Autowired
    AuthorJpaRepo authorJpaRepo;
    @Override
    public ArrayList<AuthorDetails> getAuthorDetailss() {
        List<AuthorDetails> authorlist = authorJpaRepo.findAll();
        ArrayList<AuthorDetails> authors = new ArrayList<>(authorlist);
        return authors;

    }

    @Override
    public AuthorDetails getAuthorDetailsById(int authorId) {
        try{
            AuthorDetails authors =authorJpaRepo.findById(authorId).get();
            return authors;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public AuthorDetails addAuthorDetails(AuthorDetails author) {
        authorJpaRepo.save(author);
        return author;
    }

    @Override
    public AuthorDetails updateAuthorDetails(int authorId, AuthorDetails author) {
        try{
            AuthorDetails new_author = authorJpaRepo.findById(authorId).get();
            if(author.getAuthorName()!=null)new_author.setAuthorName(author.getAuthorName());
            authorJpaRepo.save(new_author);
            return new_author;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteAuthorDetails(int authorId) {
        try {
            AuthorDetails authorDetails = authorJpaRepo.findById(authorId).get();
            List< BookDetails> books = authorDetails.getBooks();
            for(BookDetails book:books){
                book.getAuthors().remove(authorDetails);
            }
            bookJpaRepo.saveAll(books);
            authorJpaRepo.deleteById(authorId);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found with ID: " );
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);



    }
}
