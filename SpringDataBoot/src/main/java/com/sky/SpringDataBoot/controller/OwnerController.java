package com.sky.SpringDataBoot.controller;

import com.sky.SpringDataBoot.domain.dto.Owner;
import com.sky.SpringDataBoot.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Martina";
    }

    @GetMapping("/owners")
    public List<Owner> showOwners(){
        return ownerService.getAllOwners();
    }


    @GetMapping("/owners/{id}")
    public Owner getOneOwner(@PathVariable int id){
        Optional<Owner> optionalOwner = ownerService.getOwnerById(id);
        if (optionalOwner.isPresent()){
            System.out.println(optionalOwner.get());
            return optionalOwner.get();
        }else{
            throw new ResponseStatusException(
                    HttpStatus.I_AM_A_TEAPOT, "Could not find your owner!"
            );
        }
    }

    @PostMapping("/owners")
    public HttpStatus createNewOwner(@RequestBody Owner owner){
        Owner result = ownerService.insertOwnerAndCars(owner);
        if (result == null){
            return HttpStatus.PRECONDITION_FAILED;
        }
        else{
            return HttpStatus.CREATED;
        }
    }

//    @GetMapping("/owners/{name}")
//    public Owner getOneOwnerByName(@PathVariable String name) {
//            return new Owner();
//    }
}
