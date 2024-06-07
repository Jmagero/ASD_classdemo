package miu.edu.cs.asd.persistencedtomodelwrapper.repository;


import miu.edu.cs.asd.persistencedtomodelwrapper.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByStreet(String street);
}
