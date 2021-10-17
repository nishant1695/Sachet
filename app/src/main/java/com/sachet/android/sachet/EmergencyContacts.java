package com.sachet.android.sachet;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class EmergencyContacts extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
     Button Police; //Police
     Button Fire; //Fire
     Button Ambulance; //Ambulance
     Button DisasterManagement; //Ambulance
     Button WomenHelpline; //Ambulance

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency_contact);


        Police = (Button) findViewById(R.id.police);
        Police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Police();
            }
        });

        Fire = (Button) findViewById(R.id.fire);
        Fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fire();
            }
        });

        WomenHelpline = (Button) findViewById(R.id.women_helpline);
        WomenHelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WomenHelpline();
            }
        });

        DisasterManagement = (Button) findViewById(R.id.disaster_management);
        DisasterManagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisasterManagement();
            }
        });


        Ambulance = (Button) findViewById(R.id.ambulance);
        Ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ambulance();
            }
        });
    }
    public void Police ()
    {
        String police = "100";
        Intent intent = new Intent(Intent.ACTION_CALL);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(EmergencyContacts.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            return;
        }
        else
        {
            intent.setData(Uri.parse("tel:" + police));
            startActivity(intent);
        }
    }
    public void Ambulance ()
    {
        String ambulance = "102";
        Intent intent = new Intent(Intent.ACTION_CALL);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(EmergencyContacts.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            return;
        }
        else
        {
            intent.setData(Uri.parse("tel:" + ambulance));
            startActivity(intent);
        }
    }
    public void Fire ()
    {
        String fire = "101";
        Intent intent = new Intent(Intent.ACTION_CALL);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(EmergencyContacts.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            return;
        }
        else
        {
            intent.setData(Uri.parse("tel:" + fire));
            startActivity(intent);
        }
    }
    public void DisasterManagement ()
    {
        String dm = "108";
        Intent intent = new Intent(Intent.ACTION_CALL);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(EmergencyContacts.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            return;
        }
        else
        {
            intent.setData(Uri.parse("tel:" + dm));
            startActivity(intent);
        }
    }
    public void WomenHelpline ()
    {
        String dm = "191";
        Intent intent = new Intent(Intent.ACTION_CALL);

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(EmergencyContacts.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            return;
        }
        else
        {
            intent.setData(Uri.parse("tel:" + dm));
            startActivity(intent);
        }
    }

}
