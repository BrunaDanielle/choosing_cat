package com.example.choosingcat.randomcat.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.choosingcat.randomcat.domain.GetRandomCatUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RandomCatViewModel(
    private val useCase: GetRandomCatUseCase
) : ViewModel() {
    private val stateMutableLiveData: MutableLiveData<RandomCatState> = MutableLiveData()
    val stateLiveData: LiveData<RandomCatState> = stateMutableLiveData

    private val actionMutableLiveData: MutableLiveData<RandomCatAction> = MutableLiveData()
    val actionLiveData: LiveData<RandomCatAction> = actionMutableLiveData

    init {
        searchCat()
    }

    fun searchCat() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val catsResult = useCase()
                catsResult
                    .onStart { stateMutableLiveData.postValue(RandomCatState.Loading) }
                    .catch { stateMutableLiveData.postValue(RandomCatState.Error) }
                    .collect { stateMutableLiveData.postValue(RandomCatState.ShowingRandomCat(it)) }
            }
        }
    }


    fun onOpenSavedCatsView() {
        actionMutableLiveData.value = RandomCatAction.OpenSavedCatsView
    }

    fun onReloadData() {
        searchCat()
    }
}