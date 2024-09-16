package com.example.choosingcat.randomcat.presentation

import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.choosingcat.randomcat.domain.GetRandomCatUseCase
import com.example.choosingcat.randomcat.domain.model.Cat
import com.example.choosingcat.randomcat.presentation.robot.RandomCatRobot
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.flow.flowOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class RandomCatActivityTest  {

    private lateinit var robot: RandomCatRobot
    private lateinit var koinModule: Module
    private lateinit var viewModel: RandomCatViewModel
    private lateinit var useCase: GetRandomCatUseCase
    private lateinit var _stateLiveData1: MutableLiveData<RandomCatState>
    private lateinit var actionLiveData: MutableLiveData<RandomCatAction>

    @get:Rule
    val activityRule = ActivityScenarioRule(RandomCatActivity::class.java)

    @Before
    fun setUp() {
        robot = RandomCatRobot()
        useCase = mockk(relaxed = true)
        _stateLiveData1 = MutableLiveData()
        actionLiveData = MutableLiveData()

        viewModel = mockk<RandomCatViewModel>(relaxed = true){
            every { stateLiveData } answers { _stateLiveData1 }
            every { searchCat() } just runs
        }

        koinModule = module {
            factory { useCase }
            viewModel { viewModel }
        }
        loadKoinModules(koinModule)
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun testSuccessStateIsVisible() {
        _stateLiveData1.postValue(RandomCatState.Loading)
        activityRule.scenario.onActivity { activity ->
            activity.runOnUiThread {
                viewModel.searchCat()
            }
        }

        robot.checkLoadingIsDisplayed()
    }

    @Test
    fun testSuccessStateIsVisible2() {
        val catDomain = Cat(id = "1", catPhotoUrl = "https://example.com/cat.jpg")
        every { useCase.invoke() } returns flowOf(catDomain)
        _stateLiveData1.postValue(RandomCatState.ShowingRandomCat(catDomain))
        activityRule.scenario.onActivity { activity ->
            activity.runOnUiThread {
                viewModel.searchCat()
            }
        }

        robot.checkImageIsDisplayed()
        robot.checkTitleIsDisplayed("1")
    }
}