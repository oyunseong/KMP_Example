package com.oys.myapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.oys.myapplication.screens.home.HomeScreen

@Composable
fun Screen() {
    Box(
        modifier = Modifier
            .fillMaxSize()                // 전체 화면 사용
            .statusBarsPadding()          // 상태바 패딩 적용
            .systemBarsPadding()         // iOS에서 추가적으로 시스템 바 패딩 적용
            .background(color = Color.Red),
        contentAlignment = Alignment.Center // 중앙 정렬
    ) {
        HomeScreen()
    }
}