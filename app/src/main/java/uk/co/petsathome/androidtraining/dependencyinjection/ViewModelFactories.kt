package uk.co.petsathome.androidtraining.dependencyinjection

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import uk.co.petsathome.androidtraining.ui.viewmodels.CategoryListViewModel
import uk.co.petsathome.androidtraining.ui.viewmodels.MealListViewModel

object ViewModelFactories {

    val categoryListViewModelFactory: ViewModelProvider.Factory = viewModelFactory {
        initializer {
            CategoryListViewModel(AppModule.recipeRepository)
        }
    }

    val mealListViewModelFactory: ViewModelProvider.Factory = viewModelFactory {
        initializer {
            MealListViewModel(AppModule.recipeRepository)
        }
    }
}
