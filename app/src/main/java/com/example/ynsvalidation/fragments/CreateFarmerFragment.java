package com.example.ynsvalidation.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.room.Room;

import com.example.ynsvalidation.MainActivity;
import com.example.ynsvalidation.R;
import com.example.ynsvalidation.database.AppDatabase;
import com.example.ynsvalidation.database.Farmer;

import java.io.Console;
import java.util.Objects;


public class CreateFarmerFragment extends Fragment {
    private AppDatabase db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_farmer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        db = AppDatabase.getDatabase(getContext());

        EditText farmerName,farmerMail,farmerAge;
        farmerMail = view.findViewById(R.id.editText_farmer_email);
        farmerName = view.findViewById(R.id.editText_farmer_name);
        farmerAge = view.findViewById(R.id.editText_farmer_age);
        Farmer farmer = new Farmer();

        // Add logic for form submission or navigation
        Button createFarmerButton = view.findViewById(R.id.button_create_farmer);
        createFarmerButton.setOnClickListener(v -> {
            farmer.age= Integer.parseInt(farmerAge.getText().toString());
            farmer.name = farmerName.getText().toString();
            farmer.email = farmerMail.getText().toString();
            new Thread(() -> {
                db.farmerDao().insertFarmer(farmer);
                System.out.println(farmer.email);

                //  Navigation.findNavController(view).navigate();
            }).start();
            FarmerListFragment farmerListFragment = new FarmerListFragment();

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, farmerListFragment);
            fragmentTransaction.commit();        });
    }
}
