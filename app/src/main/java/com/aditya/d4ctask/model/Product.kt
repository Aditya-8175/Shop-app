package com.aditya.d4ctask.model

import androidx.annotation.DrawableRes
import com.aditya.d4ctask.R

data class Product(

    val id: String,
    @DrawableRes val imageUrl: Int,
    val name: String,
    val stockAvailable: Boolean,
    val detail: String,
    val benefit: String,
    val originalPrice: String,
    val discountPrice: String,
    val ratingCount: Float,
    val reviewCount: Int

)

fun getProduct(): List<Product> {
    return listOf<Product>(

        Product(
            name = "cleancera",
            id = "1",
            imageUrl = R.drawable.categorysample2,
            stockAvailable = true,
            detail = "French clay and algae-powered cleanser",
            benefit = "Skin Tightness * Dry & Dehydrated Skin",
            originalPrice = " 355.20",
            discountPrice = " 444.00",
            ratingCount = 5.0F,
            reviewCount = 249
        ),
        Product(
            name = "glow",
            id = "2",
            imageUrl = R.drawable.categorysample1,
            stockAvailable = true,
            detail = "French clay and algae-powered cleanser",
            benefit = "Skin Tightness * Dry & Dehydrated Skin",
            originalPrice = " 355.20",
            discountPrice = " 444.00",
            ratingCount = 4.0F,
            reviewCount = 249
        ),
        Product(
            name = "afterglow",
            id = "3",
            imageUrl = R.drawable.categorysample1,
            stockAvailable = false,
            detail = "French clay and algae-powered cleanser",
            benefit = "Skin Tightness * Dry & Dehydrated Skin",
            originalPrice = " 355.20",
            discountPrice = " 444.00",
            ratingCount = 3.0F,
            reviewCount = 249
        ),
        Product(
            name = "afterglow",
            id = "4",
            imageUrl = R.drawable.categorysample2,
            stockAvailable = false,
            detail = "French clay and algae-powered cleanser",
            benefit = "Skin Tightness * Dry & Dehydrated Skin",
            originalPrice = " 355.20",
            discountPrice = " 444.00",
            ratingCount = 2F,
            reviewCount = 249
        )
    )
}
