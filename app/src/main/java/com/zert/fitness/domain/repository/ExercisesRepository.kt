package com.zert.fitness.domain.repository

import com.zert.fitness.data.data_source.entities.Exercises
import kotlinx.coroutines.flow.Flow

interface ExercisesRepository {
    fun getTests(): Flow<List<Exercises>>

    suspend fun getTestsByNode(node: String): Exercises?

    suspend fun insertTest(tests: Exercises)

    suspend fun deleteTest(tests: Exercises)

    suspend fun clearAllTests()
}