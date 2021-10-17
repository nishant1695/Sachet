package com.sachet.android.sachet;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private TextView signup;
    private Button SignIn;
    private Button ForgetPassword;

    Statement statement;
    String query;
    ResultSet result;
    connection con = new connection();
    String usr,pwd,user_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_login);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sign In");

        Username = (EditText) findViewById(R.id.edit_login_username);
        Password = (EditText) findViewById(R.id.edit_login_password);
        signup = (TextView) findViewById(R.id.link_to_register);
        SignIn = (Button) findViewById(R.id.sign_in);
        ForgetPassword = (Button) findViewById(R.id.forget_password);

        ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(Login.this, Forgot_Password.class);
                startActivity(activityChangeIntent);
                finish();
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(Login.this, RegisterYourself.class);
                startActivity(activityChangeIntent);
                finish();
            }
        });

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pwd=Password.getText().toString().trim();
                if (pwd.length() <= 4) {
                    Toast.makeText(Login.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else {
                    usr = Username.getText().toString().toLowerCase().trim();
                    try {

                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                        StrictMode.setThreadPolicy(policy);
                        Connection c = con.connect();

                        query ="Select * from USER where E_MAIL='"+usr+"'";
                        statement = c.createStatement();
                        result=statement.executeQuery(query);
                        if(result.next()) {
                            if(result.getString("PASSWORD").trim().equals(pwd)) {
                                Toast.makeText(Login.this, "Success", Toast.LENGTH_SHORT).show();
                                user_name=result.getString("NAME");
                                Intent activityChangeIntent = new Intent(Login.this, User.class);
                                activityChangeIntent.putExtra("user_name",user_name);
                                startActivity(activityChangeIntent);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(Login.this, "Password incorrect!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Login.this, "User doesn't exist!", Toast.LENGTH_SHORT).show();
                        }
                        statement.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                con.disconnect();
            }
        });
    }
}
