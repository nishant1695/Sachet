package com.sachet.android.sachet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Help extends AppCompatActivity{

    private Button AreaNotFound;
    private Button CrimeNotFound;
    private Button UnableLogin;
    private Button Report;
    private Button ContactUs;
    private EditText report_mail;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_help);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Help and Support");

        AreaNotFound = (Button) findViewById(R.id.area_not_found);
        CrimeNotFound = (Button) findViewById(R.id.crime_not_found);
        UnableLogin = (Button) findViewById(R.id.unable_login);
        Report = (Button) findViewById(R.id.submit);
        ContactUs = (Button) findViewById(R.id.help_contact_us);
        report_mail = (EditText) findViewById(R.id.edit_report_query);
        final String message = report_mail.getText().toString();


        AreaNotFound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(Help.this, Help_Area_NotFound.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });

        CrimeNotFound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(Help.this, Help_Crime_NotFound.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);

            }
        });

        Report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "saurabh.jain@iic.ac.in");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Help Desk Query ");
                intent.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });

        ContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(Help.this, Contact_Us.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
    }

  }
