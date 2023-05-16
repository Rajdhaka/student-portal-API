package com.geekster.mappingPractice.services;

import com.geekster.mappingPractice.models.Laptop;
import com.geekster.mappingPractice.repositories.ILaptopRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    ILaptopRepo laptopRepo;
    public void addLaptop(Laptop laptop) {
        laptopRepo.save(laptop);
    }

    public List<Laptop> findAllLaptops() {
        return laptopRepo.findAll();
    }
    @Transactional
    public void updateLaptopPrice(Long laptopId, String laptopPrice) {
        boolean isValidLaptop = laptopRepo.existsById(laptopId);
        if(!isValidLaptop){
            throw new IllegalStateException("Not valid laptop");
        }
        else{
            laptopRepo.updateLaptop(laptopId,laptopPrice);
        }
    }

    public void deleteLaptop(Long laptopId) {
        boolean isValidLaptop = laptopRepo.existsById(laptopId);
        if(!isValidLaptop){
            throw new IllegalStateException("Not valid laptop");
        }
        else{
            laptopRepo.deleteById(laptopId);
        }
    }
}
