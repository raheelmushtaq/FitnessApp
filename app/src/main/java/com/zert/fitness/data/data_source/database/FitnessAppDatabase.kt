package com.zert.fitness.data.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zert.fitness.data.data_source.dao.ExercisesDao
import com.zert.fitness.data.data_source.entities.Exercises

@Database(
    entities = [Exercises::class],
    version = 1
)
abstract class FitnessAppDatabase : RoomDatabase() {
    abstract val testDao: ExercisesDao

    companion object {
        val DATABASE_NAME: String = "FitnessDatabase"
    }
}