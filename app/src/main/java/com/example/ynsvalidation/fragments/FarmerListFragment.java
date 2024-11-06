package com.example.ynsvalidation.fragments;


import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;


import com.example.ynsvalidation.R;
import com.example.ynsvalidation.adapters.FarmerAdapter;
import com.example.ynsvalidation.database.AppDatabase;
import com.example.ynsvalidation.database.Farmer;

import java.util.List;

public class FarmerListFragment extends Fragment {
    private RecyclerView recyclerView;
    private FarmerAdapter farmerAdapter;
    private AppDatabase db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farmer_list, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



        db = AppDatabase.getDatabase(getContext());


        new Thread(() -> {
            List<Farmer> farmers = db.farmerDao().getAllFarmers();
            getActivity().runOnUiThread(() -> {
                farmerAdapter = new FarmerAdapter(farmers);
                recyclerView.setAdapter(farmerAdapter);
            });
        }).start();

        return view;
    }
}

