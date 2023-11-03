package com.bnjp.jetpackcomposecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.bnjp.jetpackcomposecalculator.ui.CalculatorScreen
import com.bnjp.jetpackcomposecalculator.ui.theme.JetpackComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSize = calculateWindowSizeClass(this)
            JetpackComposeCalculatorTheme(windowSize = windowSize.widthSizeClass) {
                    CalculatorScreen()
            }
        }
    }
}
