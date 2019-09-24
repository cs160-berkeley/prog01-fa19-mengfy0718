package com.example.evcharger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ScheduleConfirm extends AppCompatActivity {

    public static final String TIME = "com.example.evcharger.TIME";
    public static final String DATE = "com.example.evcharger.DATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_confirm);


            TextView confirmedDate = (TextView) findViewById(R.id.confirmedD);
            TextView confirmedTime = (TextView) findViewById(R.id.confirmedT);
            confirmedDate.setText(getIntent().getExtras().getString(DATE));
            confirmedTime.setText(getIntent().getExtras().getString(TIME));

    }
}
