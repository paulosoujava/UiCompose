package com.paulo.uicomposes.welcome

import androidx.compose.ui.graphics.Color
import com.paulo.uicomposes.ui.theme.ColorBlue


data class OnBoardingData(
    val image: Int, val title: String,
    val desc: String,
    val backgroundColor:Color,
    val mainColor:Color = ColorBlue
)