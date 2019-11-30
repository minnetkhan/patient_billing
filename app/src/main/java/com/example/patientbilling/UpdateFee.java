package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateFee extends AppCompatActivity {

    SQLiteDatabase db;
    EditText e_id, e_upfee;
    int d_id, fee;
    Doctor d1 = new Doctor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_fee);
    }

    public void onClickUpdate(View v)
    {
        HospitalDatabase hd = new HospitalDatabase(this);

        e_id = (EditText) findViewById(R.id.d_id);
        e_upfee = (EditText) findViewById(R.id.fee);

        d_id  = Integer.parseInt(e_id.getText().toString());
        fee = Integer.parseInt(e_upfee.getText().toString());


        d1.updateConsultationFee(hd, d_id,fee);
        Toast.makeText(this,"Fee Updated Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}

