package com.example.choosingcat.randomcat.data.local

import com.example.choosingcat.common.data.local.database.dao.CatDAO
import com.example.choosingcat.fixtures.Fixture.catDomain
import com.example.choosingcat.fixtures.Fixture.expectedCatEntity
import com.example.choosingcat.randomcat.data.local.mapper.CatEntityMapper
import com.example.choosingcat.randomcat.data.repository.RandomCatLocalDataSource
import io.mockk.Runs
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RandomCatLocalDataSourceImplTest {
    private val mockedDAO: CatDAO = mockk()
    private val mockedMapper: CatEntityMapper = mockk()

    private lateinit var localDataSource: RandomCatLocalDataSource

    @BeforeEach
    fun setUp() {
        localDataSource = RandomCatLocalDataSourceImpl(mockedDAO, mockedMapper)
    }

    @Test
    fun `insertRandomCat should save cat`() = runTest {
        coEvery { mockedDAO.insert(any()) } just Runs
        every { mockedMapper.map(any()) } returns expectedCatEntity

        localDataSource.insertRandomCat(catDomain)

        coVerify {
            mockedDAO.insert(expectedCatEntity)
        }
    }

    @AfterEach
    fun tearDown() {
        clearAllMocks()
    }
}