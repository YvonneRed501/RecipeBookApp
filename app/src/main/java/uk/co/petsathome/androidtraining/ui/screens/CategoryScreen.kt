package uk.co.petsathome.androidtraining.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import coil.compose.AsyncImage
import kotlinx.coroutines.flow.first
import uk.co.petsathome.androidtraining.data.Category
import uk.co.petsathome.androidtraining.ui.viewmodels.CategoryListViewModel

@Composable
fun categoryScreen(
    categoryListViewModel: CategoryListViewModel
) {
    LaunchedEffect(Unit) {
        categoryListViewModel.getCategoryList()
    }
    val categoryList = categoryListViewModel.categoryList.collectAsState()
    categoryCard(categoryList.value.firstOrNull())
}

@Composable
fun categoryCard(category: Category?) {
    Card() {
        Column() {
//           category?.idCategory
//           category?.strCategory
            AsyncImage(model = category?.strCategoryThumb, contentDescription = null)
        }
    }
}