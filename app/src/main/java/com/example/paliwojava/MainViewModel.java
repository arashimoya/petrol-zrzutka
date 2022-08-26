package com.example.paliwojava;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {
    private Model model;
    public MainViewModel(@NonNull Application application) {
        super(application);
        model = Model.getInstance();
    }

    public double getTotalCost(double distance, double fuelEfficiencyPer100km, double fuelCost, int numberOfPassengers){
        return model.calculateCost(distance, fuelEfficiencyPer100km, fuelCost, numberOfPassengers);
    }
}
