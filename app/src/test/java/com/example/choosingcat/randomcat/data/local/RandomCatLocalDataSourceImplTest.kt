package com.example.choosingcat.randomcat.data.local

import com.example.choosingcat.randomcat.data.local.database.dao.RandomCatDAO
import com.example.choosingcat.randomcat.data.local.database.model.RandomCatEntity
import com.example.choosingcat.randomcat.domain.model.Cat
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class RandomCatLocalDataSourceImplTest {
    private val mockedDAO: RandomCatDAO = mockk()

    private val localDataSource = RandomCatLocalDataSourceImpl(mockedDAO)

    @Test
    fun insertShouldSaveCat() = runBlocking {
        //Given
        coEvery { mockedDAO.insert(any()) } just Runs

        //When
        localDataSource.insertRandomCat(
            Cat(
                id = "1",
                catPhotoUrl = "url.com"
            )
        )

        //Then
        coVerify(inverse = true) {
            mockedDAO.insert(
                RandomCatEntity(
                    id = "1",
                    catPhotoUrl = "url.com"
                )
            )
        }
    }
}