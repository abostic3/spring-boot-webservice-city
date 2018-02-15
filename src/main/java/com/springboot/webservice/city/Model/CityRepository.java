package com.springboot.webservice.city.Model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface CityRepository extends MongoRepository<City, String>  {

    City findByName(@Param("name") String name);
    //void addCity(@Param("id") int id, String name, String state_located, int population);

}
