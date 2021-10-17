package com.sachet.android.sachet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class KnowYourLocality extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.knowyourlocality);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_know_your_locality);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Know your locality");




    }
}
