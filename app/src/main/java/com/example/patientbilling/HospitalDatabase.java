package com.example.patientbilling;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
//import TablePatient;

public class HospitalDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "artlet";

    private static final String CREATE_TABLE_PATIENT = "CREATE TABLE " +
            TablePatient.TablePatientClass.TABLE_PATIENT +
            "( " +
                TablePatient.TablePatientClass.PATIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TablePatient.TablePatientClass.PATIENT_NAME +" VARCHAR(255)," +
                TablePatient.TablePatientClass.PATIENT_CONTACT_NO +" INT(11), " +
                TablePatient.TablePatientClass.PATIENT_DOB + " VARCHAR(255), " +
                TablePatient.TablePatientClass.PATIENT_ADDRESS + " VARCHAR(255), " +
                TablePatient.TablePatientClass.PATIENT_EP_CONTACT + " INT(11), " +
                TablePatient.TablePatientClass.PATIENT_EP_NAME + " VARCHAR(255), " +
                TablePatient.TablePatientClass.PATIENT_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
            ")";

    private static final String CREATE_TABLE_TREATMENT = "CREATE TABLE " +
            TableTreatment.TableTreatmentClass.TABLE_TREATMENT +
            "( " +
                TableTreatment.TableTreatmentClass.TREATMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TableTreatment.TableTreatmentClass.TREATMENT_NAME +" VARCHAR(255)," +
                TableTreatment.TableTreatmentClass.TREATMENT_TYPE +" VARCHAR(255), "+
                TableTreatment.TableTreatmentClass.TREATMENT_CHARGES + " INT(11) " +
            ")";

    private static final String CREATE_TABLE_DOCTOR = "CREATE TABLE " +
            TableDoctor.TableDoctorClass.TABLE_DOCTOR +
            "( " +
                TableDoctor.TableDoctorClass.Doctor_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TableDoctor.TableDoctorClass.Doctor_NAME +" VARCHAR(255)," +
                TableDoctor.TableDoctorClass.Doctor_CONTACT_NO +" INT(11), "+
                TableDoctor.TableDoctorClass.Doctor_ADDRESS + " VARCHAR(255), " +
                TableDoctor.TableDoctorClass.Doctor_DOB + " VARCHAR(255), " +
                TableDoctor.TableDoctorClass.Doctor_FEE + " INT(11), " +
                TableDoctor.TableDoctorClass.Doctor_CREATED_AT + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP " +
            ")";

    private static final String CREATE_TABLE_WARD = "CREATE TABLE " +
            TableWard.TableWardClass.TABLE_WARD +
            "( " +
                TableWard.TableWardClass.WARD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TableWard.TableWardClass.ROOM_NO +" INT(11)," +
                TableWard.TableWardClass.ROOM_TYPE +" VARCHAR(255), "+
                TableWard.TableWardClass.PER_DAY_CHARGES + " INT(11), " +
                TableWard.TableWardClass.ADMISSION_DATE + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                TableWard.TableWardClass.DISCHARGE_DATE + " INT(11), " +
                TableWard.TableWardClass.PATIENT_ID + " INT(11), " +
                " FOREIGN KEY (" + TableWard.TableWardClass.WARD_ID +") REFERENCES "+
                    TablePatient.TablePatientClass.TABLE_PATIENT +"("+
                    TablePatient.TablePatientClass.PATIENT_ID + ")" +
            ")";

    private static final String CREATE_TABLE_PATIENT_DOCTOR = " CREATE TABLE " +
            TablePatientDoctor.TablePatientDoctorClass.TABLEPATIENTDOCTOR +
            "( " +
                TablePatientDoctor.TablePatientDoctorClass.R_DOCTOR_ID + " INT(11), " +
                TablePatientDoctor.TablePatientDoctorClass.R_PATIENT_ID + " INT(11), " +

                " FOREIGN KEY (" + TablePatientDoctor.TablePatientDoctorClass.R_PATIENT_ID +") REFERENCES "+
                TablePatient.TablePatientClass.TABLE_PATIENT +"("+
                TablePatient.TablePatientClass.PATIENT_ID + "), " +

                " FOREIGN KEY (" + TablePatientDoctor.TablePatientDoctorClass.R_DOCTOR_ID +") REFERENCES "+
                TableDoctor.TableDoctorClass.TABLE_DOCTOR +"("+
                TableDoctor.TableDoctorClass.Doctor_ID + ")" +
            ") ";

    private static final String CREATE_TABLE_PATIENT_TREATMENT = " CREATE TABLE " +
            TablePatientTreatment.TablePatientTreatmentClass.TABLEPATIENTTREATMENT +
            " ( " +
                TablePatientTreatment.TablePatientTreatmentClass.R_PATIENT_ID + " INT(11), " +
                TablePatientTreatment.TablePatientTreatmentClass.R_TREATMENT_ID + " INT(11), "+

                " FOREIGN KEY (" + TablePatientTreatment.TablePatientTreatmentClass.R_PATIENT_ID +") REFERENCES "+
                TablePatient.TablePatientClass.TABLE_PATIENT +"("+
                TablePatient.TablePatientClass.PATIENT_ID + "), " +

                " FOREIGN KEY (" + TablePatientTreatment.TablePatientTreatmentClass.R_TREATMENT_ID +") REFERENCES "+
                TableTreatment.TableTreatmentClass.TABLE_TREATMENT +"("+
                TableTreatment.TableTreatmentClass.TREATMENT_ID + ")" +
            " ) ";

    // SQLiteDatabase object to write and read the database created
    protected SQLiteDatabase db;

    public  HospitalDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.db = this.getWritableDatabase();
        Log.d("Database Created", "Inside Database helper");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_PATIENT);
        db.execSQL(CREATE_TABLE_DOCTOR);
        db.execSQL(CREATE_TABLE_TREATMENT);
        db.execSQL(CREATE_TABLE_WARD);
        db.execSQL(CREATE_TABLE_PATIENT_DOCTOR);
        db.execSQL(CREATE_TABLE_PATIENT_TREATMENT);
        Log.d("Tables Created", "Inside OnCreate");
    }

    @Override
    public void onConfigure(SQLiteDatabase db){
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TablePatient.TablePatientClass.TABLE_PATIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TableDoctor.TableDoctorClass.TABLE_DOCTOR);
        db.execSQL("DROP TABLE IF EXISTS " + TableTreatment.TableTreatmentClass.TABLE_TREATMENT);
        db.execSQL("DROP TABLE IF EXISTS " + TableWard.TableWardClass.TABLE_WARD);
        db.execSQL("DROP TABLE IF EXISTS " + TablePatientDoctor.TablePatientDoctorClass.TABLEPATIENTDOCTOR);
        db.execSQL("DROP TABLE IF EXISTS " + TablePatientTreatment.TablePatientTreatmentClass.TABLEPATIENTTREATMENT);


        // create new tables
        onCreate(db);
    }

}
