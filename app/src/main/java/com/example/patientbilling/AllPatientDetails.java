package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class AllPatientDetails extends AppCompatActivity {

    SQLiteDatabase db;
    HospitalDatabase hd;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_patient_details);
        hd = new HospitalDatabase(this);
        String FetchedDetails = hd.GetPatientData();
        tv = findViewById(R.id.PatientDetails);
        tv.setText(FetchedDetails);

    }
}
