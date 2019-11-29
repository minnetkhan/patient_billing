package com.example.patientbilling;

import android.provider.BaseColumns;

public class TablePatientDoctor {
    private TablePatientDoctor() {

    }

    public static class TablePatientDoctorClass implements BaseColumns {
        public static String R_PATIENT_ID = "p_id";
        public static String R_DOCTOR_ID = "d_id";

        public static final String TABLEPATIENTDOCTOR = "patient_doctor";
    }
}
