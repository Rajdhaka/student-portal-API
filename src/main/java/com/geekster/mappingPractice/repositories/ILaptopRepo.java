package com.geekster.mappingPractice.repositories;

import com.geekster.mappingPractice.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaptopRepo extends JpaRepository<Laptop,Long> {

    @Modifying
    @Query(value = "update laptop set laptop_price=:laptopPrice where laptop_id=:laptopId",nativeQuery = true)
    void updateLaptop(Long laptopId, String laptopPrice);
}
