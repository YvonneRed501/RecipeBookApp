package uk.co.petsathome.androidtraining.dependencyinjection

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uk.co.petsathome.androidtraining.data.RecipeApiService
import uk.co.petsathome.androidtraining.data.RecipeRepositoryImpl
import uk.co.petsathome.androidtraining.domain.RecipeRepository

object AppModule {
    private const val BASE_URL =
        "https://www.themealdb.com"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    private val recipeApiService: RecipeApiService = retrofit.create(RecipeApiService::class.java)

    val recipeRepository: RecipeRepository = RecipeRepositoryImpl(recipeApiService)
}