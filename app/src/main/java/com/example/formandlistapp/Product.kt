package com.example.formandlistapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val name: String,
    val description: String,
    val price: Double,
    val imageFileName: String
) : Parcelable