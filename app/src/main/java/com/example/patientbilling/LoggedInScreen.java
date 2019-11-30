package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/*
    ...
        This class is called after login is successful.
    ...
 */
public class LoggedInScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_screen);
    }

    public void onClickPatientDetails(View view) {
        /*
            goto PatientDetails.java
         */
        Intent intent = new Intent(this, PatientDetails.class);
        startActivity(intent);
    }

    public void onClickAllPatientDetails(View view) {
        /*
            goto PatientDetails.java
         */
        Intent intent = new Intent(this, AllPatientDetails.class);
        startActivity(intent);
    }
}
