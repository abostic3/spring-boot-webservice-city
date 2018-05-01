package com.springboot.webservice.city.Controller;

import com.springboot.webservice.city.Model.City;
import com.springboot.webservice.city.Model.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CityApiController {

    @Autowired
    private CityRepository cityRepo;

//    @PostConstruct
//    public void initData(){
//        cityRepo.save(new City("Cincinnati", "OH", 10000));
//        cityRepo.save(new City("Ney York City", "NY", 100000000));
//        cityRepo.save(new City("Los Santos", "CA", 1000000));
//        cityRepo.save(new City("Ann Harbor", "MI", 1000000));
//        cityRepo.save(new City("Homer", "AK", 1000));
//    }

    @RequestMapping(value = "/api/city")
    public @ResponseBody
    City returnData(@RequestParam(value="name", required=false, defaultValue="Choose a city") String name){
        City newCity = new City();
        newCity.setName("Choose a city");
        newCity.setState_Located("Choose a city");
        newCity.setPopulation(00);
        //Set up a data base with city information to query
        return newCity;

    }

    @RequestMapping("/api/cities")
    public List<City> getAllCities(){
        return cityRepo.findAll();
    }

    @RequestMapping(value = "/api/city/{name}")
    public City getCity(@PathVariable("name") String name) {
        return cityRepo.findByName(name);
    }

}
