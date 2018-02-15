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

//    @PostConstruct
//    public void initData(){
//        cityRepo.save(new City(4,"Dallas", "TX", 100000));
//        cityRepo.save(new City(5, "Jacksonville", "FL", 1000));
//        cityRepo.save(new City(6,"Chicago", "IL", 500));
//    }

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

//    @RequestMapping(value = "/city/add/{id}/{name}/{state_located}/{population}")
////    public void addCity(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("state_located") String state_located,@PathVariable("population") int population) {
////        cityRepo.addCity(id,name,state_located,population);
////    }

    public CityRepository getCityRepo() {
        return cityRepo;
    }

    public void setCityRepo(CityRepository cityRepo) {
        this.cityRepo = cityRepo;
    }

}
