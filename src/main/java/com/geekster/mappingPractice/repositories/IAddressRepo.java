package com.geekster.mappingPractice.repositories;

import com.geekster.mappingPractice.models.Address;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends JpaRepository<Address,Long> {

    @Modifying
    @Query(value = "update address set landmark=:landmark where address_id=:addressId",nativeQuery = true)
    void updateAddress(Long addressId, String landmark);
}
