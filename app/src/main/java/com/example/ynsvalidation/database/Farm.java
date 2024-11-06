package com.example.ynsvalidation.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Farmer.class, parentColumns = "id", childColumns = "farmerId", onDelete = ForeignKey.CASCADE))
public class Farm {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "location")
    public String location;

    @ColumnInfo(name = "farmerId")
    public int farmerId;
}
