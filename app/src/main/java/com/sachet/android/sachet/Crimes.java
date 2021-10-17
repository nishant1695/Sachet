package com.sachet.android.sachet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Crimes extends AppCompatActivity
{

    ListView list_crime ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crimes);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("List of Crimes");



        ArrayList<String> CrimeList = new ArrayList<>();
        CrimeList.add("Murder");
        CrimeList.add("Attempt to Murder");
        CrimeList.add("Voluntarily Causing Hurt");
        CrimeList.add("Criminal Intimidation");
        CrimeList.add("Rape");
        CrimeList.add("Voluntarily Causing Hurt by Dangerous Weapons or Means");
        CrimeList.add("Theft");
        CrimeList.add("Criminal Conspiracy");
        CrimeList.add("Wrongful Restraint");
        CrimeList.add("Intentional insult with intent to provoke breach of the peace");
        CrimeList.add("Rioting");
        CrimeList.add("Rash Driving");
        CrimeList.add("Kidnapping, abducting or inducing woman to compel her marriage");
        CrimeList.add("Assault or criminal force to woman with intent to outrage her modesty");
        CrimeList.add("House-trespass after preparation for hurt, assault or wrong\u00ADful restraint.");
        CrimeList.add("Punishment for Kidnapping.");
        CrimeList.add("Punishment for Dacoity");
        CrimeList.add("Causing Death by Negligence.");
        CrimeList.add("Abetment of Suicide");
        CrimeList.add("Obscene acts and songs.");
        CrimeList.add("Eve-teasing");
        CrimeList.add("Unlawful Compulsory Labour");

        ArrayAdapter<String> CrimeAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,CrimeList);
        list_crime = (ListView) findViewById(R.id.listCrimes);
        list_crime.setAdapter(CrimeAdapter);

            list_crime.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Intent intent = new Intent(Crimes.this, ListCrimeDetails.class);
                    String crime_name = list_crime.getItemAtPosition(position).toString();
                    intent.putExtra("c_name",crime_name);
                    startActivity(intent);
                }
            });
    }
}
