package com.example.evcharger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Calendar;

public class ChargingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charging);

        TextView chargingDesc = (TextView)findViewById(R.id.chargingDesc);
        TextView chargingTime = (TextView)findViewById(R.id.chargingTime);
        Switch turnon = (Switch) findViewById(R.id.turnon);
        Settings s = (Settings) getApplication();

        chargingDesc.setText(s.getChargingDesc());
        chargingTime.setText(s.getChargingTime());
        turnon.setChecked(s.getCharging());

        turnon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String desc = "";
                if (isChecked) {
                    desc = "Session started at";
                } else {
                    desc = "Last session ended at";
                }
                TextView chargingDesc = (TextView)findViewById(R.id.chargingDesc);
                TextView chargingTime = (TextView)findViewById(R.id.chargingTime);
                Calendar now = Calendar.getInstance();
                String time = (now.get(Calendar.HOUR_OF_DAY) > 9? "" : "0") + now.get(Calendar.HOUR_OF_DAY)  + ":"
                        + (now.get(Calendar.MINUTE) > 9? "" : "0") +  now.get(Calendar.MINUTE) + " "
                        + (now.get(Calendar.MONTH)+1) + "/" + now.get(Calendar.DATE) +"/" + now.get(Calendar.YEAR);
                chargingDesc.setText(desc);
                chargingTime.setText(time);

                // update settings
                Settings s = (Settings) getApplication();
                s.setChargingDesc(desc);
                s.setChargingTime(time);
                s.setCharging(isChecked);
            }
        });
    }

}
