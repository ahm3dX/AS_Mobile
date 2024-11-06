package com.example.ynsvalidation.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TaskDao {
    @Insert
    void insertTask(Task task);

    @Query("SELECT * FROM task WHERE farmId = :farmId")
    List<Task> getTasksForFarm(int farmId);
}
