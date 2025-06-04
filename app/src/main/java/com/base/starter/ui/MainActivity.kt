package com.base.starter.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.base.starter.ui.navigation.AppNavigation
import com.base.starter.ui.theme.StarterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp()
        }
    }
}

// for clear separation and to keep the
@Composable
fun MainApp() {
    StarterTheme {
        AppNavigation()
    }
}