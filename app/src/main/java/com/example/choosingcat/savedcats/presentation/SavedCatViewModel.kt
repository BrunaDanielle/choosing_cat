package com.example.choosingcat.savedcats.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.choosingcat.savedcats.domain.GetSavedCatsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SavedCatViewModel(
    private val useCase: GetSavedCatsUseCase
) : ViewModel() {
    private val stateMutableLiveData: MutableLiveData<SavedCatsState> = MutableLiveData()
    val stateLiveData: LiveData<SavedCatsState> = stateMutableLiveData

    init {
        getSavedCats()
    }

    private fun getSavedCats() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val catsResult = useCase()
                catsResult
                    .onStart { stateMutableLiveData.postValue(SavedCatsState.Loading) }
                    .catch { stateMutableLiveData.postValue(SavedCatsState.Error) }
                    .collect { stateMutableLiveData.postValue(SavedCatsState.ShowingSavedCats(it)) }
            }
        }
    }
}