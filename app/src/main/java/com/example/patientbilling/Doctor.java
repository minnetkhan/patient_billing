package com.example.patientbilling;

public class Doctor extends Person {

    public Doctor(String name, String personID, int contactNumber, String gender, String blood_group, int consul_fee) {
        super(name, personID, contactNumber, gender, blood_group);
        this.consul_fee = consul_fee;
    }

    private int consul_fee;


    public int getConsul_fee() {
        return consul_fee;
    }

    public void setConsul_fee(int consul_fee) {
        this.consul_fee = consul_fee;
    }



}
