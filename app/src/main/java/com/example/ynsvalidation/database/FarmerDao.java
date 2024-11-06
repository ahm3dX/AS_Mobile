package com.example.ynsvalidation.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FarmerDao {
    @Insert
    void insertFarmer(Farmer farmer);

    @Query("SELECT * FROM farmer")
    List<Farmer> getAllFarmers();
}
