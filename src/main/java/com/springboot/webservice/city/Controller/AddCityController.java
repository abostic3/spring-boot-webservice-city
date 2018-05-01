package com.springboot.webservice.city.Controller;

import com.mongodb.*;
import com.springboot.webservice.city.Model.City;
import com.springboot.webservice.city.Model.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoCollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.mongodb.client.model.Aggregates.limit;

@Controller
public class AddCityController {

    private static CityRepository cityRepository;


    @Autowired
    public AddCityController(CityRepository cityRepository){
        AddCityController.cityRepository = cityRepository;
    }

    //private static final AtomicInteger count = new AtomicInteger(11);

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("cityList", cityRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("cityList", cityRepository.findAll());
        return "home";
    }

    @RequestMapping(value = "/cities_home")
    public String citiesHome(Model model) {
        model.addAttribute("cityList", cityRepository.findAll());
        return "cities_home";
    }

    @RequestMapping(value = "/cityadd", method = RequestMethod.POST)
    public String cityadd(@ModelAttribute City city) {
        cityRepository.save(new City(city.getName(),city.getState_Located(),city.getPopulation()));
        return "redirect:home";
    }



}

