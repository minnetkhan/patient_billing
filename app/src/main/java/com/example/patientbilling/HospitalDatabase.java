package com.example.patientbilling;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
//import TablePatient;

public class HospitalDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "artlet";

    private static final String CREATE_TABLE_PATIENT = "CREATE TABLE " +
            TablePatient.TablePatientClass.TABLE_PATIENT +
            "( " +
                TablePatient.TablePatientClass.PATIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TablePatient.TablePatientClass.PATIENT_NAME +" VARCHAR(255)," +
                TablePatient.TablePatientClass.PATIENT_CONTACT_NO +" INT(11), " +
                TablePatient.TablePatientClass.PATIENT_GENDER + " VARCHAR(255), " +
                TablePatient.TablePatientClass.PATIENT_BLOODGROUP + " VARCHAR(255), " +
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
                TableDoctor.TableDoctorClass.Doctor_BLOODGROUP + " VARCHAR(255), " +
                TableDoctor.TableDoctorClass.Doctor_GENDER + " VARCHAR(255), " +
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
                TableWard.TableWardClass.DISCHARGE_DATE + " INTEGER DEFAULT 0, " +
                TableWard.TableWardClass.PATIENT_ID + " INT(11), " +
                " FOREIGN KEY (" + TableWard.TableWardClass.PATIENT_ID +") REFERENCES "+
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

    public void InsertPatientData(HospitalDatabase hd,  String patient_name, int contact, String gender, String bg, int ep_c, String ep_n)
    {
        db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(TablePatient.TablePatientClass.PATIENT_NAME , patient_name);
        c.put(TablePatient.TablePatientClass.PATIENT_CONTACT_NO, contact);
        c.put(TablePatient.TablePatientClass.PATIENT_GENDER, gender);
        c.put(TablePatient.TablePatientClass.PATIENT_BLOODGROUP, bg);
        c.put(TablePatient.TablePatientClass.PATIENT_EP_CONTACT, ep_c);
        c.put(TablePatient.TablePatientClass.PATIENT_EP_NAME, ep_n);
        db.insert(TablePatient.TablePatientClass.TABLE_PATIENT, null, c);
        Log.d("Inside InsertUSerData", "One row inserted");
    }

    public String GetPatientData()
    {
        db = getWritableDatabase();
        Cursor c = db.rawQuery("Select * from  patient", null );
        c.moveToFirst();
        String patient="";
        for( int i =0; i<c.getCount();i++)
        {
            patient = patient+"\n\n Name:"+c.getString(c.getColumnIndex("name"))+"\n Contact No:"+
                    c.getString(c.getColumnIndex("contact"))+ "\n Gender:"+ c.getString(c.getColumnIndex("gender"))+"\n BloodGroup:" +
                    c.getString(c.getColumnIndex("bg"))+ "\n Emergency Contact Person Name:"+c.getString(c.getColumnIndex("e_name"))+"\n Emergency Contact Person Number:"+c.getString(c.getColumnIndex("e_contact"))+"";
            c.moveToNext();
        }

        return patient;
    }


    public String getOnePatientData(String patient_ID) {
        String patient = "";

        db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from patient where id = ?", new String[]{patient_ID});

        if(c != null) {
            c.moveToFirst();
        }

        int count = c.getColumnCount();

        for(int i=0; i<count; i++) {
            patient = patient + " " + c.getString(i);
        }

        patient = patient.trim();

        return patient;
    }


    public String GetOneDoctorData(String doctor_ID)
    {
        String patient = "";

        db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from doctor where id = ?", new String[]{doctor_ID});

        if(c != null) {
            c.moveToFirst();
        }

        int count = c.getColumnCount();

        for(int i=0; i<count; i++) {
            patient = patient + " " + c.getString(i);
        }

        patient = patient.trim();

        return patient;
    }

    public void InsertDoctorData(HospitalDatabase hd,  String d_name, int contact, String gender, String bg, int fee)
    {
        db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(TableDoctor.TableDoctorClass.Doctor_NAME , d_name);
        c.put(TableDoctor.TableDoctorClass.Doctor_CONTACT_NO , contact);
        c.put(TableDoctor.TableDoctorClass.Doctor_GENDER, gender);
        c.put(TableDoctor.TableDoctorClass.Doctor_BLOODGROUP, bg);
        c.put(TableDoctor.TableDoctorClass.Doctor_FEE, fee);
        db.insert(TableDoctor.TableDoctorClass.TABLE_DOCTOR, null, c);
        Log.d("Inside InsertUSerData", "One row inserted");
    }

    public void InsertTreatmentData(HospitalDatabase hd,  String t_name, String t_type, int t_charges)
    {
        db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(TableTreatment.TableTreatmentClass.TREATMENT_NAME  , t_name);
        c.put(TableTreatment.TableTreatmentClass.TREATMENT_TYPE , t_type);
        c.put(TableTreatment.TableTreatmentClass.TREATMENT_CHARGES, t_charges);
        db.insert(TableTreatment.TableTreatmentClass.TABLE_TREATMENT, null, c);
        Log.d("Inside InsertUSerData", "One row inserted");
    }

    public void InsertWardData(HospitalDatabase hd,  int rn, String w_type, int w_charges, int p_id)
    {
        db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(TableWard.TableWardClass.ROOM_NO  , rn);
        c.put(TableWard.TableWardClass.ROOM_TYPE , w_type);
        c.put(TableWard.TableWardClass.PER_DAY_CHARGES, w_charges);
        c.put(TableWard.TableWardClass.PATIENT_ID, p_id);
        db.insert(TableTreatment.TableTreatmentClass.TABLE_TREATMENT, null, c);
        Log.d("Inside InsertUSerData", "One row inserted");
    }

    public void InsertPatDocData(HospitalDatabase hd,  int d_id, int p_id)
    {
        db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(TablePatientDoctor.TablePatientDoctorClass.R_DOCTOR_ID  , d_id);
        c.put(TablePatientDoctor.TablePatientDoctorClass.R_PATIENT_ID, p_id);
        db.insert(TablePatientDoctor.TablePatientDoctorClass.TABLEPATIENTDOCTOR , null, c);
        Log.d("Inside InsertUSerData", "One row inserted");
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

    public String getPatientWardDetails(String patient_ID) {
        String wardDetails = "";

        db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from patient where id = ?", new String[]{patient_ID});

        if(c != null) {
            c.moveToFirst();
        }

        int count = c.getColumnCount();

        for(int i=0; i<count; i++) {
            wardDetails = wardDetails + " " + c.getString(i);
        }

        wardDetails = wardDetails.trim();

        return wardDetails;
    }

}
