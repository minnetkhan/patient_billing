package com.example.patientbilling;

import android.provider.BaseColumns;

public class TableTreatment {
    private TableTreatment() {

    }

    public static abstract class TableTreatmentClass implements BaseColumns {
        public static final String TREATMENT_ID = "t_id";
        public static final String TREATMENT_NAME = "t_name";
        public static final String TREATMENT_TYPE = "t_type";
        public static final String TREATMENT_CHARGES = "t_charges";

        public static final String TABLE_TREATMENT = "treatment";
    }
}
