package com.example.choosingcat.randomcat.data.local.mapper

import com.example.choosingcat.fixtures.Fixture.catDomain
import com.example.choosingcat.fixtures.Fixture.expectedCatEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory

class CatEntityMapperImplTest {
    private val mapper = CatEntityMapperImpl()

    @TestFactory
    fun `should maps model correctly`(): List<DynamicTest> {
        return scenarios
            .map { (actual, expected) ->
                dynamicTest(
                    "should mapper model $actual to entity model $expected"
                ) {
                    assertEquals(expected, mapper.map(actual))
                }
            }
    }

    private val scenarios = listOf(
        catDomain to expectedCatEntity
    )
}