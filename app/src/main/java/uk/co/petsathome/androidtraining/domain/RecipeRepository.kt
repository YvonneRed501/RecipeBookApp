package uk.co.petsathome.androidtraining.domain

import uk.co.petsathome.androidtraining.data.Category
import uk.co.petsathome.androidtraining.data.Meal

interface RecipeRepository {
    suspend fun getCategoryList(): List<Category>

    suspend fun getMealList(categoryName: String): List<Meal>
}