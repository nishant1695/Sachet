package com.sachet.android.sachet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Help_Crime_NotFound extends AppCompatActivity {

    private String Area, Pincode, Crime,report;


    private EditText AreaName;
    private EditText AreaPincode;
    private EditText CrimeName;
    private Button submit_report;
    private Button contact_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help__crime__not_found);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_help_crime_not_found);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Help and Support");

        CrimeName = (EditText) findViewById(R.id.edit_enter_cname__tv);
        AreaName = (EditText) findViewById(R.id.edit_helpcrime_enter_area_tv);
        AreaPincode = (EditText) findViewById(R.id.edit_enter_crimehelp_pincode_tv);
        submit_report = (Button) findViewById(R.id.helpcrime_report_submit);
        contact_us = (Button) findViewById(R.id.helpcrime_contact_us);

        Area = AreaName.getText().toString();
        Pincode = AreaPincode.getText().toString();
        Crime = CrimeName.getText().toString();

        report = " Area Name : " + Area + " Pincode : " + Pincode + " Crime Name :" + Crime;
        submit_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "saurabh.jain@iic.ac.in");
                intent.putExtra(Intent.EXTRA_SUBJECT, "HELP REPORT");
                intent.putExtra(Intent.EXTRA_TEXT, report);

                startActivity(Intent.createChooser(intent, "Send Email"));


            }
        });

        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(Help_Crime_NotFound.this, Contact_Us.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });

    }
}
