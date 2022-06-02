package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mSeeAllPetsButton; //a member variable to hold our seeAllPetsButton to access it inside all of our methods
    private EditText mPetFinderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPetFinderText = (EditText) findViewById(R.id.petFinderText);
        mSeeAllPetsButton = (Button)findViewById(R.id.seeAllPetsButton);
        mSeeAllPetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String finder = mPetFinderText.getText().toString();
                Intent intent = new Intent(MainActivity.this, PetsActivity.class);
                intent.putExtra("finder", finder);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Jumping to all pets", Toast.LENGTH_LONG).show();
            }
        });
    }
}