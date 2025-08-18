package com.example.Book.Repo;

import com.example.Book.modal.PublishersDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherJpaRepo extends JpaRepository<PublishersDetails,Integer> {
}
