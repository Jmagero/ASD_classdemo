package miu.edu.cs.asd.persistencedtomodelwrapper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PublisherDTO {
    private String publisherName;
    private AddressDTO addressDTO;

    public PublisherDTO(String publisherName) {
        this.publisherName = publisherName;
    }

}
