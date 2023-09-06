package uk.co.petsathome.androidtraining.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uk.co.petsathome.androidtraining.data.Meal
import uk.co.petsathome.androidtraining.dependencyinjection.AppModule.recipeRepository
import uk.co.petsathome.androidtraining.domain.RecipeRepository

class MealListViewModel(recipeRepository: RecipeRepository): ViewModel() {
    private var _mealList: MutableStateFlow<List<Meal>> = MutableStateFlow(emptyList())
    val mealList: StateFlow<List<Meal>> = _mealList

    fun getMealList(){
        viewModelScope.launch {
            recipeRepository.getMealList("lamb")
        }
    }

}