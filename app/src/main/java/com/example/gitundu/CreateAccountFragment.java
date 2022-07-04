package com.example.gitundu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CreateAccountFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.createAccount) Button mCreateAccount;
    @BindView(R.id.name) EditText mName;
    @BindView(R.id.email) EditText mEmail;
    @BindView(R.id.pass) EditText mPassword;
    @BindView(R.id.confirmPass) EditText mConfirmPassword;

    public static final String TAG = CreateAccountActivity.class.getSimpleName();
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mAuth = FirebaseAuth.getInstance();

        mCreateAccount.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == mCreateAccount) {
            createNewUser();
        }
    }

    private void createNewUser() {
        final String name = mName.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        String password = mPassword.getText().toString().trim();
        String confirmPassword = mConfirmPassword.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Executor) this, task -> {
            if (task.isSuccessful()) {
                Log.d(TAG, "Authentication successful");
            } else {
                Toast.makeText(getActivity(), "Authentication failed.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void CreateAccountActivity() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}