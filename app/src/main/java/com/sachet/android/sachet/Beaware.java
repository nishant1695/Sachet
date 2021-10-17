package com.sachet.android.sachet;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Beaware extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner district_spinner;
    private EditText Pincode;
    private Button submit;
    String pincode,district_name;
    int district_code;

    Statement statement;
    String query;
    ResultSet result;
    connection con = new connection();

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.beaware);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_beaware);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Beaware");

        district_spinner = (Spinner) findViewById(R.id.district_spinner);
        Pincode = (EditText) findViewById(R.id.be_aware_pincode);
        submit = findViewById(R.id.beaware_button);
        final ListView list_area = (ListView) findViewById(R.id.be_aware_areas);
        final ArrayList AreaList = new ArrayList<>();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                district_name = district_spinner.getSelectedItem().toString().trim();
                pincode = Pincode.getText().toString().trim();
                if(!(district_name=="Select District"))
                {
                    try {
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                        Connection c = con.connect();

                        query = "Select ZCODE from DISTRICT where ZNAME='"+district_name+"'";
                        statement = c.createStatement();
                        result = statement.executeQuery(query);
                        result.next();
                        district_code=Integer.parseInt(result.getString("ZCODE").toString());

                        query = "Select ANAME from AREA where ZCODE="+district_code;
                        result = statement.executeQuery(query);
                        while(result.next())
                        {
                            AreaList.add(result.getString("ANAME").toString().trim());
                        }
                        statement.close();
                        con.disconnect();
                    } catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                else
                {
                    try {
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                        Connection c = con.connect();

                        query = "Select ANAME from AREA where PINCODE="+Integer.parseInt(pincode);
                        statement = c.createStatement();
                        result = statement.executeQuery(query);
                        while(result.next())
                        {
                            AreaList.add(result.getString("ANAME").toString());
                        }
                        statement.close();
                        con.disconnect();
                    } catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });


        ArrayAdapter<CharSequence> distrcit_adapter = ArrayAdapter.createFromResource(this,R.array.delhiDistricts,android.R.layout.simple_spinner_item);
        distrcit_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district_spinner.setAdapter(distrcit_adapter);
        district_spinner.setOnItemSelectedListener(Beaware.this);


        ArrayAdapter<String> AreaAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,AreaList);
        list_area.setAdapter(AreaAdapter);





        list_area.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(Beaware.this, ListAreaDetails.class);
                String area_name = list_area.getItemAtPosition(position).toString();
                intent.putExtra("a_name",area_name);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
// TODO Auto-generated method stub

    }
}
