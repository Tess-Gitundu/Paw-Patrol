package com.example.gitundu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gitundu.models.Animal;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PetDetailFragment extends Fragment implements View.OnClickListener{

    @BindView(R.id.petImageView) ImageView mImageLabel;
    @BindView(R.id.petNameTextView) TextView mNameLabel;
    @BindView(R.id.breedTextView) TextView mBreedsLabel;
    @BindView(R.id.contactTextView) TextView mContactLabel;
    @BindView(R.id.websiteTextView) TextView mWebsiteLabel;
    @BindView(R.id.phoneTextView) TextView mPhoneLabel;
    @BindView(R.id.addressTextView) TextView mAddressLabel;
    @BindView(R.id.savePetButton) Button mSavePetButton;

    private Animal mPet;


    public PetDetailFragment() {
        // Required empty public constructor
    }

    public static PetDetailFragment newInstance(Animal pet) {
        PetDetailFragment petDetailFragment = new PetDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("pet", Parcels.wrap(pet));
        petDetailFragment.setArguments(args);
        return petDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mPet = Parcels.unwrap(getArguments().getParcelable("pet"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pet_detail, container, false);
        ButterKnife.bind(this, view);
        //            Picasso.get().load(pet.getPhotos().size()).into(mImageLabel);
        mNameLabel.setText(mPet.getName());
//        mBreedsLabel.setText(mPet.getBreeds().getPrimary());
        mContactLabel.setText(mPet.getContact().getEmail());
        mPhoneLabel.setText(mPet.getContact().getEmail());
        mAddressLabel.setText(mPet.getPublishedAt());

        mSavePetButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mSavePetButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();
            DatabaseReference petRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_PETS).child(uid);
            DatabaseReference pushRef = petRef.push();
            String pushId = pushRef.getKey();
            mPet.setPushId(pushId);
            pushRef.setValue(mPet);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}