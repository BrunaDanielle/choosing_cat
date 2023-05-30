package com.example.choosingcat.randomcat.data.remote

import app.cash.turbine.test
import com.example.choosingcat.randomcat.data.remote.api.RandomCatApi
import com.example.choosingcat.randomcat.data.remote.model.RandomCatResponse
import com.example.choosingcat.randomcat.data.repository.RandomCatRemoteDataSource
import com.example.choosingcat.randomcat.domain.model.Cat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

internal class RandomCatRemoteDataSourceImplTest {
    private val mockedService: RandomCatApi = mockk()
    private val remoteDataSource: RandomCatRemoteDataSource = RandomCatRemoteDataSourceImpl(
        mockedService
    )

    @Test
    fun getRandomCatShouldReturnACatWhenRequestCompleted() = runBlocking {
        //Given
        val catResponse = RandomCatResponse(
            id = "1",
            catPhotoUrl = "url.com",
            imgHeight = 2,
            imgWidth = 3
        )

        val cat = Cat(
            id = "1",
            catPhotoUrl = "url.com",
        )

        coEvery { mockedService.getCat() } answers { listOf(catResponse) }

        // When
        val result = remoteDataSource.getRandomCat()

        // Then
        result.test {
            assertEquals(cat, expectMostRecentItem())
            awaitComplete()
        }
    }

    @Test
    fun getRandomCatShouldReturnExceptionWhenRequestFails() = runBlocking {
        //Given
        coEvery { mockedService.getCat() } answers { listOf() }

        // When
        val result = remoteDataSource.getRandomCat()

        // Then
        result.test {
            assertEquals("Api não retornou nenhum gato", awaitError().message)
        }
    }
}