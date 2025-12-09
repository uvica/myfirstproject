package com.example.myfirstproject.repo

import com.example.myfirstproject.model.ProductModel

interface ProductRepo {

    fun addProduct(product : ProductModel, callback : (boolean : Boolean, String) -> Unit)

    fun getAllProducts (product : ProductModel, callback : (boolean : Boolean, String, List<ProductModel>) -> Unit)

    fun deleteProduct (product : ProductModel, callback : (boolean : Boolean ,String,) -> Unit)

    fun editProduct (product : ProductModel, callback : (boolean : Boolean ,String,) -> Unit)

    fun getProductByID (product : ProductModel, callback : (boolean : Boolean ,String, ProductModel?) -> Unit)

    

}