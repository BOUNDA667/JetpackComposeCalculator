package com.bnjp.jetpackcomposecalculator.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.bnjp.jetpackcomposecalculator.MainActivity

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryDark,
    secondary = SecondaryDark,
    tertiary = TertiaryDark,
    primaryContainer = PrimaryContainerDark,
    secondaryContainer = SecondaryContainerDark,
    onPrimary = OnPrimaryDark,
    onPrimaryContainer = OnPrimaryContainerDark,
    onSecondaryContainer = OnSecondaryContainerDark,
    onTertiary = OnTertiaryDark
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryLight,
    secondary = SecondaryLight,
    tertiary = TertiaryLight,
    primaryContainer = PrimaryContainerLight,
    secondaryContainer = SecondaryContainerLight,
    onPrimary = OnPrimaryLight,
    onPrimaryContainer = OnPrimaryContainerLight,
    onSecondaryContainer = OnSecondaryContainerLight,
    onTertiary = OnTertiaryLight
)

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun JetpackComposeCalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
   // dynamicColor: Boolean = true,
    windowSize: WindowWidthSizeClass,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    val config = LocalConfiguration.current

    var typography = CompactTypography
    var appDimens = CompactDimens

    when(windowSize) {
        WindowWidthSizeClass.Compact -> {
            if(config.screenWidthDp <= 360) {
                typography = CompactSmallTypography
                appDimens = CompactSmallDimens
            }
            else if(config.screenWidthDp in 361..598) {
                typography = CompactMediumTypography
                appDimens = CompactMediumDimens
            } else {
                typography = CompactTypography
                appDimens = CompactDimens
            }
        }
    }

    AppUtils(appDimens = appDimens) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            content = content
        )
    }
}

val MaterialTheme.dimens
    @Composable
    get() = LocalAppDimens.current