package com.sachet.android.sachet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DelhiDistricts extends AppCompatActivity {

    ListView list_district;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delhidistrict);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_delhidistrict);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Districts of Delhi");


        ArrayList<String> DistrictList = new ArrayList<>();
        DistrictList.add("Central Delhi");
        DistrictList.add("North Delhi");
        DistrictList.add("South Delhi");
        DistrictList.add("East Delhi");
        DistrictList.add("North East Delhi");
        DistrictList.add("South West Delhi");
        DistrictList.add("New Delhi");
        DistrictList.add("North West Delhi");
        DistrictList.add("West Delhi");


        ArrayAdapter<String> DistrictAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,DistrictList);
        list_district = (ListView) findViewById(R.id.delhi_district);
        list_district.setAdapter(DistrictAdapter);

        list_district.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(DelhiDistricts.this, ListDistrictDetails.class);
                String district_name = list_district.getItemAtPosition(position).toString();
                intent.putExtra("d_name",district_name);
                startActivity(intent);
            }
        });

    }
}
