package com.example.evcharger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Settings s = (Settings) getApplication();
        if (s.isAmp20()) {
            RadioButton amp20 = (RadioButton) findViewById(R.id.amp20);
            amp20.setChecked(true);
        } else {
            RadioButton amp30 = (RadioButton) findViewById(R.id.amp30);
            amp30.setChecked(true);
        }

        if (s.isMiles()) {
            RadioButton miles = (RadioButton) findViewById(R.id.miles);
            miles.setChecked(true);
        } else {
            RadioButton kilometers = (RadioButton) findViewById(R.id.kilometers);
            kilometers.setChecked(true);
        }

        Button apply = (Button) findViewById(R.id.applySetting);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Settings s = (Settings) getApplication();
                RadioButton amp20 = (RadioButton) findViewById(R.id.amp20);
                s.setAmp20(amp20.isChecked());
                RadioButton miles = (RadioButton) findViewById(R.id.miles);
                s.setMiles(miles.isChecked());
            }
        });

    }
}
