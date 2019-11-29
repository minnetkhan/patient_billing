package com.example.patientbilling;

import android.provider.BaseColumns;

public class TablePatient {

    private TablePatient()
    {

    }

    public static abstract class TablePatientClass implements BaseColumns
    {
        public static final String PATIENT_ID = "id";
        public static final String PATIENT_NAME = "name";
        public static final String PATIENT_CONTACT_NO = "contact";
        public static final String PATIENT_CREATED_AT = "created_at";
        public static final String PATIENT_DOB = "dob";
        public static final String PATIENT_ADDRESS = "address";
        public static final String PATIENT_EP_NAME = "e_name";
        public static final String PATIENT_EP_CONTACT = "e_contact";

        public static final String TABLE_PATIENT = "patient";
    }
}
