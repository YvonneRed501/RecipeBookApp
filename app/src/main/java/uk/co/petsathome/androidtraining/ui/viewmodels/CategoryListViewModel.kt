package uk.co.petsathome.androidtraining.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uk.co.petsathome.androidtraining.data.Category
import uk.co.petsathome.androidtraining.domain.RecipeRepository

class CategoryListViewModel(private val recipeRepository: RecipeRepository) : ViewModel() {

    private val _categoryList: MutableStateFlow<List<Category>> = MutableStateFlow(emptyList())
    val categoryList: StateFlow<List<Category>> = _categoryList


    fun getCategoryList() {
        viewModelScope.launch {
            try {
                _categoryList.value = recipeRepository.getCategoryList()
            } catch (e: Exception) {
                println(e)
            }

        }


    }

}