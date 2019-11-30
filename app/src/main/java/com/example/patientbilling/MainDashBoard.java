package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainDashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    public void onClickPatients(View v)
    {
        Intent intent = new Intent(this, LoggedInScreen.class);
        startActivity(intent);
    }

    public void onClickDoctors(View v)
    {
        Intent intent = new Intent(this, DoctorsDashboard.class);
        startActivity(intent);
    }

    public void onClickTreatment(View v)
    {
        Intent intent = new Intent(this, TreatmentDashboard.class);
        startActivity(intent);
    }
    public void onClickWard(View v)
    {
        Intent intent = new Intent(this, WardDashboard.class);
        startActivity(intent);
    }
}
