package com.example.choosingcat.savedcats.presentation

import com.example.choosingcat.savedcats.domain.model.SavedCat

sealed interface SavedCatsState {
    data class ShowingSavedCats(val cats: List<SavedCat>) : SavedCatsState
    data object Loading : SavedCatsState
    data object Error : SavedCatsState
}