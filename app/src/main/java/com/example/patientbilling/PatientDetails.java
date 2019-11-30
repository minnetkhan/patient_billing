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
        String pDetails = hospitalDatabase.getOnePatientData(patientID);
        String wDetails = hospitalDatabase.getPatientWardDetails(patientID);

        String patientDetails[] = pDetails.split(" ");
        String wardDetails[] = wDetails.split(" ");

        TextView tv1 = (TextView) findViewById(R.id.patient_name);
        tv1.setText(patientDetails[1]);

        TextView tv2 = (TextView) findViewById(R.id.patient_contact);
        tv2.setText(patientDetails[2]);

        TextView tv3 = (TextView) findViewById(R.id.patient_gender);
        tv3.setText(patientDetails[3]);

        TextView tv4 = (TextView) findViewById(R.id.patient_blood_group);
        tv4.setText(patientDetails[4]);

        TextView tv5 = (TextView) findViewById(R.id.patient_emergency_person);
        tv5.setText(patientDetails[6]);

        TextView tv6 = (TextView) findViewById(R.id.patient_emergency_person_contact);
        tv6.setText(patientDetails[5]);

    }

    public void onClickEditPatientDetails(View view) {

    }

}
