package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PetsActivity extends AppCompatActivity {
    private TextView mFinderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);

        mFinderTextView = (TextView) findViewById(R.id.finderTextView);

        Intent intent = getIntent();
        String finder = intent.getStringExtra("finder");
        mFinderTextView.setText("Here are all the pets you can adopt in your area: " + finder);
    }
}