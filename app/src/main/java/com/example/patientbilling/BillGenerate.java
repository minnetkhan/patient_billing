package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BillGenerate extends AppCompatActivity {

    SQLiteDatabase db;
    HospitalDatabase hd;
    EditText e_pid;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_generate);
    }

    public void genBill(View v)
    {
        hd = new HospitalDatabase(this);
        e_pid   = (EditText)findViewById(R.id.p1_id);
        id = Integer.parseInt(e_pid.getText().toString());

    }
}
