package com.example.choosingcat.randomcat.data.remote.mappers

import com.example.choosingcat.fixtures.Fixture.catDomain
import com.example.choosingcat.fixtures.Fixture.randomCatResponse
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class RandomCatMapperImplTest {
    private val mapper = RandomCatMapperImpl()

    @TestFactory
    fun `should maps model correctly`(): List<DynamicTest> {
        return scenarios
            .map { (actual, expected) ->
                dynamicTest(
                    "should mapper response model $actual to domain model $expected"
                ) {
                    assertEquals(expected, mapper.map(actual))
                }
            }
    }

    private val scenarios = listOf(
        randomCatResponse to catDomain,
        randomCatResponse.copy(
            id = null,
            catPhotoUrl = null
        ) to catDomain.copy(
            "",
            catPhotoUrl = ""
        )
    )
}