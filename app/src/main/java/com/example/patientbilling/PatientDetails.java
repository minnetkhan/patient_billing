package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class PatientDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        Intent intent = getIntent();
        String patientID = intent.getStringExtra(KeyValuePair.KEY_PATIENT_ID);
        Toast.makeText(this, patientID, Toast.LENGTH_SHORT).show();

    }
}
