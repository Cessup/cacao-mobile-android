package com.cessup.cacao_mobile_android.platform.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.cessup.cacao_mobile_android.App
import com.cessup.cacao_mobile_android.platform.di.ViewModelFactory
import com.cessup.cacao_mobile_android.platform.ui.theme.CacaoTheme
import jakarta.inject.Inject

class HomeActivity : ComponentActivity() {

    @Inject lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as App).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            CacaoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    HomeScreen(Modifier.padding(it))
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            Toast.makeText(context, "Menu Drinks", Toast.LENGTH_SHORT).show()
        }) {
            Text("Drinks")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            Toast.makeText(context, "Menu meal", Toast.LENGTH_SHORT).show()
        }) {
            Text("Meals")
        }
    }
}