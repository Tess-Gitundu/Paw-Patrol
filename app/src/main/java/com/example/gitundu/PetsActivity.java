package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PetsActivity extends AppCompatActivity {
    @BindView(R.id.finderTextView) TextView mFinderTextView;
    @BindView(R.id.petsListView) ListView mPetsListView;
    private String[] pets = new String[] {"Dogs", "Cats", "Ferrets", "Rabbits", "Rodents", "Hedgehog", "Tenrecs", "Fish", "Reptiles", "Amphibians"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, pets);
        mPetsListView.setAdapter(adapter);

        Intent intent = getIntent();
        String finder = intent.getStringExtra("finder");
        mFinderTextView.setText("Here are all the pets you can adopt in your area: " + finder);
    }
}