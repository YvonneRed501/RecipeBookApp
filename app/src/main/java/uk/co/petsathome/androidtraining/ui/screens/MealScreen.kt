package uk.co.petsathome.androidtraining.ui.screens

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import uk.co.petsathome.androidtraining.data.Meal
import uk.co.petsathome.androidtraining.ui.viewmodels.MealListViewModel

@Composable
fun MealScreen(mealListViewModel: MealListViewModel){
    LaunchedEffect(Unit) {
        mealListViewModel.getMealList()
    }
    val mealList = mealListViewModel.mealList.collectAsState()

    MealCard(mealList.value.first())
}

@Composable
fun MealCard(meal: Meal) {
    Card() {
        Text(text = meal.idMeal)
    }
}