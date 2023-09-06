package uk.co.petsathome.androidtraining.data

import retrofit2.Response
import uk.co.petsathome.androidtraining.domain.RecipeRepository

class RecipeRepositoryImpl(private val recipeApiService: RecipeApiService) : RecipeRepository {
    override suspend fun getCategoryList(): List<Category> {
        return recipeApiService.getCategoryList().categories
    }

}