package com.kizzy.funfacts.ui

sealed class UserInputEvent {

    data class UserInputName(val name:String) : UserInputEvent()

    data class UserInputAnimal(val animal:String) : UserInputEvent()

}