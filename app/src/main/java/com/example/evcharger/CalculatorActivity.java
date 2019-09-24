package com.example.evcharger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;

public class CalculatorActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        Settings s = (Settings) getApplication();
        if(!s.isMiles()) {
            TextView desc = (TextView) findViewById(R.id.batteryDesc1);
            desc.setText("Enter the distance(in kilometers) to be traveled");
        }



        Button calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Settings s = (Settings) getApplication();

                EditText distance = (EditText) findViewById(R.id.distance);
                TextView duration = (TextView) findViewById(R.id.duration);
                TextView batterydesc = (TextView) findViewById(R.id.batteryDesc3);

                // 5 20
                if (distance.getText().toString().length() >  0) {
                    double res = Integer.parseInt(distance.getText().toString()) * (s.isMiles()? 1.0 : 0.621371) / (s.isAmp20()? 5:20);

                    duration.setText(new DecimalFormat("#.0").format(res) + " hour(s)");
                    batterydesc.setText("to travel " + distance.getText().toString() + (s.isMiles()? " mile(s)" : " kilometer(s)"));
                }
            }

        });


        FloatingActionButton redirect = (FloatingActionButton) findViewById(R.id.redirect);
        redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = "https://www.ucsusa.org/clean-vehicles/electric-vehicles/car-charging-time-type-cost";
                Uri webaddress = Uri.parse(link);

                Intent gotoLink = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoLink.resolveActivity(getPackageManager()) != null) {
                    startActivity(gotoLink);
                }
            }

        });



    }

}
