package com.kizzy.funfacts.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kizzy.funfacts.R
import com.kizzy.funfacts.ui.AnimalCard
import com.kizzy.funfacts.ui.AppTopBar
import com.kizzy.funfacts.ui.InputViewModel
import com.kizzy.funfacts.ui.TextComponent
import com.kizzy.funfacts.ui.TextInputComponent
import com.kizzy.funfacts.ui.UserInputEvent

@Composable
fun InputScreen(navController: NavHostController, userInputViewModel: InputViewModel) {

    val padding = 8.dp
    val gradientColors = listOf(Cyan, Red, Blue /*...*/)
    Surface (modifier = Modifier
        .fillMaxSize()) {
        Column (modifier = Modifier.padding(padding)){
            AppTopBar("Hi There")
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(txt = "Let's learn about you!", textSize = 22.sp)
            Spacer(modifier = Modifier.size(20.dp))
            TextComponent(txt = "This app will prepare a details page based on input provided by you!", textSize = 19.sp)
            Spacer(modifier = Modifier.size(60.dp))
            TextInputComponent(onTextChange = {
                userInputViewModel.onEvent(UserInputEvent.UserInputName(it))
            })
            Spacer(modifier = Modifier.size(60.dp))
            TextComponent(txt = "What do you like", textSize = 20.sp)
            Row {
                AnimalCard(image = R.drawable.cat_iv, selected = userInputViewModel.uiState.value.userInputAnimal == "Cat", animalSelected = {
                    userInputViewModel.onEvent(UserInputEvent.UserInputAnimal(it))
                } )
                AnimalCard(image = R.drawable.dog_iv, selected = userInputViewModel.uiState.value.userInputAnimal == "Dog", animalSelected = {
                    userInputViewModel.onEvent(UserInputEvent.UserInputAnimal(it))
                } )
            }

            Spacer(modifier = Modifier.weight(1f))
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Button(onClick = { navController.navigate(Routes.WELCOME_SCREEN) },) {
                    TextComponent(txt = "Confirm", textSize = 18.sp, textColor = Color.White)
                }
            }



        }



    }
}


@Preview
@Composable
fun InputScreenPreview() {
    InputScreen(rememberNavController(), InputViewModel())
}