package com.api.design.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.design.Entity.Country;


public interface  CountryRepository extends JpaRepository<Country,Integer> {

}
