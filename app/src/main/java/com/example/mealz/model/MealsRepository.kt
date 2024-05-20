package com.example.mealz.model

import com.example.mealz.model.api.MealsWebService
import com.example.mealz.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}