package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignupActivity extends AppCompatActivity {
//    @BindView(R.id.signUpTextView) TextView mSignUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
//        ButterKnife.bind(this);
//
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        mSignUpTextView.setText("Here are all the animals you can adopt " + name);
    }
}