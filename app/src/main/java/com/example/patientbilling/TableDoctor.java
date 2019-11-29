package com.example.patientbilling;

import android.provider.BaseColumns;

public class TableDoctor {

    private TableDoctor() {

    }

    public static abstract class TableDoctorClass implements BaseColumns {
        public static final String Doctor_ID = "d_id";
        public static final String Doctor_NAME = "d_name";
        public static final String Doctor_CONTACT_NO = "d_contact";
        public static final String Doctor_CREATED_AT = "d_created_at";
        public static final String Doctor_DOB = "d_dob";
        public static final String Doctor_ADDRESS = "d_address";
        public static final String Doctor_FEE = "d_fee";

        public static final String TABLE_DOCTOR = "doctor";
    }
}

