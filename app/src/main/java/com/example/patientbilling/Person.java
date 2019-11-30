package com.example.patientbilling;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class Person {

    SQLiteDatabase db;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonID() {
        return PersonID;
    }

    public void setPersonID(String personID) {
        PersonID = personID;
    }

    public int getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public Person(String name, String personID, int contactNumber, String gender, String blood_group) {
        this.name = name;
        PersonID = personID;
        ContactNumber = contactNumber;
        this.gender = gender;
        this.blood_group = blood_group;
    }

    private String name;
    private String PersonID;
    private int ContactNumber;
    private String gender;
    private String blood_group;

    Person()
    {

    }

    public void updateDetails(HospitalDatabase hd, String name, int contactNumber, String gender, String blood_group, String ep_name, int ep_contact)
    {
        db = hd.getReadableDatabase();
        ContentValues c = new ContentValues();
        c.put(TablePatient.TablePatientClass.PATIENT_NAME , name);
        c.put(TablePatient.TablePatientClass.PATIENT_CONTACT_NO, contactNumber);
        c.put(TablePatient.TablePatientClass.PATIENT_GENDER, gender);
        c.put(TablePatient.TablePatientClass.PATIENT_BLOODGROUP, blood_group);
        c.put(TablePatient.TablePatientClass.PATIENT_EP_CONTACT, ep_contact);
        c.put(TablePatient.TablePatientClass.PATIENT_EP_NAME, ep_name);
        db.insert(TablePatient.TablePatientClass.TABLE_PATIENT, null, c);
        Log.d("Inside InsertUSerData", "One row inserted");
    }




}
