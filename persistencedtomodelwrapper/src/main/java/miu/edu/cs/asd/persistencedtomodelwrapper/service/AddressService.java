package miu.edu.cs.asd.persistencedtomodelwrapper.service;


import miu.edu.cs.asd.persistencedtomodelwrapper.dto.AddressDTO;

import java.util.Optional;

public interface AddressService {
    Optional<AddressDTO> updateAddress(Integer id, AddressDTO addressDTO);
    Optional<AddressDTO> findAddressById(Integer id);
    Optional<AddressDTO> addAddress(Integer id, AddressDTO addressDTO);


}
