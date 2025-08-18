package com.example.Book.Controller;

import com.example.Book.Service.PublisherJpaService;
import com.example.Book.modal.PublishersDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PublisherController {
    @Autowired
    PublisherJpaService publisherService;
    @GetMapping("/publishers")
    public ArrayList<PublishersDetails> getPublishers(){
        return publisherService.getPublishers();
    }
    @GetMapping("/publishers/{publisherId}")
    public PublishersDetails getPublisherById(@PathVariable("publisherId") int publisherId) {
        return publisherService.getPublisherById(publisherId);

    }
    @PostMapping("/publishers")
    public PublishersDetails addPublisher(@RequestBody PublishersDetails publisher){
        return publisherService.addPublisher(publisher);
    }
    @PutMapping("/publishers/{publisherId}")
    public PublishersDetails updatePublisher(@RequestBody PublishersDetails publisher, @PathVariable("publisherId") int publisherId) {
        return publisherService.updatePublisher(publisherId, publisher);
    }
    @DeleteMapping("/publishers/{publisherId}")
    public void deletePublisher(@PathVariable("publisherId") int publisherId){
        publisherService.deletePublisher(publisherId);

    }
}
