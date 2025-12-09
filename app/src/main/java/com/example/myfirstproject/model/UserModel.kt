package com.example.myfirstproject.model

data class UserModel(
    val userID : String = "",
    val name : String = "",
    val email : String = "",
    val password : String = "",
){
    fun toMap(): Map<String, Any>{
        return mapOf(
            "userID" to userID,
            "name" to name,
            "email" to email,
            "password" to password
        )
    }
}
