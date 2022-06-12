package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    @BindView(R.id.finderTextView) TextView mFinderTextView;
    @BindView(R.id.petsListView) ListView mPetsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        ButterKnife.bind(this);

        mPetsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String pet = ((TextView)view).getText().toString();
                Toast.makeText(PetsActivity.this, pet, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String finder = intent.getStringExtra("finder");
        mFinderTextView.setText("Here are all the pets you can adopt in your area: " + finder);

        PetFinderApi client = PetFinderClient.getClient();
        Log.e("finderLog", "check finder" + finder);
        Call<PetFinderAnimalsResponse> call = client.getPets(finder);
        call.enqueue(new Callback<PetFinderAnimalsResponse>() {
            @Override
            public void onResponse(Call<PetFinderAnimalsResponse> call, Response<PetFinderAnimalsResponse> response) {
                if (response.isSuccessful()) {
                    Log.e("success", "Response is successful");
                    List<Animal> petsList = response.body().getAnimals();
                    String[] pets = new String[petsList.size()];

                    for (int i = 0; i < pets.length; i++) {
                        pets[i] = petsList.get(i).getType();
                    }
                    ArrayAdapter adapter = new PetsArrayAdapter(PetsActivity.this, android.R.layout.simple_list_item_1, pets);
                    mPetsListView.setAdapter(adapter);
                } else {
                    Log.e("onFailure", "ResponseFailure" + response.code());
                }
            }

            @Override
            public void onFailure(Call<PetFinderAnimalsResponse> call, Throwable t) {
                Log.e("Error Message", "onFailure: ", t);
            }
        });
    }
}