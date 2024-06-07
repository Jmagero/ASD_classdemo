package miu.edu.cs.asd.persistencedtomodelwrapper.config;

import miu.edu.cs.asd.persistencedtomodelwrapper.dto.PublisherDTO;
import miu.edu.cs.asd.persistencedtomodelwrapper.model.Publisher;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper =  new ModelMapper();
        //Publisher to PublisherDTO
        modelMapper.addMappings(
                new PropertyMap<Publisher, PublisherDTO>() {

                    @Override
                    protected void configure() {
                        map()
                                .getAddressDTO()
                                .setCity(
                                        source  //source is Publisher
                                                .getPublisherAddress().getCity());
                        map().getAddressDTO().setStreet(source.getPublisherAddress().getStreet());
                        map().getAddressDTO().setState(source.getPublisherAddress().getState());
                    }
                }
        );
        //PublisherDTO to Publisher
        modelMapper.addMappings(
                new PropertyMap<PublisherDTO, Publisher>() {

                    @Override
                    protected void configure() {
                        //map is a function that returns destination object
                        map()
                                .getPublisherAddress()
                                .setCity(
                                        source
                                                .getAddressDTO()
                                                .getCity());
                        map().getPublisherAddress().setStreet(source.getAddressDTO().getStreet());
                        map().getPublisherAddress().setState(source.getAddressDTO().getState());
                    }
                }
        );
        return modelMapper;
    }
}
