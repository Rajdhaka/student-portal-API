package com.geekster.mappingPractice.controllers;

import com.geekster.mappingPractice.models.Address;
import com.geekster.mappingPractice.models.Laptop;
import com.geekster.mappingPractice.services.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    LaptopService laptopService;

    @PostMapping
    public void addLaptop(@RequestBody Laptop laptop){
        laptopService.addLaptop(laptop);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Laptop>> getAllLaptop(){
        List<Laptop>AllLaptops =laptopService.findAllLaptops();
        HttpStatus status;

        if(AllLaptops.isEmpty()){
            status = HttpStatus.NO_CONTENT;
        }
        else{
            status = HttpStatus.OK;
        }
        return new ResponseEntity<List<Laptop>>(AllLaptops,status);
    }

    @PutMapping("laptopId/{laptopId}/laptopPrice/{laptopPrice}")
    public ResponseEntity<String>modifyLaptop(@PathVariable Long laptopId,@PathVariable String laptopPrice){
        HttpStatus status;
        String message ;
        try{
            laptopService.updateLaptopPrice(laptopId, laptopPrice);
            status = HttpStatus.OK;
            message = "Laptop price  updated successfully !!!";

        }
        catch (Exception ex){

            status = HttpStatus.NOT_MODIFIED;
            message = "Laptop with laptopId "+laptopId+" does not exist";
            System.out.println(ex);


        }
        return new ResponseEntity<String>(message,status);
    }

    @DeleteMapping("laptopId/{laptopId}")

    public ResponseEntity<String>removeLaptop(@PathVariable Long laptopId){
        HttpStatus status;
        String message = null;
        try{
            laptopService.deleteLaptop(laptopId);
            status = HttpStatus.OK;
            message = "Laptop deleted successfully !!!";

        }
        catch (Exception ex){
            status = HttpStatus.BAD_REQUEST;
            message = "Laptop does not exist";
            System.out.println(ex);
        }
        return new ResponseEntity<String>(message,status);
    }

}
