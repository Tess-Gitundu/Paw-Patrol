package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PetsActivity extends AppCompatActivity {
    @BindView(R.id.finderTextView) TextView mFinderTextView;
    @BindView(R.id.petsListView) ListView mPetsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String finder = intent.getStringExtra("finder");
        mFinderTextView.setText("Here are all the pets you can adopt in your area: " + finder);

        PetFinderApi client = PetFinderClient.getClient();

        Call<PetFinderAnimalsResponse> call = client.getPets(finder);
        call.enqueue(new Callback<PetFinderAnimalsResponse>() {
            @Override
            public void onResponse(Call<PetFinderAnimalsResponse> call, Response<PetFinderAnimalsResponse> response) {
                if (response.isSuccessful()) {
                    List<Animal> petsList = response.body().getAnimals();
                    String[] pets = new String[petsList.size()];

                    for (int i = 0; i < pets.length; i++) {
                        pets[i] = petsList.get(i).getType();
                    }
                    ArrayAdapter adapter = new PetsArrayAdapter(PetsActivity.this, android.R.layout.simple_list_item_1, pets);
                    mPetsListView.setAdapter(adapter);
                } else {
                    Toast.makeText(PetsActivity.this, response.message(), Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<PetFinderAnimalsResponse> call, Throwable t) {
                Log.e("PetsActivity", t.getMessage());
            }
        });
    }
}