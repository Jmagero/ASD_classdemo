package miu.edu.cs.asd.persistencedtomodelwrapper.service;


import miu.edu.cs.asd.persistencedtomodelwrapper.dto.PublisherDTO;

import java.util.Optional;

public interface PublisherService {
    Optional<PublisherDTO> addPublisher(PublisherDTO publisherDTO);
    Optional<PublisherDTO> updatePublisher(String publisherName, PublisherDTO publisherDTO);
    void deletePublisher(PublisherDTO publisherDTO);
    Optional<PublisherDTO> findPublisherByName(String publisherName);
}
