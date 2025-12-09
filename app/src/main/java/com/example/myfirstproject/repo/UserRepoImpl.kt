package com.example.myfirstproject.repo

import com.example.myfirstproject.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class UserRepoImpl : UserRepo {
    val auth : FirebaseAuth = FirebaseAuth.getInstance()

    val database = com.google.firebase.database.FirebaseDatabase.getInstance()

    val ref : DatabaseReference = database.getReference("Users")


    override fun login(
        email: String,
        password: String,
        callback: (Boolean, String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callback(true, "Logged in successfully")
                } else {
                    callback(false, "${it.exception?.message}")

                }
            }
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
       auth.sendPasswordResetEmail(email)
           .addOnCompleteListener {
               if (it.isSuccessful) {
                   callback(true, "Email sent successfully")
               }else{
                   callback(false, "${it.exception?.message}")
               }
           }
    }

    override fun getUserByID(
        userID: String,
        callback: (Boolean, String, UserModel?) -> Unit
    ) {
        ref.child(userID)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    TODO("Not yet implemented")
                }

                override fun onCancelled(error: DatabaseError) {
                    callback (false, "${error.message}", null)
                }
            })
    }

    override fun getAllUsers(callback: (Boolean, String, List<UserModel>) -> Unit) {

    }

    override fun editProfile(
        userID: String,
        model: UserModel,
        callback: (Boolean, String) -> Unit
    ) {
        ref.child(userID).updateChildren(model.toMap()).addOnCompleteListener {
            if (it.isSuccessful) {
                ref.child(userID).setValue(model).addOnCompleteListener {
                    if (it.isSuccessful) {
                        callback(true, "Profile updated successfully")
                    } else {
                        callback(false, "${it.exception?.message}")
                    }
                }
            }
        }
    }

    override fun deleteAccount(
        userID: String,
        callback: (Boolean, String) -> Unit
    ) {
        TODO("Not yet implemented")
    }

}
