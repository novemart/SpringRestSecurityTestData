package com.sky.SpringDataBoot.domain.dao;

import com.sky.SpringDataBoot.domain.dto.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
