package com.example.myfirstproject.repo

import com.example.myfirstproject.model.UserModel

class UserRepoImpl : UserRepo {
    override fun login(
        email: String,
        password: String,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun register(
        email: String,
        password: String,
        callback: (Boolean, String, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun addUserToDatabase(
        userID: String,
        model: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun forgotPassword(
        email: String,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getUserByID(
        userID: String,
        callback: (Boolean, String, UserModel) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(callback: (Boolean, String, List<UserModel>) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun editProfile(
        userID: String,
        model: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun deleteAccount(
        userID: String,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

}
