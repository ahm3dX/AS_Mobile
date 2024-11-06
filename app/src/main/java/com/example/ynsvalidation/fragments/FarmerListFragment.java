package com.example.ynsvalidation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ynsvalidation.MainActivity;
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

        Button addFarmerButton = view.findViewById(R.id.button_add_farmer);
        addFarmerButton.setOnClickListener(v -> {
            ((MainActivity) getActivity()).navigateToCreateFarmer();
        });

        db = AppDatabase.getDatabase(getContext());
        new Thread(() -> {
            List<Farmer> farmers = db.farmerDao().getAllFarmers();
            getActivity().runOnUiThread(() -> {
                farmerAdapter = new FarmerAdapter(farmers,db);
                recyclerView.setAdapter(farmerAdapter);
            });
        }).start();

        return view;
    }
}
