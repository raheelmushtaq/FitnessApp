package com.zert.fitness.di

import com.zert.fitness.data.data_source.database.FitnessAppDatabase
import com.zert.fitness.data.repository.ExercisesRepositoryImp
import com.zert.fitness.domain.repository.ExercisesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModules {
    @Provides
    @Singleton
    fun provideTestsRepository(database: FitnessAppDatabase): ExercisesRepository {
        return ExercisesRepositoryImp(database.testDao)
    }
}