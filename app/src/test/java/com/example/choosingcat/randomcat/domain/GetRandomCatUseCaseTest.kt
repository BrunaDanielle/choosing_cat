package com.example.choosingcat.randomcat.domain

import com.example.choosingcat.fixtures.Fixture.catDomain
import com.example.choosingcat.randomcat.domain.model.Cat
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetRandomCatUseCaseTest {
    private lateinit var repository: RandomCatRepository
    private lateinit var useCase: GetRandomCatUseCase

    @BeforeEach
    fun setUp() {
        repository = mockk()
        useCase = GetRandomCatUseCase(repository)
    }

    @Test
    fun `invoke should returns Flow from repository`() = runTest {
        val flowOfCat: Flow<Cat> = flowOf(catDomain)

        every { repository.getRandomCat() } returns flowOfCat

        val resultFlow = useCase()

        resultFlow.collect { resultCat ->
            assertEquals(catDomain, resultCat)
        }

        verify { repository.getRandomCat() }
    }
}