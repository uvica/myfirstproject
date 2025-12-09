package com.example.myfirstproject.repo

import com.google.firebase.database.FirebaseDatabase

class ProductRepoImpl {
    private val database = FirebaseDatabase.getInstance()
    private val productRef = database.getReference("products")




}