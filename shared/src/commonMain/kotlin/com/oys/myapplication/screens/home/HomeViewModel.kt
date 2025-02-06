package com.oys.myapplication.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oys.myapplication.Logger
import com.oys.myapplication.data.UserRepository
import dev.tmapps.konnection.ConnectionInfo
import dev.tmapps.konnection.Konnection
import dev.tmapps.konnection.NetworkConnection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class HomeUiState(
    val networkInfo: ConnectionInfo
)

class HomeViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    private val konnection = Konnection.instance
    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(
        HomeUiState(
            networkInfo = ConnectionInfo(
                connection = NetworkConnection.UNKNOWN_CONNECTION_TYPE,
                ipv4 = "",
                ipv6 = "",
                externalIp = "",
            )
        )
    )
    val uiState = _uiState.asStateFlow()

    val currentConnectedNetwork = konnection.observeNetworkConnection()
//        .stateIn(
//            initialValue = NetworkConnection.UNKNOWN_CONNECTION_TYPE,
//            started = SharingStarted.WhileSubscribed(5000),
//            scope = viewModelScope,
//        )

    init {
        viewModelScope.launch {
            currentConnectedNetwork.collectLatest {
                Logger.d("++##", "currentConnectedNetwork : $it")
                if (it != NetworkConnection.WIFI) {
                    updateUiState {
                        copy(
                            networkInfo = ConnectionInfo(
                                connection = it ?: NetworkConnection.UNKNOWN_CONNECTION_TYPE,
                                ipv4 = "",
                                ipv6 = "",
                                externalIp = ""
                            )
                        )
                    }
                } else {
                    val info = konnection.getInfo()
                    Logger.d("++##", "info : $info")
                    updateUiState {
                        copy(
                            networkInfo = info ?: return@updateUiState this
                        )
                    }
                }

            }
        }
    }

    fun updateUiState(action: HomeUiState.() -> HomeUiState) {
        _uiState.update {
            action(it)
        }
    }
}