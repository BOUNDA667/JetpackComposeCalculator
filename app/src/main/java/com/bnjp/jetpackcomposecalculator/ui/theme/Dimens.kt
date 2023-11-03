package com.bnjp.jetpackcomposecalculator.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val extraSmall: Dp = 0.dp,
    val small1: Dp = 0.dp,
    val small2: Dp = 0.dp,
    val small3: Dp = 0.dp,
    val medium1: Dp = 0.dp,
    val medium2: Dp = 0.dp,
    val medium3: Dp = 0.dp,
    val large: Dp = 0.dp,
    val buttonHeight: Dp = 0.dp,
    val buttonWidth: Dp = 0.dp

)

val CompactSmallDimens = Dimens(
    extraSmall = 1.dp,
    small1 = 5.dp,
    small2 = 6.dp,
    small3 = 8.dp,
    medium1 = 15.dp,
    medium2 = 26.dp,
    medium3 = 30.dp,
    large = 45.dp,
    buttonHeight = 70.dp,
    buttonWidth = 80.dp
)

val CompactMediumDimens = Dimens(
    extraSmall = 2.dp,
    small1 = 6.dp,
    small2 = 12.dp,
    small3 = 18.dp,
    medium1 = 20.dp,
    medium2 = 28.dp,
    medium3 = 35.dp,
    large = 75.dp,
    buttonHeight = 80.dp,
    buttonWidth = 100.dp
)

val CompactDimens = Dimens(
    extraSmall = 3.dp,
    small1 = 7.dp,
    small2 = 16.dp,
    small3 = 20.dp,
    medium1 = 30.dp,
    medium2 = 36.dp,
    medium3 = 40.dp,
    large = 110.dp,
    buttonHeight = 80.dp,
    buttonWidth = 88.dp
)