package com.example.patientbilling;

import android.provider.BaseColumns;

public class TablePatientTreatment {
    private TablePatientTreatment() {

    }

    public static abstract class TablePatientTreatmentClass implements BaseColumns {
        public static final String R_PATIENT_ID = "p_id";
        public static final String R_TREATMENT_ID = "t_id";

        public static final String TABLEPATIENTTREATMENT = "patient_treatment";
    }
}
