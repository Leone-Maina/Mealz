package com.example.mealz.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(val categories: List<Any>)

//@serializedName("idCategory") -> the name of the field from the JSON file we are calling
//private val id: String, -> the name of the field in the class to be mapped to the JSON file names

data class MealsResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryDescription") val description: String,
    @SerializedName("strCategoryThumb") val imageUrl: String
)