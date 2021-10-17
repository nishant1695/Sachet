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

import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Forgot_Password extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private EditText ReEnterPassword;
    private Button ResetPassword;
    private Button Contact_Us;
    private TextView NeedMoreHelp;

    Statement statement;
    String query;
    ResultSet result;
    connection con = new connection();

    private String username,password,reenterpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_forget_password);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login Help");

        Username = (EditText) findViewById(R.id.forgetpass_username);
        Password = (EditText) findViewById(R.id.forgetpass_password);
        ReEnterPassword = (EditText) findViewById(R.id.forgetpass_re_enter_password);
        ResetPassword = (Button) findViewById(R.id.reset_password);
        Contact_Us = (Button) findViewById(R.id.forget_pass_contact_us);
        NeedMoreHelp = (TextView) findViewById(R.id.forget_pass_needmorehelp);

        ResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = Username.getText().toString().toLowerCase().trim();
                password = Password.getText().toString().trim();
                reenterpass = ReEnterPassword.getText().toString().trim();

                try {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    query = "Select * from USER where E_MAIL = '" + username + "'";
                    Connection c = con.connect();
                    statement = c.createStatement();
                    result = statement.executeQuery(query);
                    if(result.next())
                    {
                        if((password.length()>5) && (password.length()<11))
                        {
                            if(password.equals(reenterpass)) {
                                query = "Update USER set PASSWORD='" + password + "' where E_MAIL = '" + username + "'";
                                int status = statement.executeUpdate(query);
                                if (status != 0) {
                                    Toast.makeText(Forgot_Password.this, "Password reset successful! Use new password to login!", Toast.LENGTH_SHORT).show();
                                    Intent activityChangeIntent = new Intent(Forgot_Password.this, Login.class);
                                    startActivity(activityChangeIntent);
                                    finish();
                                }
                            }
                            else
                            {
                                Toast.makeText(Forgot_Password.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Forgot_Password.this, "Enter a valid password of length 6-10 characters!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    else
                    {
                        Toast.makeText(Forgot_Password.this, "User with this email id doesn't exist!", Toast.LENGTH_SHORT).show();
                    }
                    statement.close();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });


        Contact_Us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityChangeIntent = new Intent(Forgot_Password.this, Contact_Us.class);
                startActivity(activityChangeIntent);
            }
        });

        con.disconnect();

    }
}
