package uk.co.petsathome.androidtraining.data

//www.themealdb.com/api/json/v1/1/categories.php
data class CategoryList(
    val categories: List<Category>
)

data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
)