package com.kizzy.funfacts.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kizzy.funfacts.ui.AppTopBar
import com.kizzy.funfacts.ui.InputViewModel
import com.kizzy.funfacts.ui.TextComponent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(userInputViewModel: InputViewModel) {
    Surface (modifier = Modifier.fillMaxSize()) {

        Column (modifier = Modifier.padding(16.dp)){
            AppTopBar("Welcome ${userInputViewModel.uiState.value.userInputName}")
            TextComponent(txt = "Thank you for sharing your data!", textSize = 21.sp)
            Spacer(modifier = Modifier.size(30.dp))

            TextComponent(txt = "You are a ${userInputViewModel.uiState.value.userInputAnimal} lover!", textSize = 21.sp)

        }
    }
}


@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(InputViewModel())
}