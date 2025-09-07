package com.cessup.cacao_mobile_android.platform.ui.eatable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.cessup.cacao_mobile_android.R
import com.cessup.domain.models.eatable.drink.Beer

/**
 * There are the Screen about Drinks
 *
 * This class contain views about drinks
 *
 * @author
 *     Cessup
 * @since 1.0
 */
@Composable
fun DrinksScreen() {
    val viewModel: DrinkViewModel = hiltViewModel()

    val beers by viewModel.beers.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Menu Drinks",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = Beer::class.simpleName?:"",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        LazyRow (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ){
            items(beers) {beer->
                ListItem(beer)
            }
        }
    }
}

@Composable
fun ListItem(beer: Beer) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(100.dp),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Column (Modifier.padding(8.dp),) {
            Text(text = beer.drink.name)
            AsyncImage(
                model = beer.imgURL,
                contentDescription = beer.drink.name,
                placeholder = painterResource(R.drawable.ic_image_24),
                error = painterResource(R.drawable.ic_hide_image_24),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}