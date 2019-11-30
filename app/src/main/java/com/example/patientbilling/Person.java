package com.example.patientbilling;

public class Person {

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


}
