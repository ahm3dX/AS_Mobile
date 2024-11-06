package com.example.ynsvalidation.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ynsvalidation.MainActivity;
import com.example.ynsvalidation.R;
import com.example.ynsvalidation.database.AppDatabase;
import com.example.ynsvalidation.database.Farmer;

public class CreateFarmerFragment extends Fragment {
    private AppDatabase db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create_farmer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = AppDatabase.getDatabase(getContext());

        EditText farmerName = view.findViewById(R.id.editText_farmer_name);
        EditText farmerMail = view.findViewById(R.id.editText_farmer_email);
        EditText farmerAge = view.findViewById(R.id.editText_farmer_age);

        Button createFarmerButton = view.findViewById(R.id.button_create_farmer);
        createFarmerButton.setOnClickListener(v -> {
            Farmer farmer = new Farmer();
            farmer.name = farmerName.getText().toString();
            farmer.email = farmerMail.getText().toString();
            farmer.age = Integer.parseInt(farmerAge.getText().toString());

            new Thread(() -> {
                db.farmerDao().insertFarmer(farmer);
            }).start();

            ((MainActivity) getActivity()).navigateToFarmersList();
        });

        Button viewFarmersButton = view.findViewById(R.id.button_view_farmers);
        viewFarmersButton.setOnClickListener(v -> {
            ((MainActivity) getActivity()).navigateToFarmersList();
        });
    }
}
