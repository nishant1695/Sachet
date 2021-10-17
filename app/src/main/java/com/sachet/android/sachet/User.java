package com.sachet.android.sachet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class User extends AppCompatActivity {

    private TextView Username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        String user_name = getIntent().getStringExtra("user_name");
        Username = (TextView) findViewById(R.id.hello_user);
        Username.setText("Hello " + user_name + ",");


        ImageButton emergency = (ImageButton) findViewById(R.id.user_emergency_icon);
        emergency.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(User.this, EmergencyContacts.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
        ImageButton crime  = (ImageButton) findViewById(R.id.user_crime_icon);
        crime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(User.this, Crimes.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
        ImageButton map = (ImageButton) findViewById(R.id.user_map_icon);
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(User.this, Map.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });

        ImageButton help = (ImageButton) findViewById(R.id.user_help_icon);
        help.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(User.this, Help.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
        ImageButton knowyourlocality = (ImageButton) findViewById(R.id.user_locality_icon);
        knowyourlocality.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(User.this, KnowYourLocality.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });



        ImageButton beaware = (ImageButton) findViewById(R.id.user_beaware_icon);
        beaware.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(User.this, Beaware.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });


        ImageButton district = (ImageButton) findViewById(R.id.user_district_icon);
        district.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(User.this, DelhiDistricts.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
        ImageButton feedback = (ImageButton) findViewById(R.id.user_feedback_icon);
        feedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent activityChangeIntent = new Intent(User.this, Feedback.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });


    }
}
