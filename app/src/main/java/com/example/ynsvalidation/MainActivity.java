package com.example.ynsvalidation;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ynsvalidation.fragments.CreateFarmerFragment;
import com.example.ynsvalidation.fragments.FarmerListFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CreateFarmerFragment())
                    .commit();
        }
    }

    public void navigateToCreateFarmer() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new CreateFarmerFragment())
                .addToBackStack(null)
                .commit();
    }
    public void navigateToFarmersList() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new FarmerListFragment())
                .addToBackStack(null)
                .commit();
    }

    /*public void navigateToCreateFarm() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new CreateFarmFragment())
                .addToBackStack(null)
                .commit();
    }

    public void navigateToCreateTask() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new CreateTaskFragment())
                .addToBackStack(null)
                .commit();
    }*/
}
