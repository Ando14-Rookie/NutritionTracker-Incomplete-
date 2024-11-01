package com.example.nutritiontracker.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface DataInputUserDAO {

    // Will ignore if new data is the same
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    // can be started, paused, and resume
    suspend fun addData(dataInput : DataInputUser)

    @Delete
    suspend fun deleteData(dataInput: DataInputUser)

    // Select everything from DataInputUser
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    //Return every item in the database
    fun readData() : LiveData<List<DataInputUser>>
}