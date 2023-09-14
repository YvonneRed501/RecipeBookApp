package uk.co.petsathome.androidtraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import uk.co.petsathome.androidtraining.dependencyinjection.ViewModelFactories
import uk.co.petsathome.androidtraining.ui.Navigation
import uk.co.petsathome.androidtraining.ui.theme.AndroidtrainingTheme
import uk.co.petsathome.androidtraining.ui.viewmodels.CategoryListViewModel
import uk.co.petsathome.androidtraining.ui.viewmodels.MealListViewModel

class MainActivity : ComponentActivity() {
    private val categoryListViewModel: CategoryListViewModel by viewModels { ViewModelFactories.categoryListViewModelFactory }
    private val mealListViewModel: MealListViewModel by viewModels { ViewModelFactories.mealListViewModelFactory}
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            AndroidtrainingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(categoryListViewModel = categoryListViewModel, mealListViewModel = mealListViewModel)
                }
            }
        }
    }
}

