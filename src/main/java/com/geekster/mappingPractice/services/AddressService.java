package com.geekster.mappingPractice.services;

import com.geekster.mappingPractice.models.Address;
import com.geekster.mappingPractice.repositories.IAddressRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    IAddressRepo addressRepo;
    public void saveAddress(Address address){
        addressRepo.save(address);
    }

    public List<Address> findAllAddress() {
        return addressRepo.findAll();
    }
   @Transactional
    public void updateAddress(Long addressId, String landmark) {
        boolean isValidAddress = addressRepo.existsById(addressId);

        if(!isValidAddress){
            throw new IllegalStateException("Not valid address");
        }
        addressRepo.updateAddress(addressId, landmark);
    }

    public void deleteAddress(Long addressId) {
        boolean isValidAddress = addressRepo.existsById(addressId);

        if(!isValidAddress){
            throw new IllegalStateException("Not valid address");
        }
        addressRepo.deleteById(addressId);
    }
}
