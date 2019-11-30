package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPatient extends AppCompatActivity {

    SQLiteDatabase db;
    HospitalDatabase hd;
    EditText e_name, e_contact, e_ep_name, e_ep_contact;
    Spinner sp_bg, sp_g;
    String name, ep_name;
    int contact, ep_contact;
    Patient p1= new Patient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);


    }

    public void onClickSubmit(View v)
    {
        sp_bg = (Spinner)findViewById(R.id.SpinnerBloodType);
        String blood_type = sp_bg.getSelectedItem().toString();


        sp_g = (Spinner)findViewById(R.id.SpinnerGenderType);
        String gender_type = sp_g.getSelectedItem().toString();

        e_name   = (EditText)findViewById(R.id.edit_name);
        name = e_name.getText().toString();
        e_contact   = (EditText)findViewById(R.id.edit_contact);
        contact = Integer.parseInt(e_contact.getText().toString());
        e_ep_contact   = (EditText)findViewById(R.id.edit_epcontact);
        ep_contact  = Integer.parseInt(e_ep_contact.getText().toString());
        e_ep_name   = (EditText)findViewById(R.id.edit_epname);
        ep_name = e_ep_name.getText().toString();

        hd = new HospitalDatabase(this);
        p1.updateDetails(hd, name, contact, gender_type, blood_type, ep_name, ep_contact);
        Toast.makeText(this,"Patient Added Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

}
