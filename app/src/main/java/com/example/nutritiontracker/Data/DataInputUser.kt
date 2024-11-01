package com.example.nutritiontracker.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Specify the tableName
@Entity(tableName = "user_table")
data class DataInputUser(
    var nameFood: String,
    var typeFood: String,
    var amountFood: String,
    @PrimaryKey(autoGenerate = true)
    var id : Int
)