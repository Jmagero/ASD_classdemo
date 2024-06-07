package miu.edu.cs.asd.datapersistencedto;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.datapersistencedto.dto.AddressDTO;
import miu.edu.cs.asd.datapersistencedto.dto.PublisherDTO;
import miu.edu.cs.asd.datapersistencedto.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DatapersistencedemoApplication implements CommandLineRunner {
    private final PublisherService publisherService;


    public static void main(String[] args) {
        SpringApplication.run(DatapersistencedemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setPublisherName("Apres");

        AddressDTO addressDTO = new AddressDTO(
                "2000 N Court",
                "Fairfield",
                "IA"
        );
        publisherDTO.setAddressDTO(addressDTO);
        System.out.println(
                publisherService.addPublisher(publisherDTO) + " is saved"
        );
        //Update from Apres to Apres

        PublisherDTO publisherDTO2 = new PublisherDTO("New Apres");
        //Here the associated addressDto is null
        System.out.println(
                publisherService.updatePublisher("Apres", publisherDTO2) + " is updated"
        );
        System.out.println(publisherService.findPublisherByName("New Apres") + " is found");


    }
}
