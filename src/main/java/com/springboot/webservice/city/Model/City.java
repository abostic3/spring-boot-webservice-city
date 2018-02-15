package com.springboot.webservice.city.Model;

public class City {

    private final long request_id;
    private final long id;
    private final String name;
    private final String state_located;
    private final int population;

    public City(long request_id, long id, String name, String state_located, int population) {
        this.request_id = request_id;
        this.id = id;
        this.name = name;
        this.state_located = state_located;
        this.population = population;
    }

    public long getRequest_id() {
        return request_id;
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
