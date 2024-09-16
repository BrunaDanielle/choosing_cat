package com.example.choosingcat.randomcat.presentation

import androidx.lifecycle.Observer
import com.example.choosingcat.InstantExecutorExtension
import com.example.choosingcat.MainCoroutineExtension
import com.example.choosingcat.fixtures.Fixture.catDomain
import com.example.choosingcat.randomcat.domain.GetRandomCatUseCase
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verifyOrder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@OptIn(ExperimentalCoroutinesApi::class)
@ExtendWith(MainCoroutineExtension::class, InstantExecutorExtension::class)
class RandomCatViewModelTest {

    private lateinit var useCase: GetRandomCatUseCase
    private lateinit var viewModel: RandomCatViewModel
    private lateinit var observer: Observer<RandomCatState>

    @BeforeEach
    fun setUp() {
        useCase = mockk(relaxed = true)
        observer = mockk(relaxed = true)
        viewModel = RandomCatViewModel(useCase)
        viewModel.stateLiveData.observeForever(observer)
    }

    @Test
    fun `searchCat should send loading and showingRandomCat state`() = runTest {
        val flowOfCat = flowOf(catDomain)
        coEvery { useCase() } returns flowOfCat

        viewModel.searchCat()

        verifyOrder {
            observer.onChanged(RandomCatState.Loading)
            observer.onChanged(RandomCatState.ShowingRandomCat(catDomain))
        }
    }

    @Test
    fun `stateLiveData is initially empty`() {
        assertTrue(viewModel.stateLiveData.value == null)
    }
}