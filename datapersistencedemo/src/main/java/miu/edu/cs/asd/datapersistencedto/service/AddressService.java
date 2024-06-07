package miu.edu.cs.asd.datapersistencedto.service;

import miu.edu.cs.asd.datapersistencedto.dto.AddressDTO;

import java.util.Optional;

public interface AddressService {
    Optional<AddressDTO> updateAddress(Integer id,AddressDTO addressDTO);
    Optional<AddressDTO> findAddressById(Integer id);
    Optional<AddressDTO> addAddress(Integer id, AddressDTO addressDTO);


}
