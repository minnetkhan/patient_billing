package com.example.patientbilling;

import androidx.appcompat.app.AlertDialog;
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
public class LoggedInScreen extends AppCompatActivity implements PatientIdFragmentDialog.OnCompleteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_screen);
    }

    public void onClickPatientDetails(View view) {
        /*
            goto PatientDetails.java
         */

        PatientIdFragmentDialog dialogFragment = new PatientIdFragmentDialog();
        dialogFragment.show(getSupportFragmentManager(), "Dialog Fragment");

    }


    public void onComplete(String patientID) {
        Intent intent = new Intent(this, PatientDetails.class);
        intent.putExtra(KeyValuePair.KEY_PATIENT_ID, patientID);
        startActivity(intent);
    }

    public void onClickAllPatientDetails(View view) {
        /*
            goto PatientDetails.java
         */
        Intent intent = new Intent(this, AllPatientDetails.class);
        startActivity(intent);
    }

    public void onClickAddPatient(View view) {
        /*
            goto PatientDetails.java
         */
        Intent intent = new Intent(this, AddPatient.class);
        startActivity(intent);
    }
}
