package com.sachet.android.sachet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Help_Area_NotFound extends AppCompatActivity {

    private String District, Area, Pincode,report;

    private EditText districtName;
    private EditText AreaName;
    private EditText AreaPincode;
    private Button submit_report;
    private Button contact_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help__area__not_found);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_help_area_not_found);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Help and Support");

        districtName = (EditText) findViewById(R.id.edit_enter_district_tv);
        AreaName = (EditText) findViewById(R.id.edit_enter_area_tv);
        AreaPincode = (EditText) findViewById(R.id.edit_enter_area_pincode_tv);
        submit_report = (Button) findViewById(R.id.report_submit);
        contact_us = (Button) findViewById(R.id.contact_us);

        District = districtName.getText().toString();
        Area = AreaName.getText().toString();
        Pincode = AreaPincode.getText().toString();


        report = "District Name : " + District + " Area Name : " + Area + " Pincode : " + Pincode;
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
                Intent activityChangeIntent = new Intent(Help_Area_NotFound.this, Contact_Us.class);
                // currentContext.startActivity(activityChangeIntent);
                startActivity(activityChangeIntent);
            }
        });
    }
}
