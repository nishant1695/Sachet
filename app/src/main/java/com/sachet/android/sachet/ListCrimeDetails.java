package com.sachet.android.sachet;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListCrimeDetails extends AppCompatActivity {

    Statement statement;
    String query;
    ResultSet result;
    connection con = new connection();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listcrimedetails);
        String crime_name = getIntent().getStringExtra("c_name");
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_listcrimedetails);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(crime_name);

        TextView ipc = findViewById(R.id.edit_ipc_section);
        TextView summary = findViewById(R.id.edit_summary);
        TextView precaution = findViewById(R.id.edit_pre_cau_ale);
        TextView density = findViewById(R.id.edit_density);



        try {

            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection c = con.connect();


            query ="Select IPC_CODE, DESCRIPTION from CRIME where CNAME = '"+crime_name+"'";
            statement = c.createStatement();
            result = statement.executeQuery(query);
            while(result.next())
            {
                ipc.setText(result.getString("IPC_CODE"));
                summary.setText(result.getString("DESCRIPTION"));
            }

            query ="Select ANAME from AREA where CCODE_P = (Select CCODE from CRIME where CNAME = '"+crime_name+"')";
            result = statement.executeQuery(query);
            if (result.next()) {
                do {

                    density.setText(result.getString(1));

                } while (result.next());
            } else {
                density.setText("No Particular Region");
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        con.disconnect();
    }
}
