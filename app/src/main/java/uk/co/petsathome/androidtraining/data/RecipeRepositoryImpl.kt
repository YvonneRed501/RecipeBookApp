package uk.co.petsathome.androidtraining.data

import uk.co.petsathome.androidtraining.domain.RecipeRepository

class RecipeRepositoryImpl(private val recipeApiService: RecipeApiService) : RecipeRepository {
    override suspend fun getCategoryList(): List<Category> {
        return recipeApiService.getCategoryList().categories
    }

    override suspend fun getMealList(categoryName: String): List<Meal> {
        return recipeApiService.getMealList(categoryName).meals
    }

}