package com.example.mydefactocloneprojectt

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Products(var imageUrl:String? = "",var productName:String? = ""
                    ,var category:String? = "",var gender:String? = "",var price:Double? = 0.0) {
}