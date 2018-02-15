package com.springboot.webservice.city.Controller;

import com.springboot.webservice.city.Model.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/city")
public class CityController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    City returnData(@RequestParam(value="name", required=false, defaultValue="Choose a city") String name){

        if(name.equals("Choose a city"))
            return new City(0, 0, name,"",0);

        //Set up a data base with city information to query
        return new City(counter.incrementAndGet(), 1, name,"OH",100);

    }

}
