package com.oys.myapplication.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val scope = rememberCoroutineScope()
    val uiState = viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .statusBarsPadding()
            .systemBarsPadding()
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column() {
            Text("현재 연결된 네트워크 : ${uiState.value.networkInfo.connection.name}")
            Text("외부 IP : ${uiState.value.networkInfo.externalIp}")
        }
    }
}
