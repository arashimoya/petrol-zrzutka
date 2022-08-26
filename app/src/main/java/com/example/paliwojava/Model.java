package com.example.paliwojava;

import android.app.Application;

public class Model {

    private static Model instance;

    public static Model getInstance() {
        if(instance==null){
            instance = new Model();
        }

        return instance;
    }

    public Model() {
    }

    public double calculateCost(double distance, double fuelEfficiencyPer100km, double fuelCost, int numberOfPassengers){
        return distance/100  * fuelEfficiencyPer100km * fuelCost / numberOfPassengers;
    }
}
