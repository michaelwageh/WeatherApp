package com.example.michael.weatherapp;

public class Model {

    private String cityName;
    private int tempOfCity;
    private String dateOfCity;

    public Model(){

    }


    public Model(String cityName, int tempOfCity, String dateOfCity) {
        this.cityName = cityName;
        this.tempOfCity = tempOfCity;
        this.dateOfCity = dateOfCity;
    }


    public String getCityName() {
        return cityName;
    }

    public int getTempOfCity() {
        return tempOfCity;
    }

    public String getDateOfCity() {
        return dateOfCity;
    }
}
