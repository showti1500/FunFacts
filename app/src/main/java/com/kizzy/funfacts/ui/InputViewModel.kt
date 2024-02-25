package com.kizzy.funfacts.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class InputViewModel : ViewModel() {

    var uiState = mutableStateOf(UserInputDataState())

    fun onEvent(event : UserInputEvent) {
        when(event) {
            is UserInputEvent.UserInputName -> {
                uiState.value = uiState.value.copy(userInputName = event.name)
            }

            is UserInputEvent.UserInputAnimal -> {
                uiState.value = uiState.value.copy(userInputAnimal = event.animal)
            }
        }
    }

}