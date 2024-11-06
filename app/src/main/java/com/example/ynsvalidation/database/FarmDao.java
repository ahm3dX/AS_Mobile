package com.example.ynsvalidation.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FarmDao {
    @Insert
    void insertFarm(Farm farm);

    @Query("SELECT * FROM farm WHERE farmerId = :farmerId")
    List<Farm> getFarmsForFarmer(int farmerId);
}
