package com.aditya.d4ctask.model

import androidx.annotation.DrawableRes
import com.aditya.d4ctask.R

data class Offers(
    val id: String,
    @DrawableRes val imageUrl: Int,
    val discountPercent: Int,
    val offerDate: String
)

fun getOffers(): List<Offers> {
    return listOf(
        Offers("1", R.drawable.categorysample3, 30, "12-16 October"),
        Offers("2", R.drawable.categorysample2, 50, "Valid till June 5"),
        Offers("3", R.drawable.cart, 15, "Valid till June 10")
    )
}




