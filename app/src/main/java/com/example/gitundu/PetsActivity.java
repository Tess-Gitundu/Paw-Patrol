package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PetsActivity extends AppCompatActivity {
    private TextView mFinderTextView;
    private ListView mPetsListView;
    private String[] pets = new String[] {"Dogs", "Cats", "Ferrets", "Rabbits", "Rodents", "Hedgehog", "Tenrecs", "Fish", "Reptiles", "Amphibians"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);

        mPetsListView = (ListView) findViewById(R.id.petsListView);
        mFinderTextView = (TextView) findViewById(R.id.finderTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pets);
        mPetsListView.setAdapter(adapter);

        Intent intent = getIntent();
        String finder = intent.getStringExtra("finder");
        mFinderTextView.setText("Here are all the pets you can adopt in your area: " + finder);
    }
}