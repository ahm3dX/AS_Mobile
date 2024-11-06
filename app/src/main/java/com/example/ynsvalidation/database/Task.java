package com.example.ynsvalidation.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Farm.class, parentColumns = "id", childColumns = "farmId", onDelete = ForeignKey.CASCADE))
public class Task {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "dueDate")
    public String dueDate;

    @ColumnInfo(name = "farmId")
    public int farmId;
}

