package com.example.nutritiontracker.Data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel (application: Application) : AndroidViewModel(application) {

    private val readAll : LiveData<List<DataInputUser>>
    private val repository : UserRepository

    // First to be initialized when app starts
    init {
        val userDAO = DataInputUserDatabase.getDatabase(application).dao
        repository = UserRepository(userDAO)
        readAll = repository.readData
    }

    fun addUser(user: DataInputUser) {
        //Running in background
        viewModelScope.launch { Dispatchers.IO
        repository.addUser(user)
        }
    }
}