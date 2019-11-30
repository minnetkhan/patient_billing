package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PatientDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        Intent intent = getIntent();
        String patientID = intent.getStringExtra(KeyValuePair.KEY_PATIENT_ID);

        HospitalDatabase hospitalDatabase = new HospitalDatabase(this);
        String patientDetails = hospitalDatabase.getOnePatientData(patientID);



        TextView tv = (TextView) findViewById(R.id.OnePatientDetails);
//        LinearLayout lt = (LinearLayout) findViewById( R.id.patient_details_linear_layout );
//        TextView tv = (TextView) getLayoutInflater().inflate(R.layout.activity_patient_details, null);
        tv.setText(patientDetails);
//        lt.addView(tv);
    }

}
