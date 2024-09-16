package com.example.choosingcat.randomcat.presentation

import com.example.choosingcat.randomcat.domain.model.Cat

sealed interface RandomCatState {
    data class ShowingRandomCat(val cat: Cat) : RandomCatState
    data object Loading : RandomCatState
    data object Error : RandomCatState
}