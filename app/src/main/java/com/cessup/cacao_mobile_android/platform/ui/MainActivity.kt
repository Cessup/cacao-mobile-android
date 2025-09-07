package com.cessup.cacao_mobile_android.platform.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cessup.cacao_mobile_android.platform.navigation.AppNavHost
import com.cessup.cacao_mobile_android.platform.ui.theme.CacaoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CacaoTheme {
                AppNavHost()
            }
        }
    }
}
