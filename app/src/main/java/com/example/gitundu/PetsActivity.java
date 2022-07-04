package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gitundu.adapters.PetListAdapter;
import com.example.gitundu.network.PetFinderClient;
import com.example.gitundu.models.Animal;
import com.example.gitundu.models.PetFinderAnimalsResponse;
import com.example.gitundu.network.PetFinderApi;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetsActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private String mRecentStatus;
    private SharedPreferences.Editor mEditor;

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
        mRecentStatus = mSharedPreferences.getString(Constants.PREFERENCES_FINDER_KEY, null);
        if (mRecentStatus != null) {
            fetchPets(mRecentStatus);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String finder) {
                addToSharedPreferences(finder);
                fetchPets(finder);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
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

    private void addToSharedPreferences(String finder) {
        mEditor.putString(Constants.PREFERENCES_FINDER_KEY, finder).apply();
    }

    private void fetchPets(String finder) {
        PetFinderApi client = PetFinderClient.getClient();
        Call<PetFinderAnimalsResponse> call = client.getPets(mRecentStatus);
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
}