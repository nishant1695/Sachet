package com.sachet.android.sachet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button SignUpforFree;
    private Button SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignUpforFree = (Button) findViewById(R.id.signup_forfree);
        SignIn = (Button) findViewById(R.id.signin_mainpage);
        SignUpforFree.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(MainActivity.this, RegisterYourself.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });


        SignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(MainActivity.this, Login.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });

        ImageButton emergency = (ImageButton) findViewById(R.id.emergency);
        emergency.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, EmergencyContacts.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
        ImageButton crime  = (ImageButton) findViewById(R.id.crime);
        crime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, Crimes.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
        ImageButton map = (ImageButton) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, Map.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });

        ImageButton help = (ImageButton) findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, Help.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
        ImageButton knowyourlocality = (ImageButton) findViewById(R.id.knowyourlocality);
        knowyourlocality.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, KnowYourLocality.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });



        ImageButton beaware = (ImageButton) findViewById(R.id.beaware);
        beaware.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, Beaware.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });


         ImageButton district = (ImageButton) findViewById(R.id.district);
        district.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, DelhiDistricts.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
        ImageButton feedback = (ImageButton) findViewById(R.id.feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(MainActivity.this, Feedback.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });

    }
}
