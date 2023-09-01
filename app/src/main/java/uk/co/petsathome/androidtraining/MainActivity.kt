package uk.co.petsathome.androidtraining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.petsathome.androidtraining.dependencyinjection.ViewModelFactories
import uk.co.petsathome.androidtraining.ui.screens.categoryScreen
import uk.co.petsathome.androidtraining.ui.theme.AndroidtrainingTheme
import uk.co.petsathome.androidtraining.ui.viewmodels.CategoryListViewModel

class MainActivity : ComponentActivity() {
    private val categoryListViewModel: CategoryListViewModel by viewModels { ViewModelFactories.categoryListViewModelFactory }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            AndroidtrainingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    categoryScreen(categoryListViewModel)
                }
            }
        }
    }
}

