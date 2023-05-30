package com.example.choosingcat.randomcat.presentation

import com.example.choosingcat.randomcat.domain.model.Cat

sealed interface RandomCatState {
    data class ShowingRandomCat(val cat: Cat) : RandomCatState
    object Loading : RandomCatState
    object Error : RandomCatState
}