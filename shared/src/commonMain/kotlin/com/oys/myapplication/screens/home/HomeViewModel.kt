package com.oys.myapplication.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel() : ViewModel() {
    private val _testState: MutableStateFlow<Int> = MutableStateFlow(0)
    val testState: StateFlow<Int> = _testState.asStateFlow()


    fun add() {
        _testState.update { it + 1 }
    }
}