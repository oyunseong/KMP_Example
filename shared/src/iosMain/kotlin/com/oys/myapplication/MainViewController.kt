package com.oys.myapplication

import androidx.compose.ui.window.ComposeUIViewController
import com.oys.myapplication.di.initKoin
import com.oys.myapplication.screens.Screen

fun MainViewController() = ComposeUIViewController {
    Screen()
}
