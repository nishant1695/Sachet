package com.sachet.android.sachet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Feedback extends AppCompatActivity{

    RatingBar knowledge_rb;
    float knowledge;
    RatingBar innovation_rb;
    float innovation;
    RatingBar interaction_rb;
    float interaction;
    RatingBar communication_rb;
    float communication;
    RatingBar overall_rb;
    float overall;
    TextView tv;
    String complete_rating;
    Button bt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar_feedback);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Feedback form");

        tv = (TextView) findViewById(R.id.fb_tv);
        bt = (Button) findViewById(R.id.fb_bt);

        knowledge_rb = (RatingBar)findViewById(R.id.knowledge_rating_bar);

        knowledge_rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

               knowledge = rating;
               Toast.makeText(Feedback.this, "Knowledge :" + knowledge,Toast.LENGTH_LONG).show();

               complete_rating = " Knowledge :" + String.valueOf(rating);
            }
        });

        innovation_rb = (RatingBar)findViewById(R.id.innovation_rating_bar);

        innovation_rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                innovation = rating;
                Toast.makeText(Feedback.this, "Innovation :" + innovation,Toast.LENGTH_LONG).show();
                complete_rating += " Innovation :" + String.valueOf(rating);
            }
        });

        interaction_rb = (RatingBar)findViewById(R.id.interaction_rating_bar);

        interaction_rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

               interaction = rating;
                Toast.makeText(Feedback.this, "Interaction :" + interaction,Toast.LENGTH_LONG).show();
                complete_rating += " Interaction :" + String.valueOf(rating);
            }
        });

        communication_rb = (RatingBar)findViewById(R.id.communication_rating_bar);

        communication_rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                communication = rating;
                Toast.makeText(Feedback.this, "Communication :" + communication,Toast.LENGTH_LONG).show();
                complete_rating += " Communication :" + String.valueOf(rating);
            }
        });

        overall_rb = (RatingBar)findViewById(R.id.overall_ratingBar);

        overall_rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                overall = rating;
                Toast.makeText(Feedback.this, "Overall :" + overall,Toast.LENGTH_LONG).show();
                complete_rating += " Overall :" + String.valueOf(rating);
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(complete_rating);

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "saurabh.jain@iic.ac.in");
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK REPORT");
                intent.putExtra(Intent.EXTRA_TEXT, complete_rating);

                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });



    }
}
