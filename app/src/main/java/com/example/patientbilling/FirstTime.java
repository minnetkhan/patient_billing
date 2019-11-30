package com.example.patientbilling;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class FirstTime extends Application {

    HospitalDatabase db;


    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences ins  = PreferenceManager.getDefaultSharedPreferences(this);
        if (!ins.getBoolean("firstTime", false)) {

            Log.d("Inside if","bool is false");
            this.db = new HospitalDatabase(getApplicationContext());
            db.InsertPatientData(db, "Aakanksha", 1, "f", "AB+", 23, "abc");
            db.InsertPatientData(db, "Minnet", 2, "m", "AB+", 23, "abc");
            db.InsertPatientData(db, "Sonali", 13, "f", "AB+", 23, "abc");

            Log.d("Inside if","bool is still false");

            SharedPreferences.Editor editor = ins.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
            Log.d("Inside if","bool is true now");

        }
    }
}


