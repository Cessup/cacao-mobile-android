package com.cessup.cacao_mobile_android.platform.ui.home


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * That is the Home for everything
 *
 * This class contain the start flow
 *
 * @author
 *     Cessup
 * @since 1.0
 */
@Composable
fun HomeScreen(token: String,
               onHomeToDrinkMenu: () -> Unit) {
    val viewModel: HomeViewModel = hiltViewModel()

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Home",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onHomeToDrinkMenu) {
            Text("Drink Menu")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Action 2
            Toast.makeText(context, "Meal Menu", Toast.LENGTH_SHORT).show()
        }) {
            Text("Meal Menu")
        }
    }
}
