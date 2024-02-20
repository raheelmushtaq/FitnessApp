package com.zert.fitness.data.data_source.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zert.fitness.data.data_source.entities.Exercises
import kotlinx.coroutines.flow.Flow

@Dao
interface ExercisesDao {
    @Query("select * from Tests")
    fun getTests(): Flow<List<Exercises>>

    @Query("select * from Tests where nodeName = :node")
    suspend fun getTestsByNode(node: String): Exercises?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTest(tests: Exercises)

    @Delete()
    suspend fun deleteTest(tests: Exercises)

    @Query("DELETE FROM Tests")
    suspend fun clearAllTests()
}