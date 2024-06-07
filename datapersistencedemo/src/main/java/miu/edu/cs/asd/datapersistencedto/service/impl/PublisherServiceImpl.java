package miu.edu.cs.asd.datapersistencedto.service.impl;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.datapersistencedto.dto.AddressDTO;
import miu.edu.cs.asd.datapersistencedto.dto.PublisherDTO;
import miu.edu.cs.asd.datapersistencedto.model.Address;
import miu.edu.cs.asd.datapersistencedto.model.Publisher;
import miu.edu.cs.asd.datapersistencedto.repository.PublisherRepository;
import miu.edu.cs.asd.datapersistencedto.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
@Builder
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    @Override
    public Optional<PublisherDTO> addPublisher(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        publisher.setPublisherName(publisherDTO.getPublisherName());
        Address address = new Address();
        address.setCity(publisherDTO.getAddressDTO().getCity());
        address.setState(publisherDTO.getAddressDTO().getState());
        address.setStreet(publisherDTO.getAddressDTO().getStreet());
        publisher.setPublisherAddress(address);
        publisher.getPublisherAddress().setPublisher(publisher);
        Publisher savedPublisher = publisherRepository.save(publisher);
        PublisherDTO responsePublisherDTO = new PublisherDTO();
        responsePublisherDTO.setPublisherName(savedPublisher.getPublisherName());
        responsePublisherDTO.setAddressDTO(
                new AddressDTO(
                        savedPublisher.getPublisherAddress().getStreet(),
                        savedPublisher.getPublisherAddress().getCity(),
                        savedPublisher.getPublisherAddress().getState()
                )
        );

        return Optional.of(responsePublisherDTO);
    }

    @Override
    public Optional<PublisherDTO> updatePublisher(String publisherName, PublisherDTO publisherDTO) {
        Optional<Publisher> foundPublisher = publisherRepository.findByPublisherName(publisherName);
        if (foundPublisher.isPresent()) {
            Publisher publisher = foundPublisher.get();
            publisher.setPublisherName(publisherDTO.getPublisherName());
//            if(!publisherDTO.getAddressDTO().getCity().equals(publisherDTO.getAddressDTO().getCity())){
//                publisher.setPublisherAddress(
//                        new Address(publisherDTO.getAddressDTO().getStreet(),
//                                publisherDTO.getAddressDTO().getState() ,
//                                publisherDTO.getAddressDTO().getCity()
//                        ));
//
//            }
           Publisher modifiedPublisher =  publisherRepository.save(foundPublisher.get());
           PublisherDTO responsePublisherDTO = new PublisherDTO();
           responsePublisherDTO.setPublisherName(modifiedPublisher.getPublisherName());
           responsePublisherDTO.setAddressDTO(
                   new AddressDTO(
                   publisher.getPublisherAddress().getCity(),
                   publisher.getPublisherAddress().getStreet(),
                   publisher.getPublisherAddress().getState()
           ));
           return Optional.of(responsePublisherDTO);
        }

        return Optional.empty();
    }

    @Override
    public Optional<PublisherDTO> deletePublisher(PublisherDTO publisherDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<PublisherDTO> findPublisherByName(String publisherName) {
        Optional<Publisher> foundPublisher = publisherRepository.findByPublisherName(publisherName);
        if (foundPublisher.isPresent()) {
            PublisherDTO responsePublisherDTO = new PublisherDTO();
            responsePublisherDTO.setPublisherName(publisherName);
            responsePublisherDTO.setAddressDTO(
                    new AddressDTO(
                            foundPublisher.get().getPublisherAddress().getStreet(),
                            foundPublisher.get().getPublisherAddress().getCity(),
                            foundPublisher.get().getPublisherAddress().getState()
                    )
            );
            return Optional.of(responsePublisherDTO);
        }
        return Optional.empty();
    }
}
