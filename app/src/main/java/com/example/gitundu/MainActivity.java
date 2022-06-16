package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @BindView(R.id.seeAllPetsButton) Button mSeeAllPetsButton;
    @BindView(R.id.petFinderText) EditText mPetFinderText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mSeeAllPetsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mSeeAllPetsButton) {
            String finder = mPetFinderText.getText().toString();
            addToSharedPreferences(finder);
            Intent intent = new Intent(MainActivity.this, PetsActivity.class);
            startActivity(intent);
        }
    }

    private void addToSharedPreferences(String finder) {
        mEditor.putString(Constansts.PREFERENCES_FINDER_KEY, finder).apply();
    }
}