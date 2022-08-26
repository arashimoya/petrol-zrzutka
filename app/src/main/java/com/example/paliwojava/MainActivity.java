package com.example.paliwojava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static DecimalFormat TOTAL_COST_FORMAT = new DecimalFormat("0.##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        EditText distanceInput = findViewById(R.id.distanceInput);
        EditText fuelEfficiencyPer100kmInput = findViewById(R.id.fuelEfficiencyInput);
        EditText fuelCostInput = findViewById(R.id.FuelCostInput);
        EditText numberOfPassengersInput = findViewById(R.id.numberOfPassengersInput);


        Button calculateButton = findViewById(R.id.calculateButton);

        TextView totalCostTV = findViewById(R.id.totalCostTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(distanceInput.getText()) || TextUtils.isEmpty(fuelCostInput.getText()) ||
                TextUtils.isEmpty(fuelEfficiencyPer100kmInput.getText()) || TextUtils.isEmpty(numberOfPassengersInput.getText())){
                    Toast.makeText(MainActivity.this, "One of your input fields is empty!", Toast.LENGTH_SHORT).show();
                } else{
                    double distance = Double.parseDouble(distanceInput.getText().toString());
                    double fuelEfficiency = Double.parseDouble(fuelEfficiencyPer100kmInput.getText().toString());
                    double fuelCost = Double.parseDouble(fuelCostInput.getText().toString());
                    int numberOfPassengers = Integer.parseInt(numberOfPassengersInput.getText().toString());
                    double totalCost = viewModel.getTotalCost(distance, fuelEfficiency, fuelCost, numberOfPassengers);
                    totalCostTV.setText(TOTAL_COST_FORMAT.format(totalCost) + " zł");
                }

            }
        });






    }
}