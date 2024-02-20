package com.zert.fitness.ui.screens.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zert.fitness.ui.screens.splash.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() :
    ViewModel() {
    data class SplashUIData(val isLoading: Boolean = false, val isError: Boolean = false)

    sealed class UIEvent() {
        object Success : UIEvent()
        data class Error(val message: String) : UIEvent()
    }

    private val _uiEvent = MutableSharedFlow<UIEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    private val _uiData = mutableStateOf(SplashUIData())
    val uiData = _uiData

    init {
        fetchSkills()
    }


    fun fetchSkills() {
        viewModelScope.launch {
            _uiData.value = uiData.value.copy(isError = false, isLoading = true)
            delay(1000)
            _uiData.value = uiData.value.copy(isError = false, isLoading = false)
            //pending when need to add user login
//            if (_uiData.value.isError) {
//                _uiEvent.emit(UIEvent.Error("Enable to fetch Data."))
//            } else {
//                _uiEvent.emit(UIEvent.Success)
//
//            }
            _uiEvent.emit(UIEvent.Success)

        }
    }


}