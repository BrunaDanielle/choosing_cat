package com.example.choosingcat.randomcat.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.choosingcat.randomcat.domain.GeRandomCatUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class RandomCatViewModel(
    private val useCase: GeRandomCatUseCase
) : ViewModel() {
    private val stateMutableLiveData: MutableLiveData<RandomCatState> = MutableLiveData()
    val stateLiveData: LiveData<RandomCatState> = stateMutableLiveData

    init {
        searchCat()
    }

    fun searchCat() {
        viewModelScope.launch {
            val catsResult = useCase()
            catsResult
                .onStart { stateMutableLiveData.postValue(RandomCatState.Loading) }
                .catch { stateMutableLiveData.postValue(RandomCatState.Error) }
                .collect { stateMutableLiveData.postValue(RandomCatState.ShowingRandomCat(it)) }
        }
    }
}