package com.example.mealz.meals

import androidx.lifecycle.ViewModel
import com.example.mealz.model.MealsRepository
import com.example.mealz.model.response.MealsResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {
    suspend fun getMeals() : List<MealsResponse> {
        return repository.getMeals().categories as List<MealsResponse>
    }
}