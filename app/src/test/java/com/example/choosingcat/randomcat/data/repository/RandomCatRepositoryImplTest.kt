package com.example.choosingcat.randomcat.data.repository

import app.cash.turbine.test
import com.example.choosingcat.fixtures.Fixture.catDomain
import com.example.choosingcat.randomcat.domain.RandomCatRepository
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
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
    fun `getRandomCat should get cat from service`() = runBlocking {
        every { mockedRemoteDataSource.getRandomCat() } answers {
            flowOf(catDomain)
        }

        coEvery { mockedLocalDataSource.insertRandomCat(catDomain) } just Runs

        val result = repository.getRandomCat()

        result.test{
            assertEquals(catDomain, expectMostRecentItem())
            awaitComplete()
        }
    }
}