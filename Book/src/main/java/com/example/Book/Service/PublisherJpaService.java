package com.example.Book.Service;

import com.example.Book.Repo.PublisherJpaRepo;
import com.example.Book.Repo.PublsherRepo;
import com.example.Book.modal.PublishersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
public class PublisherJpaService implements PublsherRepo {
    @Autowired
    private PublisherJpaRepo publisherJpaRepo;
    @Override
    public ArrayList<PublishersDetails> getPublishers() {
        List<PublishersDetails> publisherList = publisherJpaRepo.findAll();
        ArrayList<PublishersDetails> publishers = new ArrayList<>(publisherList);
        return publishers;
    }

    @Override
    public PublishersDetails getPublisherById(Integer publisherId) {
        try{
            PublishersDetails publisher = publisherJpaRepo.findById(publisherId).get();
            return publisher;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public PublishersDetails addPublisher(PublishersDetails publisher) {
        publisherJpaRepo.save(publisher);
        return publisher;
    }

    @Override
    public PublishersDetails updatePublisher(int publisherId, PublishersDetails publisher) {
        try{
            PublishersDetails new_publisher = publisherJpaRepo.findById(publisherId).get();
            if(publisher.getPublisherName()!=null)new_publisher.setPublisherName(publisher.getPublisherName());
            publisherJpaRepo.save(new_publisher);
            return new_publisher;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePublisher(int publisherId) {
        if(!publisherJpaRepo.existsById(publisherId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        publisherJpaRepo.deleteById(publisherId);

    }
}
