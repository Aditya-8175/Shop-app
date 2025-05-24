package com.aditya.d4ctask.model

import androidx.annotation.DrawableRes
import com.aditya.d4ctask.R

data class Category(
    val id: String,
    @DrawableRes val imageUrl: Int,
    val name: String
)

fun getCategory(): List<Category> {
        return listOf(
            Category(
                id = "1",
                name = "Cleaners",
                imageUrl = R.drawable.categorysample1,
            ),
            Category(
                id = "2",
                name = "Toner",
                imageUrl = R.drawable.categorysample2,
            ),
            Category(
                id = "3",
                name = "Serums",
                imageUrl = R.drawable.categorysample3,
                ),
            Category(
                id = "4",
                name = "Moisturisers",
                imageUrl = R.drawable.categorysample2,

                ),
            Category(
                id = "5",
                name = "SunScreen",
                imageUrl = R.drawable.categorysample2,

                ),

            Category(
                id = "1",
                name = "Cleaners",
                imageUrl = R.drawable.categorysample1,
            ),
            Category(
                id = "2",
                name = "Toner",
                imageUrl = R.drawable.categorysample2,
            ),
            Category(
                id = "3",
                name = "Serums",
                imageUrl = R.drawable.categorysample3,
                ),
            Category(
                id = "4",
                name = "Moisturisers",
                imageUrl = R.drawable.categorysample2,

                ),
            Category(
                id = "5",
                name = "SunScreen",
                imageUrl = R.drawable.categorysample2,

                )
        )
    }


