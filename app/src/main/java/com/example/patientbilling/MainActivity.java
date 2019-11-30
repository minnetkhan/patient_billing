package com.example.patientbilling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/*
    ...
        First Screen of the App
        Log in button...
    ...
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLogin(View view) {
        /*
            Goto LoggedInScreen.java
         */
        Intent intent = new Intent(this, MainDashBoard.class);
        startActivity(intent);
    }
}
