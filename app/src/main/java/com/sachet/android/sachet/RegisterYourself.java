package com.sachet.android.sachet;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.IntRange;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RegisterYourself extends AppCompatActivity {

    private EditText name;
    private EditText emailID;
    private EditText area;
    private EditText pincode;
    private EditText phone;
    private EditText password;
    private Button signup;

    Statement statement;
    String query;
    ResultSet result;
    connection con = new connection();
    String nm,em,pwd,ar,phone_no;
    int pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_yourself);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_register_yourself);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sign Up");

        name = (EditText) findViewById(R.id.name);
        emailID = (EditText) findViewById(R.id.email_id);
        area = (EditText) findViewById(R.id.area);
        pincode = (EditText) findViewById(R.id.pincode);
        phone = (EditText) findViewById(R.id.phone);
        signup = (Button) findViewById(R.id.sign_up);
        password = (EditText) findViewById(R.id.password);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm=name.getText().toString().trim();
                em=emailID.getText().toString().toLowerCase().trim();
                ar=area.getText().toString().trim();
                pin=Integer.parseInt(pincode.getText().toString().trim());
                phone_no=phone.getText().toString().trim();
                pwd=password.getText().toString().trim();

                if(nm==null || em==null || pwd ==null || ar ==null || pin==0 || (pwd.length()<6) || (pwd.length()>10))
                {
                    if(pwd.length()<6)
                    {
                        Toast.makeText(RegisterYourself.this,"Password too short! Use a password of 6-10 characters without spaces!",Toast.LENGTH_SHORT).show();
                    }
                    else if((pwd.length()>10))
                    {
                        Toast.makeText(RegisterYourself.this,"Password too long! Use a password of 6-10 characters without spaces!",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(RegisterYourself.this,"Please fill all the fields marked with asterisk(*)",Toast.LENGTH_SHORT).show();
                    }
                }

                else {
                    if(phone_no==null)
                    {
                        phone_no="0";
                    }
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    Connection c = con.connect();
                    try {
                        query="Select * from USER where E_MAIL='"+em+"'";
                        statement = c.createStatement();
                        result = statement.executeQuery(query);
                        if(result.next())
                        {
                            Toast.makeText(RegisterYourself.this,"Email ID already registered! Please login!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            query = "Insert into USER(NAME,E_MAIL,LOCATION,ACODE,PHONE_NO,PASSWORD)" + "Values('" + nm + "','" + em + "','" + ar + "'," + pin + ",'" + phone_no + "','" + pwd + "')";
                            int answer = statement.executeUpdate(query);
                            if (answer != 0) {

                                Toast.makeText(RegisterYourself.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                                Intent activityChangeIntent = new Intent(RegisterYourself.this, User.class);
                                String user_name = nm;
                                activityChangeIntent.putExtra("user_name",user_name);
                                startActivity(activityChangeIntent);
                                finish();
                            }
                        }
                        result.close();
                        statement.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    con.disconnect();
                }
            }
        });
    }
}

