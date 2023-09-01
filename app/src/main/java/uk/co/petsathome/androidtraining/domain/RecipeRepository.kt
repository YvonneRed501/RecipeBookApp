package uk.co.petsathome.androidtraining.domain

import uk.co.petsathome.androidtraining.data.Category

interface RecipeRepository {
    suspend fun getCategoryList(): List<Category>
}