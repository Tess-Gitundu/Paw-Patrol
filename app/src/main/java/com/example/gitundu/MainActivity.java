package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mSeeAllPetsButton; //a member variable to hold our seeAllPetsButton to access it inside all of our methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeeAllPetsButton = (Button)findViewById(R.id.seeAllPetsButton);
        mSeeAllPetsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Jumping to all pets", Toast.LENGTH_LONG).show();
            }
        });
    }
}