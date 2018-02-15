package com.springboot.webservice.city.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document(collection = "city")
public class City {

    @Id
    private final long id;
    private final String name;
    private final String state_located;
    private final int population;

    public City(long id,  String name, String state_located, int population) {
        this.id = id;
        this.name = name;
        this.state_located = state_located;
        this.population = population;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState_located() {
        return state_located;
    }

    public int getPopulation() {
        return population;
    }
}
