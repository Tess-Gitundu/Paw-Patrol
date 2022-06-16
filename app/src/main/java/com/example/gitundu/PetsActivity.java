package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gitundu.adapters.PetListAdapter;
import com.example.gitundu.network.PetFinderClient;
import com.example.gitundu.models.Animal;
import com.example.gitundu.models.PetFinderAnimalsResponse;
import com.example.gitundu.network.PetFinderApi;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetsActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private String mRecentStatus;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private PetListAdapter mAdapter;
    public List<Animal> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentStatus = mSharedPreferences.getString(Constansts.PREFERENCES_FINDER_KEY, null);
        Log.d("Shared Pref Status", mRecentStatus);


        Intent intent = getIntent();
        String finder = intent.getStringExtra("finder");

        PetFinderApi client = PetFinderClient.getClient();
        Log.e("finderLog", "check finder" + finder);
        Call<PetFinderAnimalsResponse> call = client.getPets(finder);
        call.enqueue(new Callback<PetFinderAnimalsResponse>() {
            @Override
            public void onResponse(Call<PetFinderAnimalsResponse> call, Response<PetFinderAnimalsResponse> response) {

                hideProgressBar();

                if (response.isSuccessful()) {
                    pets = response.body().getAnimals();
                    mAdapter = new PetListAdapter(PetsActivity.this, pets);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PetsActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);

                    showPets();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<PetFinderAnimalsResponse> call, Throwable t) {
                hideProgressBar();
                showFailureMessage();
            }
        });
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showPets() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}