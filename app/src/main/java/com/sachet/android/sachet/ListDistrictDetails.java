package com.sachet.android.sachet;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ListDistrictDetails extends AppCompatActivity {

    Statement statement;
    String query;
    ResultSet result;
    int zcode;
    List areas = new ArrayList();
    connection con = new connection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_district_details);
        String district_name = getIntent().getStringExtra("d_name");
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_district_details);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("District Details");

        TextView district = findViewById(R.id.edit_zname_tv);
        TextView hq = findViewById(R.id.edit_hq_tv);
        TextView area = findViewById(R.id.edit_total_area_tv);
        TextView longitude = findViewById(R.id.longitude_tv);
        TextView latitude = findViewById(R.id.latitude_tv);
        TextView police_s = findViewById(R.id.edit_no_of_ps_tv);
        TextView prime_time = findViewById(R.id.edit_prime_time_tv);
        final ListView list_of_areas = findViewById(R.id.list_area);

        district.setText(district_name);

        try{
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            query = "Select * from DISTRICT where ZNAME = '"+district_name+"'";
            Connection c = con.connect();
            statement = c.createStatement();
            result = statement.executeQuery(query);
            while(result.next())
            {
                hq.setText(result.getString("HQ"));
                area.setText(result.getString("TOTAL_AREA"));
                latitude.setText(result.getString("LATITUDE"));
                longitude.setText(result.getString("LONGITUDE"));
                prime_time.setText(result.getString("PRIME_TIME_OF_CRIME"));
                police_s.setText(result.getString( "NO_OF_PS"));

            }

            query = "Select ZCODE from DISTRICT where ZNAME = '"+district_name+"'";
            result = statement.executeQuery(query);
            result.next();
            zcode = Integer.parseInt(result.getString(1));
            Log.i("Zcode: ", result.getString(1));

            query = "Select ANAME from AREA where ZCODE = "+zcode;
            result = statement.executeQuery(query);
            while(result.next())
            {
                areas.add(result.getString(1));
            }

            ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,areas);
            list_of_areas.setAdapter(adapter);
            statement.close();


            list_of_areas.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Intent intent = new Intent(ListDistrictDetails.this, ListAreaDetails.class);
                    String area_name = list_of_areas.getItemAtPosition(position).toString();
                    intent.putExtra("a_name",area_name);
                    startActivity(intent);

                }
            });
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        finally {
            con.disconnect();
        }

    }
}
