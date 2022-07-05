package com.example.gitundu.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.gitundu.models.Animal;
import com.example.gitundu.utils.ItemTouchHelperAdapter;
import com.example.gitundu.utils.OnStartDragListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;

public class FirebasePetListAdapter extends FirebaseRecyclerAdapter<Animal, FirebasePetViewHolder> implements ItemTouchHelperAdapter {

    private DatabaseReference mRef;
    private OnStartDragListener mOnStartDragListener;
    private Context mContext;

    public FirebasePetListAdapter(FirebaseRecyclerOptions<Animal> options,
                                  DatabaseReference ref,
                                  OnStartDragListener onStartDragListener,
                                  Context context){
        super(options);
        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }

    @Override
    protected void onBindViewHolder(@NonNull FirebasePetViewHolder holder, int position, @NonNull Animal model) {

    }

    @NonNull
    @Override
    public FirebasePetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }
}
