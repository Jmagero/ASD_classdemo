package miu.edu.demo.service;

import miu.edu.demo.model.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    Optional<Publisher> addPublisher(Publisher publisher);
    Optional<Publisher> updatePublisher(Publisher publisher);
    Optional<Publisher> findPublisherByPublisherName(String publisherName);
    void deletePublisher(Publisher publisher);
    List<Publisher> getAllPublisher();

}
