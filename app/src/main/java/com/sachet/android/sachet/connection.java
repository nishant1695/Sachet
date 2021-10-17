package com.sachet.android.sachet;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    String url = "jdbc:mysql://192.168.2.45:3306/SACHET";
    String user = "phpmyadmin";
    String pass = "adj123456";
    Connection c;

    Connection connect()
    {
       try {
           Class.forName("com.mysql.jdbc.Driver");
           c = DriverManager.getConnection(url, user, pass);
       }
       catch(Exception e) {
           e.printStackTrace();
       }
       Log.i("Pass: ","Connection Successfully established!");
       return c;
    }

    void disconnect()
    {
       try{
           c.close();
       }
       catch(Exception e)
       {
           Log.i("Failure: ","Failed!!");
           e.printStackTrace();
       }
       Log.i("Pass: ","Connection successfully closed");
    }
}
