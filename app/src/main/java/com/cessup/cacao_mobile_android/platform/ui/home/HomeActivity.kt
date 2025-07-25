package com.cessup.cacao_mobile_android.platform.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.cessup.cacao_mobile_android.App
import com.cessup.cacao_mobile_android.domain.model.User
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserScreen(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun UserScreen(viewModel: HomeViewModel, modifier: Modifier = Modifier) {
    val users by viewModel.users.collectAsState()

    LazyColumn (modifier = modifier){
        items(users) {user->
            ListItem(user)
        }
    }
}

@Composable
fun ListItem(user: User) {
    Row(Modifier.fillMaxWidth()) {
        Text(text = user.username)
    }
}
