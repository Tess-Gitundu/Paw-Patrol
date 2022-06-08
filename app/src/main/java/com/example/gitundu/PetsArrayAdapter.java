package com.example.gitundu;

import android.content.Context;
import android.widget.ArrayAdapter;

public class PetsArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mPets;

    public PetsArrayAdapter(Context mContext, int resource, String[] mPets) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mPets = mPets;
    }

    @Override
    public Object getItem(int position) {
        String pets = mPets[position];
        return String.format(pets);
    }

    @Override
    public int getCount() {
        return mPets.length;
    }
}
