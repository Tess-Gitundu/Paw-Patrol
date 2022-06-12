package com.example.gitundu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gitundu.R;
import com.example.gitundu.models.Animal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PetListAdapter extends RecyclerView.Adapter<PetListAdapter.PetViewHolder> {
    private List<Animal> mPets;
    private Context mContext;

    public PetListAdapter(Context context, List<Animal> pets) {
        mContext = context;
        mPets = pets;
    }

    @NonNull
    @Override
    public PetListAdapter.PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_list_item, parent, false);
        PetViewHolder viewHolder = new PetViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PetListAdapter.PetViewHolder holder, int position) {
        holder.bindPet(mPets.get(position));
    }

    @Override
    public int getItemCount() {
        return mPets.size();
    }

    public class PetViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.petImageView) ImageView mPetImageView;
        @BindView(R.id.petNameTextView) TextView mPetNameTextView;
        @BindView(R.id.breedTextView) TextView mBreedTextView;
        @BindView(R.id.contactTextView) TextView mContactTextView;

        private Context mContext;

        public PetViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindPet(Animal pet) {
            mPetNameTextView.setText(pet.getName());
            mBreedTextView.setText(pet.getBreeds().getPrimary());
            mContactTextView.setText(pet.getContact().getEmail());
        }
    }
}
