package com.example.myfirstproject.model

import androidx.lifecycle.MutableLiveData
import com.example.myfirstproject.repo.UserRepo

class UserViewModel(val repo: UserRepo) {

    fun login(email: String, password: String, callback: (Boolean, String) -> Unit) {
        repo.login(email, password, callback)
    }

    fun register(email: String, password: String, callback: (Boolean, String, String) -> Unit) {
        repo.register(email, password, callback)
    }

    fun addUserToDatabase(
        userID: String,
        model: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        repo.addUserToDatabase(userID, model, callback)
    }

    fun forgotPassword(email: String, callback: (Boolean, String) -> Unit) {
        repo.forgotPassword(email, callback)
    }

    // LiveData
    private val _users = MutableLiveData<UserModel?>()
    val users: MutableLiveData<UserModel?> get() = _users

    private val _allUsers = MutableLiveData<List<UserModel?>>()
    val allUsers: MutableLiveData<List<UserModel?>> get() = _allUsers

    private val _loading = MutableLiveData<Boolean>()
    val loading: MutableLiveData<Boolean> get() = _loading


    // Get User By ID
    fun getUserByID(userId: String) {
        _loading.postValue(true)
        repo.getUserByID(userId) { isSuccess, message, data ->
            if (isSuccess) {
                _users.postValue(data)
            }
            _loading.postValue(false)
        }
    }

    // Get All Users
    fun getAllUsers() {
        _loading.postValue(true)
        repo.getAllUsers { success, msg, data ->
            if (success) {
                _allUsers.postValue(data)
            }
            _loading.postValue(false)
        }
    }

    // Edit Profile
    fun editProfile(userID: String, model: UserModel, callback: (Boolean, String) -> Unit) {
        repo.editProfile(userID, model, callback)
    }

    // Delete Account
    fun deleteAccount(userID: String, callback: (Boolean, String) -> Unit) {
        repo.deleteAccount(userID, callback)
    }
}
