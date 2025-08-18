package com.example.Book.Repo;

import com.example.Book.modal.PublishersDetails;

import java.util.*;

public interface PublsherRepo  {

    ArrayList<PublishersDetails> getPublishers();

    PublishersDetails    getPublisherById(Integer publisherId);

    PublishersDetails addPublisher(PublishersDetails publisher);

    PublishersDetails updatePublisher(int publisherId, PublishersDetails publisher);

    void deletePublisher(int publisherId);
}
