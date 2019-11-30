package com.example.patientbilling;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Billing {

    Patient p;
    float amount;
    int bill_id;
    SQLiteDatabase db;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public float calculateTotalAmount(HospitalDatabase hd, int id)
    {
        db = hd.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from ward where id = ?", new String[]{String.valueOf(id)});

        return 0;
    }


}
