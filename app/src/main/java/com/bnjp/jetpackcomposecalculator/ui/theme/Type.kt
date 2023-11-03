package com.bnjp.jetpackcomposecalculator.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bnjp.jetpackcomposecalculator.R

val Consola = FontFamily(
    listOf(
        Font(R.font.consola, weight = FontWeight.Normal),
        Font(R.font.consola_bold, weight = FontWeight.Bold),
        Font(R.font.consola_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
        Font(R.font.consola_bi, weight = FontWeight.Bold, style = FontStyle.Italic)
    )
)

val CompactSmallTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 58.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.Bold,
        fontSize = 42.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
    ),
)

val CompactMediumTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 68.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.Bold,
        fontSize = 42.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
    ),
)

val CompactTypography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 34.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = Consola,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
)