package miu.edu.demo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.demo.model.Publisher;
import miu.edu.demo.repository.PublisherRepository;
import miu.edu.demo.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PubliserServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    @Override
    public Optional<Publisher> addPublisher(Publisher publisher) {
        Publisher publisher1 = publisherRepository.save(publisher);
        return Optional.of(publisher1);
    }

    @Override
    public Optional<Publisher> updatePublisher(Publisher publisher) {
        Optional<Publisher> publisher1 = publisherRepository.findPublisherByPublisherName(publisher.getPublisherName());
        if(publisher1.isPresent()){
            Publisher updatedPublisher = publisher1.get();
            updatedPublisher.setPublisherId(publisher.getPublisherId());
            updatedPublisher.setPublisherName(publisher.getPublisherName());
            return Optional.of(publisherRepository.save(updatedPublisher));
        }
        return  Optional.empty();
    }

    @Override
    public Optional<Publisher> findPublisherByPublisherName(String publisherName) {
       return publisherRepository.findPublisherByPublisherName(publisherName);

    }

    @Override
    public void deletePublisher(Publisher publisher) {
        publisherRepository.delete(publisher);
    }

    @Override
    public List<Publisher> getAllPublisher() {
        return null;
    }
}
