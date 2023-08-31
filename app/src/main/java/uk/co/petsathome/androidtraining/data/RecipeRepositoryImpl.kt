package uk.co.petsathome.androidtraining.data

import retrofit2.Response
import uk.co.petsathome.androidtraining.domain.RecipeRepository

class RecipeRepositoryImpl(private val recipeApiService: RecipeApiService) : RecipeRepository {
    override suspend fun getCategoryList(): List<Category> {
        return handleResponse { recipeApiService.getCategoryList() }
    }

    private suspend fun <T> handleResponse(request: suspend () -> Response<T>): T {
        val tmpResponse: Response<T>
        try {
            tmpResponse = request()
        } catch (t: Throwable) {
            throw Exception("API CALL FAILED: $t")
        }

        return tmpResponse.body() ?: throw Exception("Empty response")
    }
}