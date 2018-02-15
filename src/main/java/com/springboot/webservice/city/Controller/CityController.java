package com.springboot.webservice.city.Controller;

import com.springboot.webservice.city.Model.City;
import com.springboot.webservice.city.Model.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CityController {

    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private CityRepository cityRepo;

    @PostConstruct
    public void initData(){
        cityRepo.save(new City(1,"Cincinnati", "OH", 100000));
        cityRepo.save(new City(2, "Denver", "CO", 1000));
        cityRepo.save(new City(3,"Homer", "AK", 500));
    }

    @RequestMapping(value = "/city")
    public @ResponseBody
    City returnData(@RequestParam(value="name", required=false, defaultValue="Choose a city") String name){

        if(name.equals("Choose a city"))
            return new City(0, name,"",0);



        //Set up a data base with city information to query
        return new City( 1, name,"OH",100 );

    }

    @RequestMapping("/cities")
    public List<City> getAllCities(){
        return cityRepo.findAll();
    }

    @RequestMapping(value = "/city/{name}")
    public City getCity(@PathVariable("name") String name) {
        return cityRepo.findByName(name);
    }

    public CityRepository getCityRepo() {
        return cityRepo;
    }

    public void setCityRepo(CityRepository cityRepo) {
        this.cityRepo = cityRepo;
    }

}
