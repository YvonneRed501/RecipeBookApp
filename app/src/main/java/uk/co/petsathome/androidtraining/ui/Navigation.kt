package uk.co.petsathome.androidtraining.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import uk.co.petsathome.androidtraining.ui.screens.CategoryScreen
import uk.co.petsathome.androidtraining.ui.screens.MealCard
import uk.co.petsathome.androidtraining.ui.screens.MealScreen
import uk.co.petsathome.androidtraining.ui.viewmodels.CategoryListViewModel
import uk.co.petsathome.androidtraining.ui.viewmodels.MealListViewModel

sealed class NavRoutes(val route: String) {
    object HomeScreen : NavRoutes("home_screen")
    object CategoryList : NavRoutes("category_list")
    object MealList : NavRoutes("meal_list")

}

@Composable
fun Navigation(
    categoryListViewModel: CategoryListViewModel
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavRoutes.CategoryList.route)
    {
        composable(NavRoutes.CategoryList.route) {
            CategoryScreen(categoryListViewModel = categoryListViewModel, onClick = {
                navController.navigate(NavRoutes.MealList.route + "/$it")
            } )
        }
        composable(NavRoutes.MealList.route + "/{category_name}", arguments = listOf(
            navArgument( "category_name"){
                type = NavType.StringType
            },

        )){
            val categoryName = it.arguments?.getString("category_name")
            println(categoryName)
            MealScreen(mealListViewModel = MealListViewModel())
        }

    }

}