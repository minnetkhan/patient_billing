package com.example.patientbilling;

import android.provider.BaseColumns;

public class TableWard {

    private TableWard() {

    }

    public static abstract class TableWardClass implements BaseColumns {
        public static final String WARD_ID = "w_id";
        public static final String ROOM_NO = "w_room_no";
        public static final String ROOM_TYPE = "w_room_type";
        public static final String PER_DAY_CHARGES = "w_per_day_charges";
        public static final String ADMISSION_DATE = "w_admission_date";
        public static final String DISCHARGE_DATE = "w_discharge_date";

        public static final String PATIENT_ID = "p_id";

        public static final String TABLE_WARD = "ward";
    }
}
