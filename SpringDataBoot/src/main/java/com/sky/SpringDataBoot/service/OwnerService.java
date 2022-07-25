package com.sky.SpringDataBoot.service;

import com.sky.SpringDataBoot.domain.dao.OwnerRepository;
import com.sky.SpringDataBoot.domain.dto.Car;
import com.sky.SpringDataBoot.domain.dto.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepo;

    public List<Owner> getAllOwners(){
        List<Owner> owners = ownerRepo.findAll();
        if (owners.isEmpty()){
            owners.add(new Owner());
        }
        return owners;
    }

    public Owner insertOwnerAndCars(Owner o){
        for (Car c: o.getCars()){
            c.setOwner(o);
        }
        return ownerRepo.save(o);
    }


    public void updateOwnerAndCars(int id, Owner newOwner){
        Optional<Owner> possibleOwner = ownerRepo.findById(id);
        Owner o = possibleOwner.get();
        System.out.println(o.getOwnerid());
        o.setFirstname(newOwner.getFirstname());
        o.setLastname(newOwner.getLastname());
        for(Car c: newOwner.getCars()){
            c.setOwner(o);
            o.addCar(c);
        }
        ownerRepo.save(o);
    }

    public Optional<Owner> getOwnerById(int id){
          return ownerRepo.findById(id);
    }

}
