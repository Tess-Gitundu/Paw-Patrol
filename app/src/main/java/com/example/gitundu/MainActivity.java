package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.seeAllPetsButton) Button mSeeAllPetsButton;
    @BindView(R.id.petFinderText) EditText mPetFinderText;
    @BindView(R.id.signUpButton) Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSeeAllPetsButton.setOnClickListener(this);
        mSignUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mSeeAllPetsButton) {
            String finder = mPetFinderText.getText().toString();
            Intent intent = new Intent(MainActivity.this, PetsActivity.class);
            intent.putExtra("finder", finder);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Jumping to all pets", Toast.LENGTH_LONG).show();
        }
    }

}