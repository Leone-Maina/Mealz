package com.example.mealz.meals

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.mealz.model.response.MealsResponse
import com.example.mealz.ui.theme.MealzTheme

@Composable
fun MealsCategoryScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.mealsState.value

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(meals) { meal ->
            MealsCategory(meal = meal)
        }
    }
}

@Composable
fun MealsCategory(meal: MealsResponse) {
    Card(shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
            Row {
                Image(painter = rememberAsyncImagePainter(meal.imageUrl),
                    contentDescription = "Meal Image",
                    modifier = Modifier.size(88.dp).padding(4.dp))

                Column(modifier = Modifier.align(Alignment.CenterVertically).padding(16.dp)) {
                    Text(text = meal.name,
                        style = MaterialTheme.typography.headlineSmall)
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzTheme {
        MealsCategoryScreen()
    }
}