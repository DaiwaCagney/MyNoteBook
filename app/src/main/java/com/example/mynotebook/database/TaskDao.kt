package com.example.mynotebook.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * from task ORDER BY id ASC")
    fun getItems(): Flow<List<Task>>

    @Query("SELECT * from task WHERE id = :id")
    fun getItem(id: Int): Flow<Task>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)

    @Delete
    suspend fun delete(task: Task)
}