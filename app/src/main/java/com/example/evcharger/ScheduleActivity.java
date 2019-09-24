package com.example.evcharger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ScheduleActivity extends AppCompatActivity {

    public static final String TIME = "com.example.evcharger.TIME";
    public static final String DATE = "com.example.evcharger.DATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);


        Button confirm = (Button) findViewById(R.id.confirmSchedule);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmIntent = new Intent(getApplicationContext(), ScheduleConfirm.class);
                EditText date = (EditText) findViewById(R.id.date);
                EditText time = (EditText) findViewById(R.id.confirmedT);
                if (date.getText().toString().length() > 0 && time.getText().toString().length() > 0)  {
                    confirmIntent.putExtra(DATE, date.getText().toString());
                    confirmIntent.putExtra(TIME, time.getText().toString());
                    startActivity(confirmIntent);
                }
            }
        });
    }


}
