package com.example.nutritiontracker.Data

import androidx.lifecycle.LiveData

class UserRepository (private val userDAO : DataInputUserDAO) {
    // Read every item in the database from User
    val readData : LiveData<List<DataInputUser>> = userDAO.readData()

     suspend fun addUser (user : DataInputUser){
        userDAO.addData(user)
    }

}