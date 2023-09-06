package uk.co.petsathome.androidtraining.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.flow.first
import uk.co.petsathome.androidtraining.data.Category
import uk.co.petsathome.androidtraining.ui.viewmodels.CategoryListViewModel
import uk.co.petsathome.androidtraining.util.limitChar

@Composable
fun categoryScreen(
    categoryListViewModel: CategoryListViewModel
) {
    LaunchedEffect(Unit) {
        categoryListViewModel.getCategoryList()
    }
    val categoryList = categoryListViewModel.categoryList.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(
                categoryList.value,

                ) {
                categoryCard(category = it)
            }

        })

}

@Composable
fun categoryCard(
    category: Category

) {
    Card(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Row(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(model = category.strCategoryThumb, contentDescription = null)
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(text = category.strCategory)
                Text(
                    text = category.strCategoryDescription.limitChar(250),

                )
            }

        }
    }
}

@Preview
@Composable
fun categoryCardPreview() {
    val category = Category(
        idCategory = "1",
        strCategory = "2",
        strCategoryThumb = "https:\\/\\/www.themealdb.com\\/images\\/category\\/beef.png",
        strCategoryDescription = "Babi jiefjihefgir efjbjr4bug45iu uiegeuir44g " +
                "ieinighriog5 p4hgo5g "
    )
    categoryCard(category = category)
}