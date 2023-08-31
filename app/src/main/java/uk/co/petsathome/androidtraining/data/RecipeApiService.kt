package uk.co.petsathome.androidtraining.data

import retrofit2.Response
import retrofit2.http.GET

interface RecipeApiService {
    @GET("/api/json/v1/1/categories.php")
    fun getCategoryList(): Response<List<Category>>
}