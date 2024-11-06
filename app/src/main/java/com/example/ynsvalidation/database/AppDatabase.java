package com.example.ynsvalidation.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Farmer.class, Farm.class, Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FarmerDao farmerDao();
    public abstract FarmDao farmDao();
    public abstract TaskDao taskDao();
    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "my_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }}
