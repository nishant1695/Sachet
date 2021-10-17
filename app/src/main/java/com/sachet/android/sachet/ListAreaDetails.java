package com.sachet.android.sachet;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListAreaDetails extends AppCompatActivity {

    Statement statement;
    String query;
    ResultSet result;
    connection con = new connection();
    private Button call_ps;
    private static final int REQUEST_CALL = 1;
    String number,police_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_area_details);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_area_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Area Details");

        String area_name = getIntent().getStringExtra("a_name");

        TextView a_name = findViewById(R.id.edit_aname_tv);
        TextView pincode = findViewById(R.id.edit_pincode_tv);
        TextView area = findViewById(R.id.edit_total_listarea_tv);
        TextView longitude = findViewById(R.id.area_longitude_tv);
        TextView latitude = findViewById(R.id.area_latitude_tv);
        TextView police_s = findViewById(R.id.edit_ps_tv);
        TextView frequent_crime = findViewById(R.id.edit_frequent_crime_tv);
        TextView police_address = findViewById(R.id.edit_ps_adds_tv);
        call_ps = (Button) findViewById(R.id.ps_contact);

        a_name.setText(area_name);

        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            query = "Select * from AREA where ANAME = '" + area_name + "'";
            Connection c = con.connect();
            statement = c.createStatement();
            result = statement.executeQuery(query);
            while (result.next()) {
                pincode.setText(result.getString("PINCODE"));
                area.setText(result.getString("TOT_AREA"));
                latitude.setText(result.getString("LAT"));
                longitude.setText(result.getString("LON"));
                police_s.setText(result.getString("POL_STATION"));
                police_name=result.getString("POL_STATION");

            }

            query = "Select CNAME from CRIME where CCODE = (Select CCODE_P from AREA where ANAME = '"+area_name+"')";
            result = statement.executeQuery(query);
            result.next();
            frequent_crime.setText(result.getString("CNAME"));

            query = "Select ADDRESS,CONTACT_NO from POLICE_STATION where PSNAME = '"+police_name+"'";
            result = statement.executeQuery(query);
            result.next();
            number = result.getString("CONTACT_NO").trim();
            police_address.setText(result.getString("ADDRESS"));



            call_ps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callPolice(number);
                }
            });

            statement.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        con.disconnect();

    }

    public void callPolice (String n)
    {
        String police = "011"+n;
        Intent intent = new Intent(Intent.ACTION_CALL);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(ListAreaDetails.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            return;
        }
        else
        {
            intent.setData(Uri.parse("tel:" + police));
            startActivity(intent);
        }
    }
}
