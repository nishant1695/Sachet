package com.sachet.android.sachet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Contact_Us extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_contact_us);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Contact Us");



    }
}
