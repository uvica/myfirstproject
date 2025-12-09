package com.example.myfirstproject.model

data class ProductModel(
    val productID: String = "",
    val productName : String = "",
    val productPrice : String = "",
    val productDescription : String = "",
    val productImage : String = "",
){
    fun toMap(): Map<String, Any> {
        return mapOf(
            "productID" to productID,
            "productName" to productName,
            "productPrice" to productPrice,
            "productDescription" to productDescription,
            "productImage" to productImage,
        )
    }
}
