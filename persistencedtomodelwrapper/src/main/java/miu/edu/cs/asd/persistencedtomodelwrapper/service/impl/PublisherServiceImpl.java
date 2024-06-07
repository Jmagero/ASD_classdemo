package miu.edu.cs.asd.persistencedtomodelwrapper.service.impl;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import miu.edu.cs.asd.persistencedtomodelwrapper.dto.AddressDTO;
import miu.edu.cs.asd.persistencedtomodelwrapper.dto.PublisherDTO;
import miu.edu.cs.asd.persistencedtomodelwrapper.model.Publisher;
import miu.edu.cs.asd.persistencedtomodelwrapper.repository.PublisherRepository;
import miu.edu.cs.asd.persistencedtomodelwrapper.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
@Builder
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final ModelMapper modelMapper;
    @Override
    public Optional<PublisherDTO> addPublisher(PublisherDTO publisherDTO) {
        //Mapping from PublisherDTO to Publisher
        Publisher publisher = modelMapper.map(publisherDTO, Publisher.class);
        publisher.getPublisherAddress().setPublisher(publisher);
        publisherRepository.save(publisher);
        //Mapping from Publisher to PublisherDTO
        PublisherDTO responsePublisherDto = modelMapper.map(publisher, PublisherDTO.class);
        return Optional.of(responsePublisherDto);
    }

    @Override
    public Optional<PublisherDTO> updatePublisher(String publisherName, PublisherDTO publisherDTO) {
        Optional<Publisher> foundPublisher = publisherRepository.findByPublisherName(publisherName);
        if (foundPublisher.isPresent()) {
            Publisher publisher = foundPublisher.get();
            modelMapper.map(publisherDTO, publisher);
            Publisher modifiedPublisher = publisherRepository.save(foundPublisher.get());
            PublisherDTO responsePublisherDto = modelMapper.map(modifiedPublisher, PublisherDTO.class);
            return Optional.of(responsePublisherDto);
        }
        return Optional.empty();
    }

    @Override
    public void deletePublisher(PublisherDTO publisherDTO) {
        Optional<Publisher> foundPublisher = publisherRepository.findByPublisherName(publisherDTO.getPublisherName());
       if (foundPublisher.isPresent()) {
           Publisher publisher = foundPublisher.get();
           modelMapper.map(publisherDTO, publisher);
           publisherRepository.delete(foundPublisher.get());
       }
    }

    @Override
    public Optional<PublisherDTO> findPublisherByName(String publisherName) {
        Optional<Publisher> foundPublisher = publisherRepository.findByPublisherName(publisherName);
        if (foundPublisher.isPresent()) {
            Publisher publisher = foundPublisher.get();
            PublisherDTO responsePublisherDTO = modelMapper.map(publisher, PublisherDTO.class);
            return Optional.of(responsePublisherDTO);
        }
        return Optional.empty();
    }
}
