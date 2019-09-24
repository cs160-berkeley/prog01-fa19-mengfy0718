package com.example.evcharger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button charge = (Button)findViewById(R.id.charge);
        charge.setOnClickListener(this);
        Button calculator = (Button)findViewById(R.id.calculator);
        calculator.setOnClickListener(this);
        Button schedule = (Button)findViewById(R.id.schedule);
        schedule.setOnClickListener(this);
        Button settings = (Button)findViewById(R.id.settings);
        settings.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.charge:
                startActivity(new Intent(getApplicationContext(), ChargingActivity.class));
                break;
            case R.id.calculator:
                startActivity(new Intent(getApplicationContext(), CalculatorActivity.class));
                break;
            case R.id.schedule:
                startActivity(new Intent(getApplicationContext(), ScheduleActivity.class));
                break;
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                break;
        }


    }


}
