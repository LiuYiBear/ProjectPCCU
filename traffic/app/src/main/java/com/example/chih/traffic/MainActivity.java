package com.example.chih.traffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    private Button ToTaxiButton;
    private Button ToBusButton;
    private Button AddButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToBusButton = (Button) findViewById(R.id.ToBusButton);
        ToBusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBus();
            }
        });


        ToTaxiButton = (Button) findViewById(R.id.ToTaxiButton);
        ToTaxiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTaxi();
            }
        });


    }

    private void openBus(){
        Intent intentBus = new Intent(this, Bus.class);
        startActivity(intentBus);
    }

    private void openTaxi(){
        Intent intentTaxi = new Intent(this, Taxi.class);
        startActivity(intentTaxi);
    }

    private void openBusAdd(){
        Intent openBusAdd = new Intent(this, BusAdd.class);
        startActivity(openBusAdd);
    }

}
