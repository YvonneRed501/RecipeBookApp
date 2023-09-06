package uk.co.petsathome.androidtraining.data

import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiService {
    @GET("/api/json/v1/1/categories.php")
    suspend fun getCategoryList(): CategoryList

    @GET("/api/json/v1/1/filter.php")
    suspend fun getMealList(
        @Query("c") categoryName: String
    ): MealList
}