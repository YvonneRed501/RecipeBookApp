package uk.co.petsathome.androidtraining.dependencyinjection

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import uk.co.petsathome.androidtraining.ui.viewmodels.CategoryListViewModel

object ViewModelFactories {

    val categoryListViewModelFactory: ViewModelProvider.Factory = viewModelFactory {
        initializer {
            CategoryListViewModel(AppModule.recipeRepository)
        }
    }
}
