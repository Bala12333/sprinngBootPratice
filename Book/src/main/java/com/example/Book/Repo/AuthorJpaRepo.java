package com.example.Book.Repo;

import com.example.Book.modal.AuthorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorJpaRepo extends JpaRepository<AuthorDetails,Integer> {
}
