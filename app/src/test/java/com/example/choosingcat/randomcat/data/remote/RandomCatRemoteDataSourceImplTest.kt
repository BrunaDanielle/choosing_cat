package com.example.choosingcat.randomcat.data.remote

import app.cash.turbine.test
import com.example.choosingcat.fixtures.Fixture.catDomain
import com.example.choosingcat.fixtures.Fixture.randomCatResponse
import com.example.choosingcat.randomcat.data.remote.api.RandomCatApi
import com.example.choosingcat.randomcat.data.remote.mappers.RandomCatMapper
import com.example.choosingcat.randomcat.data.repository.RandomCatRemoteDataSource
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RandomCatRemoteDataSourceImplTest {
    private val mockedService: RandomCatApi = mockk()
    private val mockedMapper: RandomCatMapper = mockk()
    private val remoteDataSource: RandomCatRemoteDataSource = RandomCatRemoteDataSourceImpl(
        mockedService,
        mockedMapper
    )

    @Test
    fun `getRandomCat should return a cat when request completed`() = runTest {
        coEvery { mockedService.getCat() } answers { listOf(randomCatResponse) }
        every { mockedMapper.map(any()) } returns catDomain

        val result = remoteDataSource.getRandomCat()

        result.test {
            assertEquals(catDomain, expectMostRecentItem())
            awaitComplete()
        }
    }

    @Test
    fun `getRandomCat should return exception when request fails`() = runTest {
        coEvery { mockedService.getCat() } answers { listOf() }

        val result = remoteDataSource.getRandomCat()

        result.test {
            assertEquals("Api não retornou nenhum gato", awaitError().message)
        }
    }
}