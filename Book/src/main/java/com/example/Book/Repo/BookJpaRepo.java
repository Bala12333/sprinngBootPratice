package com.example.Book.Repo;


import com.example.Book.modal.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJpaRepo extends JpaRepository<BookDetails,Integer>{
}
