package miu.edu.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "publishers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;
    @Column(unique = true, nullable = false)
    @NotBlank(message = "Publisher name cannot be blank")
    private String publisherName;
    @OneToOne(cascade = CascadeType.PERSIST, fetch =  FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    public Publisher(String publisherName, Address address) {
        this.publisherName = publisherName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", publisherName='" + publisherName + '\'' +
                ", address=" + address +
                '}';
    }
}
