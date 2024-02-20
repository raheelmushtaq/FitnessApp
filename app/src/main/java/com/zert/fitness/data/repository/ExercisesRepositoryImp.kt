package com.zert.fitness.data.repository

import com.zert.fitness.data.data_source.dao.ExercisesDao
import com.zert.fitness.data.data_source.entities.Exercises
import com.zert.fitness.domain.repository.ExercisesRepository
import kotlinx.coroutines.flow.Flow

class ExercisesRepositoryImp(private val testDao: ExercisesDao) : ExercisesRepository {
    override fun getTests(): Flow<List<Exercises>> {
        return testDao.getTests()
    }

    override suspend fun getTestsByNode(node: String): Exercises? {
        return testDao.getTestsByNode(node)
    }

    override suspend fun insertTest(tests: Exercises) {
        return testDao.insertTest(tests)
    }

    override suspend fun deleteTest(tests: Exercises) {
        return testDao.deleteTest(tests)
    }

    override suspend fun clearAllTests() {
        return testDao.clearAllTests()
    }
}