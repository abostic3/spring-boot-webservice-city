package com.springboot.webservice.city.Model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface CityRepository extends MongoRepository<City, String>  {

    City findByName(@Param("name") String name);

}
