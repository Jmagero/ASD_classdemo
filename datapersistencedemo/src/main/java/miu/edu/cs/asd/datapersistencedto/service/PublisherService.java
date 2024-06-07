package miu.edu.cs.asd.datapersistencedto.service;

import miu.edu.cs.asd.datapersistencedto.dto.PublisherDTO;

import java.util.Optional;

public interface PublisherService {
    Optional<PublisherDTO> addPublisher(PublisherDTO publisherDTO);
    Optional<PublisherDTO> updatePublisher(String publisherName, PublisherDTO publisherDTO);
    Optional<PublisherDTO> deletePublisher(PublisherDTO publisherDTO);
    Optional<PublisherDTO> findPublisherByName(String publisherName);
}
