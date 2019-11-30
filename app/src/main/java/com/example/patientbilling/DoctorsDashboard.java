package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DoctorsDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_dashboard);
    }

    public void onClickUpdateFee(View v)
    {
        Intent intent = new Intent(this, UpdateFee.class);
        startActivity(intent);
    }

    public void onClickDoctorDetails(View v)
    {
        Intent intent = new Intent(this, DoctorDetails.class);
        startActivity(intent);
    }
}
