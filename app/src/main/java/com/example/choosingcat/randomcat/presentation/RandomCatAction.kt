package com.example.choosingcat.randomcat.presentation

sealed interface RandomCatAction {
    data object OpenSavedCatsView : RandomCatAction
}