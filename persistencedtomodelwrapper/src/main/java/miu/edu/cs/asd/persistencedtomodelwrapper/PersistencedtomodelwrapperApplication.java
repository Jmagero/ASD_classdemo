package miu.edu.cs.asd.persistencedtomodelwrapper;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.persistencedtomodelwrapper.dto.AddressDTO;
import miu.edu.cs.asd.persistencedtomodelwrapper.dto.PublisherDTO;
import miu.edu.cs.asd.persistencedtomodelwrapper.repository.PublisherRepository;
import miu.edu.cs.asd.persistencedtomodelwrapper.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class PersistencedtomodelwrapperApplication implements CommandLineRunner {
    private  final PublisherRepository publisherRepository;
    private final PublisherService publisherService;

    public static void main(String[] args) {
        SpringApplication.run(PersistencedtomodelwrapperApplication.class, args);
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
                publisherService.addPublisher(publisherDTO)
        );
        //Update from Apres to Apres

        PublisherDTO publisherDTO2 = new PublisherDTO("New Apres");
        //Here the associated addressDto is null
        System.out.println(
                publisherService.updatePublisher("Apres", publisherDTO2) + " is updated"
        );
        System.out.println(publisherService.findPublisherByName("New Apres") + " is found");
        publisherService.deletePublisher(publisherDTO2);
        System.out.println(publisherService.findPublisherByName("New Apres"));
//
   }
}
