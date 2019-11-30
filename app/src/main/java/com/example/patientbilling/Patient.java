package com.example.patientbilling;

public class Patient extends Person {

    public Patient(String name, String personID, int contactNumber, String gender, String blood_group, String emergencyPersonContactName, int emergencyPersonContactNumber) {
        super(name, personID, contactNumber, gender, blood_group);
        EmergencyPersonContactName = emergencyPersonContactName;
        EmergencyPersonContactNumber = emergencyPersonContactNumber;
    }

    private String EmergencyPersonContactName;
    private int EmergencyPersonContactNumber;

    public String getEmergencyPersonContactName() {
        return EmergencyPersonContactName;
    }

    public void setEmergencyPersonContactName(String emergencyPersonContactName) {
        EmergencyPersonContactName = emergencyPersonContactName;
    }

    public int getEmergencyPersonContactNumber() {
        return EmergencyPersonContactNumber;
    }

    public void setEmergencyPersonContactNumber(int emergencyPersonContactNumber) {
        EmergencyPersonContactNumber = emergencyPersonContactNumber;
    }






}


