package com.example.choosingcat.randomcat.data.repository

import app.cash.turbine.test
import com.example.choosingcat.randomcat.domain.RandomCatRepository
import com.example.choosingcat.randomcat.domain.model.Cat
import io.mockk.*
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

internal class RandomCatRepositoryImplTest {
    private val mockedRemoteDataSource: RandomCatRemoteDataSource = mockk()
    private val mockedLocalDataSource: RandomCatLocalDataSource = mockk()

    private val repository: RandomCatRepository = RandomCatRepositoryImpl(
        remoteDataSource = mockedRemoteDataSource,
        localDataSource = mockedLocalDataSource
    )

    @Test
    fun getRandomCatShouldGetCatFromService() = runBlocking {
        // Given
        val randomCat = Cat(
            id = "1",
            catPhotoUrl = "url.com"
        )
        every { mockedRemoteDataSource.getRandomCat() } answers {
            flowOf(randomCat)
        }

        coEvery { mockedLocalDataSource.insertRandomCat(randomCat) } just Runs

        //When
        val result = repository.getRandomCat()

        // Then
        result.test{
            assertEquals(randomCat, expectMostRecentItem())
            awaitComplete()
        }
    }
}