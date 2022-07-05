package com.example.gitundu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.gitundu.adapters.FirebasePetViewHolder;
import com.example.gitundu.models.Animal;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedPetsListActivity extends AppCompatActivity {
    private DatabaseReference mPetReference;
    private FirebaseRecyclerAdapter<Animal, FirebasePetViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pets);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mPetReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_PETS).child(uid);
        setUpFirebaseAdapter();
        hideProgressBar();
        showPets();
    }

    private void setUpFirebaseAdapter() {
        FirebaseRecyclerOptions<Animal> options = new FirebaseRecyclerOptions.Builder<Animal>().setQuery(mPetReference, Animal.class).build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Animal, FirebasePetViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebasePetViewHolder holder, int position, @NonNull Animal pet) {
                holder.bindPet(pet);
            }

            @NonNull
            @Override
            public FirebasePetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_list_item, parent, false);
                return new FirebasePetViewHolder(view);
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }

    private void showPets() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}