package com.springboot.webservice.city.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("serial")
@Document(collection = "city_new")
public class City {

    private String name;
    private String state_located;
    private int population;

    public City() {}

    public City(String name, String state_located, int population) {

        this.name = name;
        this.state_located = state_located;
        this.population = population;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState_Located() {
        return state_located;
    }

    public void setState_Located(String state_located) {
        this.state_located = state_located;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                ", name='" + name + '\'' +
//                ", Age=" + age +
//                '}';
//    }
}
