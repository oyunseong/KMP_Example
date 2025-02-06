package com.oys.myapplication.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oys.myapplication.Logger
import com.oys.myapplication.data.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _testState: MutableStateFlow<Int> = MutableStateFlow(0)
    val testState: StateFlow<Int> = _testState.asStateFlow()

    init {
        viewModelScope.launch {
            userRepository.getData().map {
                Logger.d("++##", "${it}")
            }
        }
    }

    fun add() {
        _testState.update { it + 1 }
    }
}