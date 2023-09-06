package uk.co.petsathome.androidtraining.data

data class MealList(
    val meals: List<Meal>
)

data class Meal(
    val strMeal: String,
    val strMealThumb: String,
    val idMeal: String
)