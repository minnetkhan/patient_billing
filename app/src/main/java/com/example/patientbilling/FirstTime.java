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
            db.InsertPatientData(db, "Minnet", 2, "m", "B+", 23, "abc");
            db.InsertPatientData(db, "Sonali", 3, "f", "AB-", 23, "abc");
            db.InsertPatientData(db, "Abdul", 4, "m", "O-", 23, "abc");
            db.InsertPatientData(db, "Zaki", 5, "m", "AB+", 23, "abc");
            db.InsertPatientData(db, "Sonal", 6, "f", "O+", 23, "abc");

            db.InsertDoctorData(db, "D1", 1, "f", "AB+", 200);
            db.InsertDoctorData(db, "D2", 2, "m", "AB+", 300);
            db.InsertDoctorData(db, "D3", 13, "f", "AB+", 400);

            db.InsertTreatmentData(db, "TMT", "Diagnostic", 2000);
            db.InsertTreatmentData(db, "EMI", "Cardio", 5000);
            db.InsertTreatmentData(db, "ByPass", "Surgery", 10000);

            db.InsertWardData(db, 1, "Deluxe", 5500, 1);
            db.InsertWardData(db, 2, "SemiDeluxe", 4500, 2);
            db.InsertWardData(db, 3, "ICU", 6500, 3);
            db.InsertWardData(db, 4, "General", 2500, 4);
            db.InsertWardData(db, 5, "Normal", 3000, 5);
            db.InsertWardData(db, 6, "GeneralICU", 6000, 6);

            db.InsertPatDocData(db, 1, 1);
            db.InsertPatDocData(db, 2, 2);
            db.InsertPatDocData(db, 3, 3);
            db.InsertPatDocData(db, 4, 4);
            db.InsertPatDocData(db, 5, 5);
            db.InsertPatDocData(db, 6, 6);





            Log.d("Inside if","bool is still false");

            SharedPreferences.Editor editor = ins.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
            Log.d("Inside if","bool is true now");

        }
    }
}


