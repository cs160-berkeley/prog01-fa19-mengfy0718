package com.example.evcharger;

import android.app.Application;

public class Settings extends Application {
    private boolean amp20;
    private boolean miles;
    private String chargingDesc;
    private String chargingTime;
    private boolean charging;

    @Override
    public void onCreate() {
        super.onCreate();
        setAmp20(true);
        setMiles(true);
        setChargingDesc("Last session ended at");
        setChargingTime("21:00 9/21/2019");
        setCharging(false);

    }

    public void setAmp20(boolean amp20) {
        this.amp20 = amp20;
    }

    public boolean isAmp20() {
        return this.amp20;
    }

    public void setMiles(boolean miles) {
        this.miles = miles;
    }

    public boolean isMiles() {
        return this.miles;
    }

    public void setChargingDesc(String chargingDesc) { this.chargingDesc = chargingDesc; }
    public String getChargingDesc() { return this.chargingDesc; }

    public void setChargingTime(String chargingTime) { this.chargingTime = chargingTime; }
    public String getChargingTime() { return this.chargingTime; }

    public void setCharging(boolean charging) { this.charging = charging; }
    public boolean getCharging() { return this.charging; }

}
