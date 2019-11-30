package com.example.patientbilling;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Doctor extends Person {

    SQLiteDatabase db;


    Doctor()
    {

    }

    public Doctor(String name, String personID, int contactNumber, String gender, String blood_group, int consul_fee) {
        super(name, personID, contactNumber, gender, blood_group);
        this.consul_fee = consul_fee;
    }

    private int consul_fee;


    public int getConsul_fee() {
        return consul_fee;
    }

    public void setConsul_fee(int consul_fee) {
        this.consul_fee = consul_fee;
    }


    public void updateConsultationFee(HospitalDatabase hd,int id, int newfee)
    {

        db = hd.getReadableDatabase();
        ContentValues c = new ContentValues();
        c.put(TableDoctor.TableDoctorClass.Doctor_FEE  , newfee);

            db.update(TableDoctor.TableDoctorClass.TABLE_DOCTOR,
                    c,
                    TableDoctor.TableDoctorClass.Doctor_ID + " = ? ",
                    new String[]{String.valueOf(id)});

            Log.d("Inside InsertUSerData", "One row inserted");
    }

}
