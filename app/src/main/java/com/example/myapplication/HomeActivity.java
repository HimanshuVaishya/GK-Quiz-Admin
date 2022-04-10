package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.category.CategoryActivity;
import com.example.myapplication.feedback.FeedbackActivity;

public class HomeActivity extends AppCompatActivity {

    TextView gk, feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gk = findViewById(R.id.gk);
        feed = findViewById(R.id.feed);

        gk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGK = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intentGK);
            }
        });

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFEED = new Intent(HomeActivity.this, FeedbackActivity.class);
                startActivity(intentFEED);
            }
        });



    }
}